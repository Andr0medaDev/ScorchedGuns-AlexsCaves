package top.andro.scguns_alexscaves.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.andro.scguns_alexscaves.entity.RadAgentEntity;
import top.andro.scguns_alexscaves.entity.projectile.AcidTankProjectileEntity;
import top.andro.scguns_alexscaves.entity.projectile.MagicProjectileEntity;
import top.andro.scguns_alexscaves.entity.projectile.UraniumCellProjectileEntity;
import top.andro.scguns_alexscaves.entity.projectile.WaterBucketProjectileEntity;

import java.util.function.BiFunction;

import static top.andro.scguns_alexscaves.SCGunsAC.MOD_ID;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    // Bullet Projectiles
    public static final RegistryObject<EntityType<UraniumCellProjectileEntity>> URANIUM_CELL_PROJECTILE = registerBasic("uranium_cell_projectile", UraniumCellProjectileEntity::new);
    public static final RegistryObject<EntityType<AcidTankProjectileEntity>> ACID_TANK_PROJECTILE = registerBasic("acid_tank_projectile", AcidTankProjectileEntity::new);
    public static final RegistryObject<EntityType<WaterBucketProjectileEntity>> WATER_BUCKET_PROJECTILE = registerBasic("water_bucket_projectile", WaterBucketProjectileEntity::new);
    public static final RegistryObject<EntityType<MagicProjectileEntity>> MAGIC_PROJECTILE = registerBasic("magic_projectile", MagicProjectileEntity::new);

    public static final RegistryObject<EntityType<RadAgentEntity>> RAD_AGENT = REGISTER.register("rad_agent", () -> EntityType.Builder.of(RadAgentEntity::new, MobCategory.MONSTER)
            .sized(0.8f,2.0f)
            .build(new ResourceLocation(MOD_ID, "rad_agent").toString())
    );

    private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, Level, T> function)
    {
        return REGISTER.register(id, () -> EntityType.Builder.of(function::apply, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .setTrackingRange(100)
                .setUpdateInterval(1)
                .noSummon()
                .fireImmune()
                .noSave()
                .setShouldReceiveVelocityUpdates(true).build(id));
    }

    public static void register(IEventBus eventBus) {REGISTER.register(eventBus);}
}
