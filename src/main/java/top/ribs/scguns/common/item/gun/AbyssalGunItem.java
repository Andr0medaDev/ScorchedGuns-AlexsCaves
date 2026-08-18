package top.ribs.scguns.common.item.gun;

import com.github.alexmodguy.alexscaves.AlexsCaves;
import com.github.alexmodguy.alexscaves.server.message.UpdateEffectVisualityEntityMessage;
import com.github.alexmodguy.alexscaves.server.potion.ACEffectRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import top.ribs.scguns.item.animated.AnimatedGunItem;
import top.ribs.scguns.item.animated.AnimatedUnderWaterGunItem;
import top.ribs.scguns.item.animated.NonUnderwaterAnimatedGunItem;

public class AbyssalGunItem extends AnimatedUnderWaterGunItem {
    public AbyssalGunItem(Properties properties, String path, SoundEvent reloadSoundMagOut, SoundEvent reloadSoundMagIn, SoundEvent reloadSoundEnd, SoundEvent boltPullSound, SoundEvent boltReleaseSound, float v) {
        super(properties, path, reloadSoundMagOut, reloadSoundMagIn, reloadSoundEnd, boltPullSound, boltReleaseSound);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (!level.isClientSide && entity instanceof LivingEntity living && !(living instanceof Player player && player.isCreative())) {
            if (!living.hasEffect(ACEffectRegistry.DEEPSIGHT.get())) {
                MobEffectInstance instance = new MobEffectInstance(ACEffectRegistry.DEEPSIGHT.get(), 1800);
                living.addEffect(instance);
                AlexsCaves.sendMSGToAll(new UpdateEffectVisualityEntityMessage(entity.getId(), entity.getId(), 0, instance.getDuration()));
            }
        }
    }
}
