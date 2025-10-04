package io.github.angelofcreation.hierophanticsplus.fabric

import io.github.angelofcreation.hierophanticsplus.HierophanticsPlus
import net.fabricmc.api.DedicatedServerModInitializer

object FabricHierophanticsPlusServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        HierophanticsPlus.initServer()
    }
}
