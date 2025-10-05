package io.github.angelofcreation.hierophanticsplus.registry

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.castables.Action
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.HexRegistries
import dev.architectury.registry.registries.DeferredRegister
import io.github.angelofcreation.hierophanticsplus.HierophanticsPlus
import robotgiggle.hierophantics.patterns.OpMakeTrigger

object HierophanticsPlusPatterns {
    val ACTIONS: DeferredRegister<ActionRegistryEntry> = DeferredRegister.create(HierophanticsPlus.MODID,
        HexRegistries.ACTION)

    private fun register(name: String, signature: String, startDir: HexDir, action: Action) {
        ACTIONS.register(name, {-> ActionRegistryEntry(HexPattern.fromAngles(signature, startDir), action)})
    }

    @JvmStatic
    fun init() {
        register("make_tick_trigger", "qqqqqawwdaaeaa", HexDir.SOUTH_EAST, OpMakeTrigger("tick"))

        ACTIONS.register()
    }
}
