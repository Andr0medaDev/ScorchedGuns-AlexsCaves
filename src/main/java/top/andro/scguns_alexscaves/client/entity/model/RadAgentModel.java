package top.andro.scguns_alexscaves.client.entity.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import top.andro.scguns_alexscaves.SCGunsAC;
import top.andro.scguns_alexscaves.entity.RadAgentEntity;

public class RadAgentModel extends GeoModel<RadAgentEntity> {
private final ResourceLocation model = new ResourceLocation(SCGunsAC.MOD_ID, "geo/entity/rad_agent.geo.json");
private final ResourceLocation texture = new ResourceLocation(SCGunsAC.MOD_ID, "textures/entity/rad_agent.png");
private final ResourceLocation animations = new ResourceLocation(SCGunsAC.MOD_ID, "animation/entity/rad_agent.animation.json");

    @Override
    public ResourceLocation getModelResource(RadAgentEntity radAgentEntity) {
        return null;
    }

    @Override
    public ResourceLocation getTextureResource(RadAgentEntity radAgentEntity) {
        return null;
    }

    @Override
    public ResourceLocation getAnimationResource(RadAgentEntity radAgentEntity) {
        return null;
    }
}
