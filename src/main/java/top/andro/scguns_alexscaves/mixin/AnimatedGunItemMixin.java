package top.andro.scguns_alexscaves.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.core.keyframe.event.SoundKeyframeEvent;
import software.bernie.geckolib.util.ClientUtils;
import top.andro.scguns_alexscaves.init.ModSounds;
import top.ribs.scguns.item.animated.AnimatedGunItem;

@Mixin(AnimatedGunItem.class)
public class AnimatedGunItemMixin {
    @Inject(method = "soundListener", at = @At("TAIL"), remap = false)
    private void scguns_alexscaves$soundListener(SoundKeyframeEvent<AnimatedGunItem> gunItemSoundKeyframeEvent, CallbackInfo ci) {
        Player player = ClientUtils.getClientPlayer();

        switch (gunItemSoundKeyframeEvent.getKeyframeData().getSound()) {
            case "squeak":
                player.playSound(ModSounds.SCREW.get(), 1.0F, 1.0F);
                break;
        }
    }
}