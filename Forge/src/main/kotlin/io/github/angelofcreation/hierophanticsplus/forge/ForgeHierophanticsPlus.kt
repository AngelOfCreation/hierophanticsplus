package io.github.angelofcreation.hierophanticsplus.forge

import dev.architectury.platform.forge.EventBuses
import io.github.angelofcreation.hierophanticsplus.HierophanticsPlus
import io.github.angelofcreation.hierophanticsplus.forge.datagen.ForgeHierophanticsPlusDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(HierophanticsPlus.MODID)
class ForgeHierophanticsPlus {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(HierophanticsPlus.MODID, this)
            addListener(ForgeHierophanticsPlusClient::init)
            addListener(ForgeHierophanticsPlusDatagen::init)
            addListener(ForgeHierophanticsPlusServer::init)
        }
        HierophanticsPlus.init()
    }
}
