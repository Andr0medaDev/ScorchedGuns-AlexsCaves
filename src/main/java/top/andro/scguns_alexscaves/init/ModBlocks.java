package top.andro.scguns_alexscaves.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import top.andro.scguns_alexscaves.SCGunsAC;

import java.util.function.Function;
import java.util.function.Supplier;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> POLYMER_PLATE_BLOCK = registerBlock("polymer_plate_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F)));
    public static final RegistryObject<Block> CHISELED_POLYMER_PLATE_BLOCK = registerBlock("chiseled_polymer_plate_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F)));
    public static final RegistryObject<Block> CUT_POLYMER_PLATE = registerBlock("cut_polymer_plate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER)
                    .requiresCorrectToolForDrops()
                    .strength(2.5F)));

    public static final RegistryObject<Block> POLYMER_PLATE_LAMP = registerBlock("polymer_plate_lamp",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.REDSTONE_LAMP).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F)
                    .lightLevel((state) -> 15)));

    public static final RegistryObject<Block> CUT_POLYMER_PLATE_SLAB = registerBlock("cut_polymer_plate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER)
                    .requiresCorrectToolForDrops()
                    .strength(2.5F)));
    public static final RegistryObject<Block> CUT_POLYMER_PLATE_STAIRS = registerBlock("cut_polymer_plate_stairs",
            () -> new StairBlock(() -> ModBlocks.CUT_POLYMER_PLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER)
                    .requiresCorrectToolForDrops()
                    .strength(2.5F)));

    public static final RegistryObject<Block> POLYMER_PLATES = registerBlock("polymer_plates",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F)));
    public static final RegistryObject<Block> POLYMER_PLATE_BARS = registerBlock("polymer_plate_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.COPPER)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F)
                    .noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
