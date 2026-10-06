package top.andro.scguns_alexscaves.init;

import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TridentItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.andro.scguns_alexscaves.SCGunsAC;
import top.ribs.scguns.common.item.gun.AbyssalGunItem;
import top.ribs.scguns.common.item.gun.AcidGunItem;
import top.ribs.scguns.common.item.gun.ForlornGunItem;
import top.ribs.scguns.common.item.gun.RadioactiveGunItem;
import top.ribs.scguns.init.ModEffects;
import top.ribs.scguns.init.ModSounds;
import top.ribs.scguns.item.AmmoItem;
import top.ribs.scguns.item.BlueprintItem;
import top.ribs.scguns.item.FuelAmmoItem;
import top.ribs.scguns.item.animated.AnimatedAirGunItem;
import top.ribs.scguns.item.animated.AnimatedDualWieldGunItem;
import top.ribs.scguns.item.animated.AnimatedGunItem;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    //public static final Rarity RARITY_CANDY = Rarity.create("scguns_alexscaves:candy", ChatFormatting.PINK);
    //public static final Rarity RARITY_MAGNETIC = Rarity.create("scguns_alexscaves:magnetic", ChatFormatting.DARK_RED);
    //public static final Rarity RARITY_PRIMORDIAL = Rarity.create("scguns_alexscaves:primordial", style -> style.withColor(0xff9b682a));
    public static final Rarity RARITY_RADIOACTIVE = Rarity.create("scguns_alexscaves:radioactive", ChatFormatting.DARK_GREEN);
    public static final Rarity RARITY_ACIDIC = Rarity.create("scguns_alexscaves:acidic", ChatFormatting.GREEN);
    public static final Rarity RARITY_ABYSSAL = Rarity.create("scguns_alexscaves:abyssal", ChatFormatting.DARK_BLUE);
    public static final Rarity RARITY_FORLORN = Rarity.create("scguns_alexscaves:forlorn", ChatFormatting.DARK_RED);

    //GUNS
    public static final RegistryObject<AnimatedGunItem> ATOMIC_CARABINE = ITEMS.register("atomic_carabine",
            () -> new RadioactiveGunItem(
                    new Item.Properties().stacksTo(1).durability(900).rarity(RARITY_RADIOACTIVE),
                    "atomic_carabine", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );
    public static final RegistryObject<AnimatedGunItem> FISSION_FEVER = ITEMS.register("fission_fever",
            () -> new RadioactiveGunItem(
                    new Item.Properties().stacksTo(1).durability(850).rarity(RARITY_RADIOACTIVE),
                    "fission_fever", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );
    public static final RegistryObject<AnimatedGunItem> GENESIS = ITEMS.register("genesis",
            () -> new RadioactiveGunItem(
                    new Item.Properties().stacksTo(1).durability(950).rarity(RARITY_RADIOACTIVE),
                    "genesis", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );
    //RENAME TO FOUL EMESIS
    public static final RegistryObject<AnimatedGunItem> FOUL_EMESIS = ITEMS.register("foul_emesis",
            () -> new AcidGunItem(
                    new Item.Properties().stacksTo(1).durability(900).rarity(RARITY_ACIDIC),
                    "foul_emesis", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );
    public static final RegistryObject<AnimatedGunItem> CORRODER = ITEMS.register("corroder",
            () -> new AcidGunItem(
                    new Item.Properties().stacksTo(1).durability(750).rarity(RARITY_ACIDIC),
                    "corroder", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );
    public static final RegistryObject<AnimatedGunItem> ACID_SPRAYER = ITEMS.register("acid_sprayer",
            () -> new AcidGunItem(
                    new Item.Properties().stacksTo(1).durability(875).rarity(RARITY_ACIDIC),
                    "acid_sprayer", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get(),    // Ejector sound release
                    0.001F)
    );

    public static final RegistryObject<AnimatedGunItem> HALIBUT_CANNON = ITEMS.register("halibut_cannon",
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
    public static final RegistryObject<AnimatedGunItem> SEA_SERPENT = ITEMS.register("sea_serpent",
            () -> new AnimatedAirGunItem(
                    new Item.Properties().stacksTo(1).durability(1000).rarity(RARITY_ABYSSAL),
                    "sea_serpent", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
                    )
    );
    public static final RegistryObject<AnimatedGunItem> ELVER_TIDE = ITEMS.register("elver_tide",
            () -> new AnimatedAirGunItem(
                    new Item.Properties().stacksTo(1).durability(1000).rarity(RARITY_ABYSSAL),
                    "elver_tide", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
                    )
    );
    public static final RegistryObject<AnimatedGunItem> MORAY_TIDE = ITEMS.register("moray_tide",
            () -> new AnimatedAirGunItem(
                    new Item.Properties().stacksTo(1).durability(950).rarity(RARITY_ABYSSAL),
                    "moray_tide", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()   // Ejector sound release
                    )
    );
    public static final RegistryObject<AnimatedGunItem> MAHI = ITEMS.register("mahi",
            () -> new AnimatedAirGunItem(
                    new Item.Properties().stacksTo(1).durability(1000).rarity(RARITY_ABYSSAL),
                    "mahi", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
                    )
    );
    public static final RegistryObject<AnimatedGunItem> NEPTUNES_BOUNTY = ITEMS.register("neptunes_bounty",
            () -> new AnimatedAirGunItem(
                    new Item.Properties().stacksTo(1).durability(1000).rarity(RARITY_ABYSSAL),
                    "neptunes_bounty", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()   // Ejector sound release
            ));

    public static final RegistryObject<AnimatedGunItem> EBONY_IVORY = ITEMS.register("ebony_ivory",
            () -> new AnimatedDualWieldGunItem(
                    new Item.Properties().stacksTo(1).durability(1200).rarity(RARITY_FORLORN),
                    "ebony_ivory", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            )
    );
    public static final RegistryObject<AnimatedGunItem> DRAGONFLY = ITEMS.register("dragonfly",
            () -> new ForlornGunItem(
                    new Item.Properties().stacksTo(1).durability(1600).rarity(RARITY_FORLORN),
                    "dragonfly", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            )
    );
    public static final RegistryObject<AnimatedGunItem> ECLIPSE = ITEMS.register("eclipse",
            () -> new ForlornGunItem(
                    new Item.Properties().stacksTo(1).durability(1200).rarity(RARITY_FORLORN),
                    "eclipse", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            )
    );
    public static final RegistryObject<AnimatedGunItem> REDSTONE_REPEATER = ITEMS.register("redstone_repeater",
            () -> new ForlornGunItem(
                    new Item.Properties().stacksTo(1).durability(1000).rarity(RARITY_FORLORN),
                    "redstone_repeater", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            )
    );
    public static final RegistryObject<AnimatedGunItem> SAURON = ITEMS.register("sauron",
            () -> new ForlornGunItem(
                    new Item.Properties().stacksTo(1).durability(1600).rarity(RARITY_FORLORN),
                    "sauron", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            )
    );
    public static final RegistryObject<AnimatedGunItem> GUANO_CANNON = ITEMS.register("guano_cannon",
            () -> new ForlornGunItem(
                    new Item.Properties().stacksTo(1).durability(1500).rarity(RARITY_FORLORN),
                    "guano_cannon", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            )
    );

    //AMMO
    public static final RegistryObject<Item> URANIUM_CELL = ITEMS.register("uranium_cell", () -> new AmmoItem(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_BULLET = ITEMS.register("brass_bullet", () -> new AmmoItem(new Item.Properties()));
    public static final RegistryObject<Item> ACIDIC_SOLUTION = ITEMS.register("acidic_solution", () -> new Item(new Item.Properties()));
    //public static final RegistryObject<Item> ANTHRALITE_SPEAR = REGISTER.register("anthralite_spear", () -> new TridentItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ACID_TANK = ITEMS.register("acid_tank",
            () -> new FuelAmmoItem(new Item.Properties(),
                    top.ribs.scguns.init.ModItems.EMPTY_TANK,
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0),
                    new MobEffectInstance(MobEffects.WEAKNESS, 100, 0),
                    new MobEffectInstance(ModEffects.SULFUR_POISONING.get(), 150, 0)));

    //BLUEPRINTS
    public static final RegistryObject<Item> ATOMIC_BLUEPRINT = ITEMS.register("atomic_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ABYSSAL_BLUEPRINT = ITEMS.register("abyssal_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> FORLORN_BLUEPRINT = ITEMS.register("forlorn_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));

    //SPAWN EGGS
    public static final RegistryObject<Item> RAD_AGENT_SPAWN_EGG = ITEMS.register("rad_agent_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.RAD_AGENT, 0xe8e835, 0x007000, new Item.Properties()));

    //CRAFTING MATERIALS
    public static final RegistryObject<Item> BARIC_ALLOY_BLEND = ITEMS.register("baric_alloy_blend", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BARIC_ALLOY = ITEMS.register("baric_alloy", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BARIC_ALLOY_GUN_FRAME = ITEMS.register("baric_alloy_gun_frame", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POLYMER_GUN_FRAME = ITEMS.register("polymer_gun_frame", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
