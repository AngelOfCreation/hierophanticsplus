package io.github.angelofcreation.hierophanticsplus.fabric.datagen

import io.github.angelofcreation.hierophanticsplus.datagen.HierophanticsPlusActionTags
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object FabricHierophanticsPlusDatagen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack = gen.createPack()

        pack.addProvider(::HierophanticsPlusActionTags)
    }
}
