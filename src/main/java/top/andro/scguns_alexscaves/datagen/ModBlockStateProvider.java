package top.andro.scguns_alexscaves.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.andro.scguns_alexscaves.init.ModBlocks;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.POLYMER_PLATE_BLOCK);
        blockWithItem(ModBlocks.CHISELED_POLYMER_PLATE_BLOCK);
        blockWithItem(ModBlocks.POLYMER_PLATES);
        blockWithItem(ModBlocks.POLYMER_PLATE_LAMP);
        blockWithItem(ModBlocks.CUT_POLYMER_PLATE);
        stairsBlock((StairBlock) ModBlocks.CUT_POLYMER_PLATE_STAIRS.get(), blockTexture(ModBlocks.CUT_POLYMER_PLATE.get()));
        slabBlock(((SlabBlock) ModBlocks.CUT_POLYMER_PLATE_SLAB.get()), blockTexture(ModBlocks.CUT_POLYMER_PLATE.get()), blockTexture(ModBlocks.CUT_POLYMER_PLATE.get()));
        paneBlock((IronBarsBlock) ModBlocks.POLYMER_PLATE_BARS.get(),
                modLoc("block/polymer_plate_bars"),        // texture for pane
                modLoc("block/polymer_plate_bars_top"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}