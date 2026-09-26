package top.andro.scguns_alexscaves.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.ribs.scguns.entity.ai.AIType;

public class AbstractGunnerEntity extends Monster implements GeoAnimatable, GeoEntity {
    public static final RawAnimation WALK_ANIM = RawAnimation.begin().thenLoop("move.walk");
    public static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenLoop("misc.idle");
    public static final RawAnimation SHOOT = RawAnimation.begin().thenPlay("shoot");
    public static final RawAnimation RELOAD = RawAnimation.begin().thenPlay("reload");

    public static final EntityDataAccessor<Byte> DATA_AGGRO = SynchedEntityData.defineId(AbstractGunnerEntity.class, EntityDataSerializers.BYTE);
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    protected AbstractGunnerEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
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
        controllers.add(new AnimationController<>(this, "Shoot", 0, state -> PlayState.STOP).triggerableAnim("shoot", SHOOT));
        controllers.add(new AnimationController<>(this, "Reload", 1, state -> PlayState.STOP).triggerableAnim("reload", RELOAD));

    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }


    public void RegisterGoals() {
        this.goalSelector.removeAllGoals(goal -> true);
        ItemStack mainHandItem = this.getMainHandItem();

        this.goalSelector.addGoal(0, new FloatGoal((this)));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.9D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Player.class, true, player -> !((Player) player).isCreative() && !player.isSpectator()));

    }
}
