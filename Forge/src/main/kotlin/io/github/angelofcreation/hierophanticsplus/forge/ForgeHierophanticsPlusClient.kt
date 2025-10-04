package io.github.angelofcreation.hierophanticsplus.forge

import io.github.angelofcreation.hierophanticsplus.HierophanticsPlusClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeHierophanticsPlusClient {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLClientSetupEvent) {
        HierophanticsPlusClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> HierophanticsPlusClient.getConfigScreen(parent) }
        }
    }
}
