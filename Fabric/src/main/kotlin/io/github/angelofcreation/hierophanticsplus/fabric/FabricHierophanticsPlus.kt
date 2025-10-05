package io.github.angelofcreation.hierophanticsplus.fabric

import io.github.angelofcreation.hierophanticsplus.HierophanticsPlus
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback
import java.rmi.registry.Registry

object FabricHierophanticsPlus : ModInitializer {
    override fun onInitialize() {
        HierophanticsPlus.init()
    }
}
