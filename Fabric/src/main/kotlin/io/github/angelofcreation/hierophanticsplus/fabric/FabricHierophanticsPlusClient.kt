package io.github.angelofcreation.hierophanticsplus.fabric

import io.github.angelofcreation.hierophanticsplus.HierophanticsPlusClient
import net.fabricmc.api.ClientModInitializer

object FabricHierophanticsPlusClient : ClientModInitializer {
    override fun onInitializeClient() {
        HierophanticsPlusClient.init()
    }
}
