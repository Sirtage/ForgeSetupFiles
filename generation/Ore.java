package net.sirtage.content.generations;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.sirtage.reg.Register;

public class Ore {

    public static void generateMySuperOres(final BiomeLoadingEvent e) {
        for (OreType ore: OreType.values()) {
            OreFeatureConfig oreFeatureCFG = new OreFeatureConfig(
                    new TagMatchRuleTest(Register.content.CHUNKIUM_GEN), ore.getBlock().get().getDefaultState(), ore.getMaxVein()
            );

            ConfiguredPlacement<TopSolidRangeConfig> configPlace = Placement.RANGE.configure(
                    new TopSolidRangeConfig(ore.getMinH(), ore.getMinH(), ore.getMaxH())
            );

            ConfiguredFeature<?, ?> oreFeature = register(ore, oreFeatureCFG, configPlace);

            e.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
        }
    }

    private static ConfiguredFeature<?, ?> register(OreType ore, OreFeatureConfig cfg, ConfiguredPlacement plcfg) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(),
                Feature.ORE.withConfiguration(cfg).withPlacement(plcfg).square()
        );
    }
}
