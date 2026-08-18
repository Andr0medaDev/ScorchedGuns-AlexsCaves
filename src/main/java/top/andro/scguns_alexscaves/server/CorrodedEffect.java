package top.andro.scguns_alexscaves.server;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import top.andro.scguns_alexscaves.init.ModEffects;

public class CorrodedEffect extends MobEffect {
    public CorrodedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    /*public void applyEffectTick(LivingEntity entity, int tick) {
        MobEffectInstance effectInstance = entity.getEffect(ModEffects.CORRODED.get());
        if (effect == null) return;

        int duration = effectInstance.getDuration();
        int originalDuration = getOriginalDuration(effect);
        float intensityRatio = caculateIntensityRatio(duration, originalDuration);

        int damageInterval = Math.max(20, (int)(40 - (amplifer * 10 * intensityRatio)));
        if (entity.tickCount % damageInterval == 0) {
            float damage = (1.0f + amplifier * 0.5f) * intensityRatio;
            if (damage > 0.2f) {
                entity.hurt(entity.damageSources().magic(), damage);
            }
        }

    }*/
}
