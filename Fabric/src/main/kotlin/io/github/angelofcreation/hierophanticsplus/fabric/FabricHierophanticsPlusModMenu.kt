package io.github.angelofcreation.hierophanticsplus.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.angelofcreation.hierophanticsplus.HierophanticsPlusClient

object FabricHierophanticsPlusModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HierophanticsPlusClient::getConfigScreen)
}
