package top.andro.scguns_alexscaves.init;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.andro.scguns_alexscaves.SCGunsAC;
import top.ribs.scguns.common.item.gun.AbyssalGunItem;
import top.ribs.scguns.common.item.gun.AcidGunItem;
import top.ribs.scguns.common.item.gun.RadioactiveGunItem;
import top.ribs.scguns.init.ModSounds;
import top.ribs.scguns.item.AmmoItem;
import top.ribs.scguns.item.BlueprintItem;
import top.ribs.scguns.item.animated.AnimatedGunItem;

public class ModItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, SCGunsAC.MOD_ID);

    //public static final Rarity RARITY_MAGNETIC = Rarity.create("scguns_alexscaves:magnetic", ChatFormatting.DARK_RED);
    //public static final Rarity RARITY_PRIMORDIAL = Rarity.create("scguns_alexscaves:primordial", style -> style.withColor(0xff9b682a));
    public static final Rarity RARITY_RADIOACTIVE = Rarity.create("scguns_alexscaves:radioactive", style -> style.withColor(0xff00be00));
    public static final Rarity RARITY_ABYSSAL = Rarity.create("scguns_alexscaves:abyssal", ChatFormatting.DARK_BLUE);
    //public static final Rarity RARITY_FORLORN = Rarity.create("scguns_alexscaves:forlorn", ChatFormatting.DARK_RED);

    //GUNS
    public static final RegistryObject<AnimatedGunItem> TOXIC_CARBINE = REGISTER.register("toxic_carbine",
            () -> new RadioactiveGunItem(
                    new Item.Properties().stacksTo(1).durability(1000).rarity(RARITY_RADIOACTIVE),
                    "toxic_carbine", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );

    public static final RegistryObject<AnimatedGunItem> ACID_SHOTGUN = REGISTER.register("acid_shotgun",
            () -> new AcidGunItem(
                    new Item.Properties().stacksTo(1).durability(1000).rarity(RARITY_RADIOACTIVE),
                    "acid_shotgun", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );

    public static final RegistryObject<AnimatedGunItem> ACID_PISTOL = REGISTER.register("acid_pistol",
            () -> new AcidGunItem(
                    new Item.Properties().stacksTo(1).durability(1000).rarity(RARITY_RADIOACTIVE),
                    "acid_pistol", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );
    public static final RegistryObject<AnimatedGunItem> HALIBUT_CANNON = REGISTER.register("halibut_cannon",
            () -> new AbyssalGunItem(
                    new Item.Properties().stacksTo(1).durability(1000).rarity(RARITY_ABYSSAL),
                    "halibut_cannon", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );

    //AMMO
    public static final RegistryObject<Item> URANIUM_CELL = REGISTER.register("uranium_cell", () -> new AmmoItem(new Item.Properties()));

    //BLUEPRINTS
    public static final RegistryObject<Item> URANIUM_BLUEPRINT = REGISTER.register("uranium_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }

}
