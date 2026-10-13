package top.ribs.scguns.common.item.acgun;

import net.minecraft.sounds.SoundEvent;
import top.ribs.scguns.item.animated.AnimatedGunItem;

public class AcidGunItem extends AnimatedGunItem {
    public AcidGunItem(Properties properties, String path, SoundEvent reloadSoundMagOut, SoundEvent reloadSoundMagIn, SoundEvent reloadSoundEnd, SoundEvent boltPullSound, SoundEvent boltReleaseSound, float v) {
        super(properties, path, reloadSoundMagOut, reloadSoundMagIn, reloadSoundEnd, boltPullSound, boltReleaseSound);
    }
}
