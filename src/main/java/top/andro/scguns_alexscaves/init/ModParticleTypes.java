package top.andro.scguns_alexscaves.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.andro.scguns_alexscaves.SCGunsAC;

public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SCGunsAC.MOD_ID);

    public static final RegistryObject<SimpleParticleType> MAGIC_SMALL = REGISTER.register("magic_small", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> MAGIC_IMPACT = REGISTER.register("magic_impact", () -> new SimpleParticleType(true));
}
