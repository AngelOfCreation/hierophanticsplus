package io.github.angelofcreation.hierophanticsplus.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.angelofcreation.hierophanticsplus.HierophanticsPlus
import io.github.angelofcreation.hierophanticsplus.networking.HierophanticsPlusNetworking
import io.github.angelofcreation.hierophanticsplus.networking.handler.applyOnClient
import io.github.angelofcreation.hierophanticsplus.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HierophanticsPlusMessage

sealed interface HierophanticsPlusMessageC2S : HierophanticsPlusMessage {
    fun sendToServer() {
        HierophanticsPlusNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HierophanticsPlusMessageS2C : HierophanticsPlusMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HierophanticsPlusNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HierophanticsPlusNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HierophanticsPlusMessageCompanion<T : HierophanticsPlusMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                HierophanticsPlus.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HierophanticsPlusMessageC2S -> msg.applyOnServer(ctx)
                    else -> HierophanticsPlus.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                HierophanticsPlus.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HierophanticsPlusMessageS2C -> msg.applyOnClient(ctx)
                    else -> HierophanticsPlus.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
