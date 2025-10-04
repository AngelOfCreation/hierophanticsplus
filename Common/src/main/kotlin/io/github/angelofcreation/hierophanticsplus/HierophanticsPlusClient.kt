package io.github.angelofcreation.hierophanticsplus

import io.github.angelofcreation.hierophanticsplus.config.HierophanticsPlusClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HierophanticsPlusClient {
    fun init() {
        HierophanticsPlusClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(HierophanticsPlusClientConfig.GlobalConfig::class.java, parent).get()
    }
}
