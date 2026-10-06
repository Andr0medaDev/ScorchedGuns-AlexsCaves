package top.andro.scguns_alexscaves.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import top.andro.scguns_alexscaves.init.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.POLYMER_PLATE_BLOCK.get());
        this.dropSelf(ModBlocks.CHISELED_POLYMER_PLATE_BLOCK.get());
        this.dropSelf(ModBlocks.POLYMER_PLATES.get());
        this.dropSelf(ModBlocks.POLYMER_PLATE_LAMP.get());
        this.dropSelf(ModBlocks.CUT_POLYMER_PLATE.get());
        this.dropSelf(ModBlocks.CUT_POLYMER_PLATE_STAIRS.get());
        this.dropSelf(ModBlocks.CUT_POLYMER_PLATE_SLAB.get());
        this.dropSelf(ModBlocks.POLYMER_PLATE_BARS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}