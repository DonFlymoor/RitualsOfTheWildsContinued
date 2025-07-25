
package net.mcreator.ritualsofthewilds.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.procedures.SizeOnMoonPhasessProcedure;
import net.mcreator.ritualsofthewilds.procedures.ChernobogOnEntityTickUpdateProcedure;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModEntities;

public class ChernobogEntity extends Monster {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState attackoneAnimationState = new AnimationState();
    public final AnimationState attacktwoAnimationState = new AnimationState();

	public ChernobogEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(RitualsOfTheWildsModEntities.CHERNOBOG.get(), world);
	}

	public ChernobogEntity(EntityType<ChernobogEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.8f);
		xpReward = 3;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.7));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, (float) 12));
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
	}

    public void handleEntityEvent(byte someBytes)
    {
    	if(someBytes >= 4 && someBytes <= 20)
    {
    	this.walkAnimationState.stop();
    	this.idleAnimationState.stop();
        this.attackoneAnimationState.start(this.tickCount);
    } else {
    	super.handleEntityEvent(someBytes);
    }
    }

	private boolean isMovingOnLand() {
		return this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
	}

	public void tick() {

if (this.level().isClientSide()) {
	this.idleAnimationState.startIfStopped(this.tickCount); 
	if (this.isMovingOnLand()) {
		this.walkAnimationState.startIfStopped(this.tickCount); 
		this.idleAnimationState.stop();
	}else {
		this.walkAnimationState.stop();
	}
    }
    super.tick();
}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(RitualsOfTheWildsModItems.CHERNOBOG_HEART.get()));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("rituals_of_the_wilds:chernobog_living"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("rituals_of_the_wilds:chernobog_step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("rituals_of_the_wilds:chernobog_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("rituals_of_the_wilds:chernobog_death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.CACTUS))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		if (damagesource.is(DamageTypes.LIGHTNING_BOLT))
			return false;
		if (damagesource.is(DamageTypes.TRIDENT))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		ChernobogOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose pose) {
		Entity entity = this;
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		return super.getDimensions(pose).scale((float) SizeOnMoonPhasessProcedure.execute(world));
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 120);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 12);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.3);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
		return builder;
	}
}
