package top.andro.scguns_alexscaves.client.render.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.checkerframework.checker.signature.qual.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import top.andro.scguns_alexscaves.SCGunsAC;
import top.andro.scguns_alexscaves.client.ModModelLayers;
import top.andro.scguns_alexscaves.client.entity.model.RadAgentModel;
import top.andro.scguns_alexscaves.common.entity.RadAgentEntity;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

public class RadAgentRenderer extends GeoEntityRenderer<RadAgentEntity> {

    private static final ResourceLocation GLOW = ResourceLocation.fromNamespaceAndPath(MOD_ID,"textures/entity/rad_agent_glow.png");

    public RadAgentRenderer(EntityRendererProvider.Context context) {
        super(context, new RadAgentModel());
        addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            @Override
            protected ItemStack getStackForBone(GeoBone bone, RadAgentEntity animatable) {
                if (bone.getName().equals("item_bone")) {
                    return animatable.getMainHandItem();
                }
                return null;
            }

            @Override
            protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, RadAgentEntity animatable) {
                return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
            }
        });
        /*addRenderLayer(new AutoGlowingGeoLayer<>(this) {
           @Override
           public void render(PoseStack poseStack, RadAgentEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
               RenderType emissiveRenderType = getRenderType(animatable);
               getRenderer().reRender(
                       bakedModel,
                       poseStack,
                       bufferSource,
                       animatable,
                       emissiveRenderType,
                       bufferSource.getBuffer(emissiveRenderType),
                       partialTick,
                       LightTexture.FULL_BRIGHT,
                       OverlayTexture.WHITE_OVERLAY_V,
                       1,
                       1,
                       1,
                       1

               );
           }
        });*/
    }
    /*public ResourceLocation getTextureLocation(RadAgentEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID,"textures/entity/rad_agent_glow.png");
    }*/

}
