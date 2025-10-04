package io.github.angelofcreation.hierophanticsplus.networking

import dev.architectury.networking.NetworkChannel
import io.github.angelofcreation.hierophanticsplus.HierophanticsPlus
import io.github.angelofcreation.hierophanticsplus.networking.msg.HierophanticsPlusMessageCompanion

object HierophanticsPlusNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(HierophanticsPlus.id("networking_channel"))

    fun init() {
        for (subclass in HierophanticsPlusMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
