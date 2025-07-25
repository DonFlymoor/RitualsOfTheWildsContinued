
package net.mcreator.ritualsofthewilds.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModEntities;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

public class LeshyEntity extends Monster {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    
	public LeshyEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(RitualsOfTheWildsModEntities.LESHY.get(), world);
	}

	public LeshyEntity(EntityType<LeshyEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 6;
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
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(2, new PanicGoal(this, 1.2));
		this.goalSelector.addGoal(3, new RemoveBlockGoal(RitualsOfTheWildsModBlocks.CORRUPTED_SAPLING.get(), this, 1, (int) 3));
		this.goalSelector.addGoal(4, new RemoveBlockGoal(RitualsOfTheWildsModBlocks.CORRUPTED_SAPLING_POT.get(), this, 1, (int) 3));
		this.goalSelector.addGoal(5, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(6, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new FloatGoal(this));
	}

	private boolean isMovingOnLand() {
		return this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
	}
	
    public void tick() {
    if (this.level().isClientSide()) {

        if (this.isMovingOnLand()) {
                   this.idleAnimationState.stop();
                   this.walkAnimationState.startIfStopped(this.tickCount); 
            } else {
                    this.walkAnimationState.stop();
                    this.idleAnimationState.startIfStopped(this.tickCount);
                }
    }
    super.tick();
    }

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.vex.hurt"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean canBreatheUnderwater() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return true;
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.15);
		builder = builder.add(Attributes.MAX_HEALTH, 120);
		builder = builder.add(Attributes.ARMOR, 6);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
