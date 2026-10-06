package top.andro.scguns_alexscaves.client.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import top.andro.scguns_alexscaves.common.entity.RadAgentEntity;
import top.ribs.scguns.item.GunItem;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

public class RadAgentModel extends GeoModel<RadAgentEntity> {
    private final ResourceLocation model = new ResourceLocation(MOD_ID, "geo/entity/rad_agent.geo.json");
    private final ResourceLocation texture = new ResourceLocation(MOD_ID, "textures/entity/rad_agent.png");
    private final ResourceLocation animations = new ResourceLocation(MOD_ID, "animations/entity/rad_agent.animation.json");

    @Override
    public ResourceLocation getModelResource(RadAgentEntity radAgentEntity) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(RadAgentEntity radAgentEntity) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(RadAgentEntity radAgentEntity) {
        return this.animations;
    }

    @Override
    public void setCustomAnimations(RadAgentEntity animatable, long instanceId, AnimationState<RadAgentEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("Head");
        CoreGeoBone arms = getAnimationProcessor().getBone("arms");
        CoreGeoBone waist = getAnimationProcessor().getBone("Waist");

        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        if (head != null) {

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }

        if (arms != null && waist != null) {

            //if (animationState.isCurrentAnimation(IDLE_ALERT) || animationState.isCurrentAnimation(WALK_ALERT) || animationState.isCurrentAnimation(SHOOT))
            //{
            arms.setRotX(((entityData.headPitch()) * Mth.DEG_TO_RAD)* 1f);
            arms.setRotY(((entityData.netHeadYaw()) * Mth.DEG_TO_RAD)* 0.5f);

            waist.setRotX(((entityData.headPitch()) * Mth.DEG_TO_RAD)* 0.5f);
            waist.setRotY(((entityData.netHeadYaw()) * Mth.DEG_TO_RAD)* 0.5f);

            if (head != null) {
                //cancel out effects of waist moving with head
                float wX = waist.getRotX();
                float wY = waist.getRotY();

                float hX = head.getRotX();
                float hY = head.getRotY();

                head.setRotX(hX-wX);
                head.setRotY(hY-wY);
            }
            //} else {
            //    arms.setRotX(0);
            //    arms.setRotY(0);
            //    waist.setRotX(0);
            //}
        }
    }
}
