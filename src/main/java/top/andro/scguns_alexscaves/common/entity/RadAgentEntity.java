package top.andro.scguns_alexscaves.common.entity;

import com.github.alexmodguy.alexscaves.server.misc.ACSoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.ribs.scguns.config.EntityEquipmentConfig;
import top.ribs.scguns.entity.ai.AIType;
import top.ribs.scguns.entity.ai.GunAttackGoal;
import top.ribs.scguns.item.GunItem;

public class RadAgentEntity extends AbstractGunnerEntity implements GeoAnimatable, GeoEntity {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(RadAgentEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> ATTACK_TIMEOUT =
            SynchedEntityData.defineId(RadAgentEntity.class, EntityDataSerializers.INT);


    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public RadAgentEntity(EntityType<? extends RadAgentEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Walk/Run/Idle", 2, state -> {
            boolean isHoldingGun = this.getMainHandItem().getItem() instanceof GunItem;

            if (state.isMoving())
                return state.setAndContinue(isHoldingGun ? WALK_ALERT : DefaultAnimations.WALK);

            return state.setAndContinue(isHoldingGun ? IDLE_ALERT : DefaultAnimations.IDLE);
        }));

        controllers.add(new AnimationController<>(this, "Shoot", 0, state -> PlayState.STOP).triggerableAnim("shoot", SHOOT));
        controllers.add(new AnimationController<>(this, "Reload", 1, state -> PlayState.STOP).triggerableAnim("reload", RELOAD));
    }

    protected void registerGoals() {
        this.goalSelector.removeAllGoals(goal -> true);
        ItemStack mainHandItem = this.getMainHandItem();
        boolean hasGun = mainHandItem.getItem() instanceof GunItem;

        if (hasGun) {
            this.goalSelector.addGoal(2, new GunAttackGoal<>(this, this.getMainHandItem(), 1.0F, AIType.DEFAULT, 3));
        }
        else {
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        }

        this.goalSelector.addGoal(0, new FloatGoal((this)));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.9D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true,
                player -> !((Player) player).isCreative() && !player.isSpectator()));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 25.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.15D)
                .add(Attributes.ARMOR, 1F)
                .add(Attributes.ATTACK_DAMAGE, 4F)
                .add(Attributes.ATTACK_KNOCKBACK, 1F)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public void handleEntityEvent(byte pId) {
        super.handleEntityEvent(pId);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        EntityEquipmentConfig.equipEntity(this, "scguns_alexscaves:rad_agent");
        return super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }


    @Override
    public boolean canHoldItem(ItemStack stack) {
        return true;
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ACSoundRegistry.BRAINIAC_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ACSoundRegistry.BRAINIAC_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ACSoundRegistry.BRAINIAC_DEATH.get();
    }

    protected SoundEvent getAttackSound() {
        return ACSoundRegistry.BRAINIAC_ATTACK.get();
    }

}
