package io.github.angelofcreation.hierophanticsplus.forge

import io.github.angelofcreation.hierophanticsplus.HierophanticsPlus
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeHierophanticsPlusServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        HierophanticsPlus.initServer()
    }
}
