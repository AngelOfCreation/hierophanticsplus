package io.github.angelofcreation.hierophanticsplus.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.angelofcreation.hierophanticsplus.config.HierophanticsPlusServerConfig
import io.github.angelofcreation.hierophanticsplus.networking.msg.*

fun HierophanticsPlusMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HierophanticsPlusServerConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
