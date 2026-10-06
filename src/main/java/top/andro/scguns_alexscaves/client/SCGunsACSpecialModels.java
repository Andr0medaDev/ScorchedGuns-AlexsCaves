package top.andro.scguns_alexscaves.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public enum SCGunsACSpecialModels {
    //atomic carabine
    ATOMIC_CARABINE("gun/atomic_carabine"),
    ATOMIC_CARABINE_MAIN("atomic_carabine/main"),
    ATOMIC_CARABINE_STAN_MAGAZINE("atomic_carabine/stand_mag"),
    ATOMIC_CARABINE_FAST_MAGAZINE("atomic_carabine/fast_mag"),
    ATOMIC_CARABINE_EXT_MAGAZINE("atomic_carabine/ext_mag"),
    ATOMIC_CARABINE_STAN_BARREL("atomic_carabine/stand_barrel"),
    ATOMIC_CARABINE_EXT_BARREL("atomic_carabine/ext_barrel"),
    ATOMIC_CARABINE_STOCK_WEIGHTED("atomic_carabine/heavy_stock"),
    ATOMIC_CARABINE_STOCK_LIGHT("atomic_carabine/light_stock"),
    ATOMIC_CARABINE_STOCK_WOODEN("atomic_carabine/wooden_stock"),
    ATOMIC_CARABINE_STAN_GRIP("atomic_carabine/stand_grip"),
    ATOMIC_CARABINE_SILENCER("atomic_carabine/silencer"),
    ATOMIC_CARABINE_ADVANCED_SILENCER("atomic_carabine/advanced_silencer"),
    ATOMIC_CARABINE_MUZZLE_BRAKE("atomic_carabine/muzzle_brake"),
    //genesis
    GENESIS("gun/genesis"),
    GENESIS_MAIN("genesis/main"),
    //fission fever
    FISSION_FEVER("gun/fission_fever"),
    FISSION_FEVER_MAIN("fission_fever/main"),
    //foul emesis
    FOUL_EMESIS("gun/foul_emesis"),
    FOUL_EMESIS_MAIN("foul_emesis/main"),
    //corroder
    CORRODER("gun/corroder"),
    CORRODER_MAIN("corroder/main"),
    //acid sprayer
    ACID_SPRAYER("gun/acid_sprayer"),
    ACID_SPRAYER_MAIN("acid_sprayer/main"),

    //halibut cannon
    HALIBUT_CANNON("gun/halibut_cannon"),
    HALIBUT_CANNON_MAIN("halibut_cannon/main"),
    //sea serpent
    SEA_SERPENT("gun/sea_serpent"),
    SEA_SERPENT_MAIN("sea_serpent/main"),
    //mahii
    MAHI("gun/mahi"),
    MAHI_MAIN("mahi/main"),
    //elver tide
    ELVER_TIDE("gun/elver_tide"),
    ELVER_TIDE_MAIN("elver_tide/main"),
    //moray tide
    MORAY_TIDE("gun/moray_tide"),
    MORAY_TIDE_MAIN("moray_tide/main"),
    //neptunes bounty
    NEPTUNES_BOUNTY("gun/neptunes_bounty"),
    NEPTUNES_BOUNTY_MAIN("neptunes_bounty/main"),

    //ebony and ivory
    EBONY_IVORY("gun/ebony_ivory"),
    EBONY_IVORY_MAIN("ebony_ivory/main"),
    //dragonfly
    DRAGONFLY("gun/dragonfly"),
    DRAGONFLY_MAIN("dragonfly/main"),
    //eclipse
    ECLIPSE("gun/eclipse"),
    ECLIPSE_MAIN("eclipse/main"),
    //sauron
    SAURON("gun/sauron"),
    SAURON_MAIN("sauron/main"),
    //redstone repeater i hate this thing
    REDSTONE_REPEATER("gun/redstone_repeater"),
    REDSTONE_REPEATER_MAIN("redstone_repeater/main"),
    //guano cannon
    GUANO_CANNON("gun/guano_cannon"),
    GUANO_CANNON_MAIN("guano_cannon/main");


    /**
     * The location of an item model in the [MOD_ID]/models/special/[NAME] folder
     */
    private final ResourceLocation modelLocation;

    /**
     * Cached model
     */
    private BakedModel cachedModel;

    /**
     * Sets the model's location
     *
     * @param modelName name of the model file
     */
    SCGunsACSpecialModels(String modelName) {
        this.modelLocation = new ResourceLocation(MOD_ID, "special/" + modelName);
    }

    /**
     * Registers the special models into the Forge Model Bakery. This is only called once on the
     * load of the game.
     */
    @SubscribeEvent
    public static void registerAdditional(ModelEvent.RegisterAdditional event) {
        for (SCGunsACSpecialModels model : values()) {
            event.register(model.modelLocation);
        }
    }

    /**
     * Clears the cached BakedModel since it's been rebuilt. This is needed since the models may
     * have changed when a resource pack was applied, or if resources are reloaded.
     */
    @SubscribeEvent
    public static void onBake(ModelEvent.BakingCompleted event) {
        for (SCGunsACSpecialModels model : values()) {
            model.cachedModel = null;
        }
    }

    /**
     * Gets the model
     *
     * @return isolated model
     */
    public BakedModel getModel() {
        if (this.cachedModel == null) {
            this.cachedModel = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
        }
        return this.cachedModel;
    }
}
