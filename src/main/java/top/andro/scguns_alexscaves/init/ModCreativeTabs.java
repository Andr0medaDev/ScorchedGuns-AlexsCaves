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

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SCGunsAC.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SCGUNS_ALEXSCAVES = CREATIVE_MODE_TABS.register("scguns_alexscaves",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TOXIC_CARBINE.get()))
                    .title(Component.translatable("scguns_alexscaves_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TOXIC_CARBINE.get());
                        pOutput.accept(ModItems.TOXIC_LMG.get());
                        pOutput.accept(ModItems.ACID_SHOTGUN.get());
                        pOutput.accept(ModItems.ACID_PISTOL.get());

                        pOutput.accept(ModItems.HALIBUT_CANNON.get());
                        pOutput.accept(ModItems.ABYSSAL_SMG.get());
                        pOutput.accept(ModItems.ABYSSAL_LMG.get());
                        pOutput.accept(ModItems.SPEAR_GUN.get());

                        pOutput.accept(ModItems.DUAL_PISTOL.get());
                        pOutput.accept(ModItems.REDSTONE_REPEATER.get());

                        pOutput.accept(ModItems.URANIUM_CELL.get());
                        pOutput.accept(ModItems.ACID_TANK.get());
                        pOutput.accept(ModItems.TOXIC_BLUEPRINT.get());
                        pOutput.accept(ModItems.ANTHRALITE_SPEAR.get());

                        pOutput.accept(ModItems.POLYMER_GUN_FRAME.get());


                    })
                    .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}