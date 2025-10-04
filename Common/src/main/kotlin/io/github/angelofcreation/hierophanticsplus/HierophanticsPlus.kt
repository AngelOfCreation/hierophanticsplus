package io.github.angelofcreation.hierophanticsplus

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.angelofcreation.hierophanticsplus.config.HierophanticsPlusServerConfig
import io.github.angelofcreation.hierophanticsplus.networking.HierophanticsPlusNetworking
import io.github.angelofcreation.hierophanticsplus.registry.HierophanticsPlusActions

object HierophanticsPlus {
    const val MODID = "hierophantics_plus"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HierophanticsPlusServerConfig.init()
        initRegistries(
            HierophanticsPlusActions,
        )
        HierophanticsPlusNetworking.init()
    }

    fun initServer() {
        HierophanticsPlusServerConfig.initServer()
    }
}
