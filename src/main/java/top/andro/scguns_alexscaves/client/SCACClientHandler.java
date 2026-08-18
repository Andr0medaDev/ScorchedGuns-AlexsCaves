package top.andro.scguns_alexscaves.client;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.andro.scguns_alexscaves.client.render.gun.model.AcidPistolModel;
import top.andro.scguns_alexscaves.client.render.gun.model.AcidShotgunModel;
import top.andro.scguns_alexscaves.client.render.gun.model.HalibutCannonModel;
import top.andro.scguns_alexscaves.client.render.gun.model.ToxicCarbineModel;
import top.andro.scguns_alexscaves.init.ModItems;
import top.ribs.scguns.client.render.gun.ModelOverrides;

public class SCACClientHandler {
    public static void registerClientHandlers(IEventBus bus) {
        bus.addListener(SCACClientHandler::onClientSetup);
    }

    private static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(SCACClientHandler::setup);
    }

    public static void setup() {
        registerModelOverrides();
    }

    private static void registerModelOverrides() {
        ModelOverrides.register(ModItems.TOXIC_CARBINE.get(), new ToxicCarbineModel());
        ModelOverrides.register(ModItems.ACID_SHOTGUN.get(), new AcidShotgunModel());
        ModelOverrides.register(ModItems.ACID_PISTOL.get(), new AcidPistolModel());
        ModelOverrides.register(ModItems.HALIBUT_CANNON.get(), new HalibutCannonModel());
    }

}
