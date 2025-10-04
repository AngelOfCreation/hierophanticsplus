@file:JvmName("HierophanticsPlusAbstractionsImpl")

package io.github.angelofcreation.hierophanticsplus.fabric

import io.github.angelofcreation.hierophanticsplus.registry.HierophanticsPlusRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HierophanticsPlusRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
