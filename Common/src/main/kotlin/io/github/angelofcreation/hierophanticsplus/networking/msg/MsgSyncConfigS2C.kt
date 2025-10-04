package io.github.angelofcreation.hierophanticsplus.networking.msg

import io.github.angelofcreation.hierophanticsplus.config.HierophanticsPlusServerConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: HierophanticsPlusServerConfig.ServerConfig) : HierophanticsPlusMessageS2C {
    companion object : HierophanticsPlusMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = HierophanticsPlusServerConfig.ServerConfig().decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
