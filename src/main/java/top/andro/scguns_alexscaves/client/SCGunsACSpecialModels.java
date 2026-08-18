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
    //toxic carbine
    TOXIC_CARBINE("gun/toxic_carbine"),
    TOXIC_CARBINE_MAIN("toxic_carbine/main"),
    TOXIC_STAN_MAGAZINE("toxic_carbine/stand_mag"),
    TOXIC_FAST_MAGAZINE("toxic_carbine/fast_mag"),
    TOXIC_EXT_MAGAZINE("toxic_carbine/ext_mag"),
    TOXIC_STAN_BARREL("toxic_carbine/stand_barrel"),
    TOXIC_EXT_BARREL("toxic_carbine/ext_barrel"),
    TOXIC_STOCK_WEIGHTED("toxic_carbine/heavy_stock"),
    TOXIC_STOCK_LIGHT("toxic_carbine/light_stock"),
    TOXIC_STOCK_WOODEN("toxic_carbine/wooden_stock"),
    TOXIC_STAN_GRIP("toxic_carbine/stand_grip"),
    TOXIC_SILENCER("toxic_carbine/silencer"),
    TOXIC_ADVANCED_SILENCER("toxic_carbine/advanced_silencer"),
    TOXIC_MUZZLE_BRAKE("toxic_carbine/muzzle_brake"),
    //toxic shotgun
    ACID_SHOTGUN("gun/acid_shotgun"),
    ACID_SHOTGUN_MAIN("acid_shotgun/main"),
    //toxic pistol
    ACID_PISTOL("gun/acid_pistol"),
    ACID_PISTOL_MAIN("acid_pistol/main"),
    //halibut cannon
    HALIBUT_CANNON("gun/halibut_cannon"),
    HALIBUT_CANNON_MAIN("halibut_cannon/main");


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
