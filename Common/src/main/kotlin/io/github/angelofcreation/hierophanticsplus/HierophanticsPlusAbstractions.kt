@file:JvmName("HierophanticsPlusAbstractions")

package io.github.angelofcreation.hierophanticsplus

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.angelofcreation.hierophanticsplus.registry.HierophanticsPlusRegistrar

fun initRegistries(vararg registries: HierophanticsPlusRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HierophanticsPlusRegistrar<T>) {
    throw AssertionError()
}
