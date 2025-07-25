
package net.mcreator.ritualsofthewilds.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModEntities;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

public class DomovoiEntity extends PathfinderMob {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState sittowalkAnimationState = new AnimationState();
    public final AnimationState walktositAnimationState = new AnimationState();
    public final AnimationState backtohatAnimationState = new AnimationState();
    public final AnimationState fromhatAnimationState = new AnimationState();
    public final AnimationState danceAnimationState = new AnimationState();

    private boolean isDancing = false;

    private boolean wasMoving = false;
    private boolean isFirstTick = true;
    private boolean isTryingToSit = false; 
    private boolean isTryingToWalk = false;
    private int ticksSinceWalkToSitStarted = 0;
    private int ticksSinceSitToWalkStarted = 0;

    private static final EntityDataAccessor<Boolean> IS_DANCING =
        SynchedEntityData.defineId(DomovoiEntity.class, EntityDataSerializers.BOOLEAN);

    
	public DomovoiEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(RitualsOfTheWildsModEntities.DOMOVOI.get(), world);
	}

	public DomovoiEntity(EntityType<DomovoiEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_DANCING, false);
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
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Monster.class, false, false));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}

		});
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.5, Ingredient.of(Items.BREAD), false));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, (float) 8));
		this.goalSelector.addGoal(6, new PanicGoal(this, 1.5));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new FloatGoal(this));
		this.goalSelector.addGoal(9, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(10, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(11, new MoveBackToVillageGoal(this, 0.6, false));


	}

	private boolean isMovingOnLand() {
		return this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
	}

    public boolean isDancing() {
        return this.entityData.get(IS_DANCING);
    }

    public void setDancing(boolean dancing) {
        this.entityData.set(IS_DANCING, dancing);
    }
	
    public void tick() {

    if (!this.level().isClientSide()) {
        boolean shouldDance = isPlayingDanceOfTheBearMusic();
        if (shouldDance != isDancing()) {
            setDancing(shouldDance);
    }
    }

    if (this.level().isClientSide()) {
        if (isFirstTick) {
            if (!this.fromhatAnimationState.isStarted()) {
                this.fromhatAnimationState.startIfStopped(this.tickCount);
            }
            isFirstTick = false;
        }

        if (isDancing()) {
        if (!danceAnimationState.isStarted()) {
            this.idleAnimationState.stop();
            this.walkAnimationState.stop();
            this.sittowalkAnimationState.stop();
            this.walktositAnimationState.stop();
            this.danceAnimationState.start(this.tickCount);
        }
    } else {
        if (danceAnimationState.isStarted()) {
            this.danceAnimationState.stop();
        }
    }
        
        if (this.isMovingOnLand()) {
            if (isTryingToSit) {
                this.walktositAnimationState.stop();
                isTryingToSit = false;
                ticksSinceWalkToSitStarted = 0;
            }

            if (!isTryingToWalk) {
                this.idleAnimationState.stop();
                this.sittowalkAnimationState.startIfStopped(this.tickCount);
                isTryingToWalk = true;
                ticksSinceSitToWalkStarted = 0;
            } else {
                ticksSinceSitToWalkStarted++;
            	
            	if (ticksSinceSitToWalkStarted >= 12) {
                   this.idleAnimationState.stop();
                   this.sittowalkAnimationState.stop();
                   this.walkAnimationState.startIfStopped(this.tickCount); 
                }
            }
        } else {
        	 if (isTryingToWalk) {
                this.sittowalkAnimationState.stop();
                isTryingToWalk = false;
                ticksSinceSitToWalkStarted = 0;
            }
            if (!isTryingToSit) {
                this.walkAnimationState.stop();
                this.walktositAnimationState.startIfStopped(this.tickCount);
                isTryingToSit = true;
                ticksSinceWalkToSitStarted = 0;
            } else {
                ticksSinceWalkToSitStarted++;

                if (ticksSinceWalkToSitStarted >= 15) {
                    this.walkAnimationState.stop();
                    this.walktositAnimationState.stop();
                    this.idleAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
    }

    super.tick();
    }

private boolean isPlayingDanceOfTheBearMusic() {
    for (BlockPos pos : BlockPos.withinManhattan(this.blockPosition(), 5, 5, 5)) {
        BlockState state = this.level().getBlockState(pos);
        if (state.getBlock() instanceof JukeboxBlock && state.getValue(JukeboxBlock.HAS_RECORD)) {
            JukeboxBlockEntity jukebox = (JukeboxBlockEntity) this.level().getBlockEntity(pos);
            if (jukebox != null) {
                ItemStack record = jukebox.getItem(0);
                if (!record.isEmpty()) {
                    ResourceLocation id = ForgeRegistries.ITEMS.getKey(record.getItem());
                    if (id != null && id.toString().equals("rituals_of_the_wilds:dance_of_the_bear")) {
                        return true;
                    }
                }
            }
        }
    }
    return false;
}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(RitualsOfTheWildsModBlocks.STRAW_HAT.get()));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
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
    public void die(DamageSource cause) {
      super.die(cause);

      this.walkAnimationState.stop();
      this.idleAnimationState.stop();
      this.sittowalkAnimationState.stop();
      this.walktositAnimationState.stop();

      this.backtohatAnimationState.startIfStopped(this.tickCount);
      
    }

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.15);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 6);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
