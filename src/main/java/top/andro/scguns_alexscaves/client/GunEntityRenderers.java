package top.andro.scguns_alexscaves.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.andro.scguns_alexscaves.init.ModEntities;
import top.ribs.scguns.client.render.entity.ProjectileRenderer;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.URANIUM_CELL_PROJECTILE.get(), ProjectileRenderer::new);
    }
}
