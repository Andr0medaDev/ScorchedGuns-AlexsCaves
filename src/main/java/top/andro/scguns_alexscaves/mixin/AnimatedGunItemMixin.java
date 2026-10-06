package top.andro.scguns_alexscaves.mixin;

import net.minecraft.sounds.SoundEvents;
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
public abstract class AnimatedGunItemMixin {
    @Inject(method = "soundListener", at = @At("TAIL"), remap = false)
    private void scguns_alexscaves$soundListener(SoundKeyframeEvent<AnimatedGunItem> gunItemSoundKeyframeEvent, CallbackInfo ci) {
        Player player = ClientUtils.getClientPlayer();

        switch (gunItemSoundKeyframeEvent.getKeyframeData().getSound()) {
            case "screw":
                player.playSound(ModSounds.SCREW.get(), 1.0F, 1.0F);
                break;
            case "close":
                player.playSound(ModSounds.TRAPDOOR_CLOSE.get(), 1.0F, 1.0F);
                break;
            case "open":
                player.playSound(ModSounds.TRAPDOOR_OPEN.get(), 1.0F, 1.0F);
                break;
            case "activate":
                player.playSound(ModSounds.BEACON_ACTIVATE.get(), 1.0F, 1.0F);
                break;
            case "ambient":
                player.playSound(ModSounds.BEACON_AMBIENT.get(), 1.0F, 1.0F);
                break;
            case "guano":
                player.playSound(SoundEvents.HONEY_BLOCK_PLACE, 1.0F, 1.0F);
                break;

        }
    }
}