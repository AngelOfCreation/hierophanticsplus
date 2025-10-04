@file:JvmName("HierophanticsPlusAbstractionsImpl")

package io.github.angelofcreation.hierophanticsplus.forge

import io.github.angelofcreation.hierophanticsplus.registry.HierophanticsPlusRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HierophanticsPlusRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
