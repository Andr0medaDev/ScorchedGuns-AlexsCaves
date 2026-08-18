package top.andro.scguns_alexscaves.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.andro.scguns_alexscaves.SCGunsAC;
import top.andro.scguns_alexscaves.server.CorrodedEffect;

public class ModEffects {
    public static final DeferredRegister<MobEffect> REGISTER = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SCGunsAC.MOD_ID);

    public static final RegistryObject<CorrodedEffect> CORRODED = REGISTER.register("corroded",
            () -> new CorrodedEffect(MobEffectCategory.HARMFUL, 0X6BF700));
}
