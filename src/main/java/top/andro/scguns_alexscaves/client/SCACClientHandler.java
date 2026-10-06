package top.andro.scguns_alexscaves.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.andro.scguns_alexscaves.client.render.entity.model.RadAgentRenderer;
import top.andro.scguns_alexscaves.client.render.gun.model.*;
import top.andro.scguns_alexscaves.init.ModEntities;
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
        ModelOverrides.register(ModItems.ATOMIC_CARABINE.get(), new AtomicCarabineModel());
        ModelOverrides.register(ModItems.FISSION_FEVER.get(), new FissionFeverModel());
        ModelOverrides.register(ModItems.GENESIS.get(), new GenesisModel());
        ModelOverrides.register(ModItems.FOUL_EMESIS.get(), new FoulEmesisModel());
        ModelOverrides.register(ModItems.CORRODER.get(), new CorroderModel());
        ModelOverrides.register(ModItems.ACID_SPRAYER.get(), new AcidSprayerModel());

        ModelOverrides.register(ModItems.HALIBUT_CANNON.get(), new HalibutCannonModel());
        ModelOverrides.register(ModItems.SEA_SERPENT.get(), new SeaSerpentModel());
        ModelOverrides.register(ModItems.MAHI.get(), new MahiModel());
        ModelOverrides.register(ModItems.ELVER_TIDE.get(), new ElverTideModel());
        ModelOverrides.register(ModItems.MORAY_TIDE.get(), new MorayTideModel());
        ModelOverrides.register(ModItems.NEPTUNES_BOUNTY.get(), new NeptunesBountyModel());

        ModelOverrides.register(ModItems.EBONY_IVORY.get(), new EbonyIvoryModel());
        ModelOverrides.register(ModItems.DRAGONFLY.get(), new DragonflyModel());
        ModelOverrides.register(ModItems.ECLIPSE.get(), new EclipseModel());
        ModelOverrides.register(ModItems.SAURON.get(), new SauronModel());
        ModelOverrides.register(ModItems.REDSTONE_REPEATER.get(), new RedstoneRepeaterModel());
        ModelOverrides.register(ModItems.GUANO_CANNON.get(), new GuanoCannonModel());

        EntityRenderers.register(ModEntities.RAD_AGENT.get(), RadAgentRenderer::new);
    }

}
