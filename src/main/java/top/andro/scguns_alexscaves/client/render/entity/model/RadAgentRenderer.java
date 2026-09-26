package top.andro.scguns_alexscaves.client.render.entity.model;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import top.andro.scguns_alexscaves.client.entity.model.RadAgentModel;
import top.andro.scguns_alexscaves.entity.RadAgentEntity;

public class RadAgentRenderer extends GeoEntityRenderer<RadAgentEntity> {
    public RadAgentRenderer(EntityRendererProvider.Context context) {
        super(context, new RadAgentModel());
    }
}
