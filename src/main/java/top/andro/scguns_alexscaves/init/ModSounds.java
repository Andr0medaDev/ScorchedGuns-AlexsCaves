package top.andro.scguns_alexscaves.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.andro.scguns_alexscaves.SCGunsAC;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);

    public static final RegistryObject<SoundEvent> HALIBUT_CANNON_FIRE = register("item.halibut_cannon.fire");
    public static final RegistryObject<SoundEvent> FORLORN_DUAL_FIRE = register("item.forlorn_dual.fire");
    public static final RegistryObject<SoundEvent> THOMPSON_FIRE = register("item.thompson.fire");
    public static final RegistryObject<SoundEvent> ACID_FIRE = register("item.acid.fire");
    public static final RegistryObject<SoundEvent> URANIUM_FIRE = register("item.uranium.fire");
    public static final RegistryObject<SoundEvent> EXO_LASER = register("item.exo_laser.fire");
    public static final RegistryObject<SoundEvent> SCREW = register("item.gun_rustle.screw");
    public static final RegistryObject<SoundEvent> TRAPDOOR_OPEN = register("item.trapdoor.open");
    public static final RegistryObject<SoundEvent> TRAPDOOR_CLOSE = register("item.trapdoor.close");

    public static void register(IEventBus eventbus) {SOUNDS.register(eventbus);}

    private static RegistryObject<SoundEvent> register(String key) {
        return SOUNDS.register(key, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, key)));
    }
}
