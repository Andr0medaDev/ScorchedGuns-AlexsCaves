package top.ribs.scguns.common.item.gun;

import net.minecraft.sounds.SoundEvent;
import top.ribs.scguns.item.animated.AnimatedGunItem;

public class ForlornGunItem extends AnimatedGunItem {
    public ForlornGunItem(Properties properties, String path, SoundEvent reloadSoundMagOut, SoundEvent reloadSoundMagIn, SoundEvent reloadSoundEnd, SoundEvent boltPullSound, SoundEvent boltReleaseSound) {
        super(properties, path, reloadSoundMagOut, reloadSoundMagIn, reloadSoundEnd, boltPullSound, boltReleaseSound);
    }
}
