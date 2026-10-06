package top.andro.scguns_alexscaves.worldgen;

import com.github.alexmodguy.alexscaves.server.level.biome.ACBiomeRegistry;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import top.andro.scguns_alexscaves.init.ModEntities;

import java.util.List;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> SPAWN_RAD_AGENT = registerKey("spawn_rad_agent");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_RAD_AGENT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ACBiomeRegistry.TOXIC_CAVES)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.RAD_AGENT.get(), 25, 3, 5))));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
    }
}
