package top.andro.scguns_alexscaves.common.entity.projectile;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.ribs.scguns.item.GunItem;

import java.util.EnumSet;

public class AbstractFlyingGunnerEntity extends FlyingMob implements GeoAnimatable, GeoEntity {
    public static final RawAnimation SHOOT = RawAnimation.begin().thenPlay("shoot");
    public static final RawAnimation RELOAD = RawAnimation.begin().thenPlay("reload");
    public static final RawAnimation WALK_ALERT = RawAnimation.begin().thenLoop("move.walk.alert");
    public static final RawAnimation IDLE_ALERT = RawAnimation.begin().thenLoop("misc.idle.alert");

    public static final EntityDataAccessor<Byte> DATA_AGGRO = SynchedEntityData.defineId(AbstractFlyingGunnerEntity.class, EntityDataSerializers.BYTE);
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    protected AbstractFlyingGunnerEntity(EntityType<? extends FlyingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_AGGRO, (byte) 0);
    }

    @Override
    public void setTarget(LivingEntity entity) {
        super.setTarget(entity);
        updateAggroState();
    }

    public boolean hasAggro() {
        return this.entityData.get(DATA_AGGRO) == (byte) 1;
    }

    public void updateAggroState() {
        this.entityData.set(DATA_AGGRO, this.getTarget() != null ? (byte) 1 : (byte) 0);
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


    /*@Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Shoot", 0, state -> PlayState.STOP).triggerableAnim("shoot", SHOOT));
        controllers.add(new AnimationController<>(this, "Reload", 1, state -> PlayState.STOP).triggerableAnim("reload", RELOAD));
        controllers.add(new AnimationController<>(this, "Walk/Run/Idle", state -> {
            if (state.isMoving())
                return state.setAndContinue(AbstractGunnerEntity.this.isSprinting() ? DefaultAnimations.RUN : DefaultAnimations.WALK);

            return state.setAndContinue(DefaultAnimations.IDLE);
        }));
    }*/

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    private static class RandomFloatAroundGoal extends Goal {
        private final AbstractFlyingGunnerEntity abstractFlyingGunnerEntity;

        public RandomFloatAroundGoal(AbstractFlyingGunnerEntity abstractFlyingGunnerEntity) {
            this.abstractFlyingGunnerEntity = abstractFlyingGunnerEntity;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            MoveControl $$0 = this.abstractFlyingGunnerEntity.getMoveControl();
            if (!$$0.hasWanted()) {
                return true;
            } else {
                double $$1 = $$0.getWantedX() - this.abstractFlyingGunnerEntity.getX();
                double $$2 = $$0.getWantedY() - this.abstractFlyingGunnerEntity.getY();
                double $$3 = $$0.getWantedZ() - this.abstractFlyingGunnerEntity.getZ();
                double $$4 = $$1 * $$1 + $$2 * $$2 + $$3 * $$3;
                return $$4 < 1.0 || $$4 > 3600.0;
            }
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void start() {
            RandomSource $$0 = this.abstractFlyingGunnerEntity.getRandom();
            double $$1 = this.abstractFlyingGunnerEntity.getX() + (double)(($$0.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double $$2 = this.abstractFlyingGunnerEntity.getY() + (double)(($$0.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double $$3 = this.abstractFlyingGunnerEntity.getZ() + (double)(($$0.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.abstractFlyingGunnerEntity.getMoveControl().setWantedPosition($$1, $$2, $$3, 1.0);
        }
    }

    static class AbstractLookGoal extends Goal {
        private final AbstractFlyingGunnerEntity abstractFlyingGunnerEntity;

        public AbstractLookGoal(AbstractFlyingGunnerEntity abstractFlyingGunnerEntity) {
            this.abstractFlyingGunnerEntity = abstractFlyingGunnerEntity;
            this.setFlags(EnumSet.of(Flag.LOOK));
        }

        public boolean canUse() {
            return true;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (this.abstractFlyingGunnerEntity.getTarget() == null) {
                Vec3 $$0 = this.abstractFlyingGunnerEntity.getDeltaMovement();
                this.abstractFlyingGunnerEntity.setYRot(-((float) Mth.atan2($$0.x, $$0.z)) * 57.295776F);
                this.abstractFlyingGunnerEntity.yBodyRot = this.abstractFlyingGunnerEntity.getYRot();
            } else {
                LivingEntity $$1 = this.abstractFlyingGunnerEntity.getTarget();
                double $$2 = 64.0;
                if ($$1.distanceToSqr(this.abstractFlyingGunnerEntity) < 4096.0) {
                    double $$3 = $$1.getX() - this.abstractFlyingGunnerEntity.getX();
                    double $$4 = $$1.getZ() - this.abstractFlyingGunnerEntity.getZ();
                    this.abstractFlyingGunnerEntity.setYRot(-((float)Mth.atan2($$3, $$4)) * 57.295776F);
                    this.abstractFlyingGunnerEntity.yBodyRot = this.abstractFlyingGunnerEntity.getYRot();
                }
            }

        }
    }

    protected void RegisterGoals() {
        this.goalSelector.removeAllGoals(goal -> true);
        ItemStack mainHandItem = this.getMainHandItem();

        this.goalSelector.addGoal(0, new FloatGoal((this)));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Player.class, true, player -> !((Player) player).isCreative() && !player.isSpectator()));
        this.goalSelector.addGoal(6, new RandomFloatAroundGoal(this));
        this.goalSelector.addGoal(7, new AbstractLookGoal(this));

    }
}
