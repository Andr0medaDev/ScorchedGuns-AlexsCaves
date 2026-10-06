package top.andro.scguns_alexscaves.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import top.andro.scguns_alexscaves.SCGunsAC;
import top.andro.scguns_alexscaves.init.ModItems;

import static top.ribs.scguns.init.ModCreativeModeTabs.CreativeTabHelper.addItemWithFullAmmo;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SCGunsAC.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SCGUNS_ALEXSCAVES_TAB = CREATIVE_MODE_TAB.register("scguns_alexscaves_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ATOMIC_CARABINE.get()))
                    .title(Component.translatable("creativetab.scguns_alexscaves_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        addItemWithFullAmmo(pOutput, ModItems.ATOMIC_CARABINE.get());
                        addItemWithFullAmmo(pOutput, ModItems.FISSION_FEVER.get());
                        addItemWithFullAmmo(pOutput, ModItems.GENESIS.get());
                        addItemWithFullAmmo(pOutput, ModItems.FOUL_EMESIS.get());
                        addItemWithFullAmmo(pOutput, ModItems.CORRODER.get());
                        addItemWithFullAmmo(pOutput, ModItems.ACID_SPRAYER.get());

                        addItemWithFullAmmo(pOutput, ModItems.HALIBUT_CANNON.get());
                        addItemWithFullAmmo(pOutput, ModItems.SEA_SERPENT.get());
                        addItemWithFullAmmo(pOutput, ModItems.ELVER_TIDE.get());
                        addItemWithFullAmmo(pOutput, ModItems.MORAY_TIDE.get());
                        addItemWithFullAmmo(pOutput, ModItems.MAHI.get());
                        addItemWithFullAmmo(pOutput, ModItems.NEPTUNES_BOUNTY.get());

                        addItemWithFullAmmo(pOutput, ModItems.EBONY_IVORY.get());
                        addItemWithFullAmmo(pOutput, ModItems.DRAGONFLY.get());
                        addItemWithFullAmmo(pOutput, ModItems.ECLIPSE.get());
                        addItemWithFullAmmo(pOutput, ModItems.REDSTONE_REPEATER.get());
                        addItemWithFullAmmo(pOutput, ModItems.SAURON.get());
                        addItemWithFullAmmo(pOutput, ModItems.GUANO_CANNON.get());

                        pOutput.accept(ModItems.URANIUM_CELL.get());
                        pOutput.accept(ModItems.ACID_TANK.get());
                        pOutput.accept(ModItems.BRASS_BULLET.get());
                        pOutput.accept(ModItems.ACIDIC_SOLUTION.get());
                        pOutput.accept(ModItems.ATOMIC_BLUEPRINT.get());
                        pOutput.accept(ModItems.ABYSSAL_BLUEPRINT.get());
                        pOutput.accept(ModItems.FORLORN_BLUEPRINT.get());

                        pOutput.accept(ModItems.BARIC_ALLOY_BLEND.get());
                        pOutput.accept(ModItems.BARIC_ALLOY.get());
                        pOutput.accept(ModItems.BARIC_ALLOY_GUN_FRAME.get());
                        pOutput.accept(ModItems.POLYMER_GUN_FRAME.get());

                        pOutput.accept(ModItems.RAD_AGENT_SPAWN_EGG.get());

                        pOutput.accept(ModBlocks.POLYMER_PLATE_BLOCK.get());
                        pOutput.accept(ModBlocks.CHISELED_POLYMER_PLATE_BLOCK.get());
                        pOutput.accept(ModBlocks.POLYMER_PLATES.get());
                        pOutput.accept(ModBlocks.CUT_POLYMER_PLATE.get());
                        pOutput.accept(ModBlocks.CUT_POLYMER_PLATE_STAIRS.get());
                        pOutput.accept(ModBlocks.CUT_POLYMER_PLATE_SLAB.get());
                        pOutput.accept(ModBlocks.POLYMER_PLATE_LAMP.get());
                        pOutput.accept(ModBlocks.POLYMER_PLATE_BARS.get());
                        pOutput.accept(ModBlocks.POLYMER_PLATE_BARS.get());




                    })
                    .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}