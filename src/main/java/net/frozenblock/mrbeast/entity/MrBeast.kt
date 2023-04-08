package net.frozenblock.mrbeast.entity;

import net.frozenblock.lib.FrozenMain;
import net.frozenblock.lib.spotting_icons.impl.EntitySpottingIconInterface;
import net.frozenblock.mrbeast.registry.RegisterSounds;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class MrBeast extends PathfinderMob {

	private static final float SOUND_VOLUME = 3.5F;

	public MrBeast(EntityType<? extends MrBeast> entityType, Level level) {
		super(entityType, level);
		((EntitySpottingIconInterface) this).getSpottingIconManager().setIcon(MrBeastSharedConstants.id("beast_icon.png"), 8, 12, FrozenMain.id("default"));
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.8D, Ingredient.of(Items.EMERALD), false));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 24.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}

	public static AttributeSupplier.Builder addAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, SpawnGroupData spawnData, CompoundTag nbt) {
		this.playSound(RegisterSounds.MRBEAST_SPAWN, 10.0F, 1.0F);
		return super.finalizeSpawn(level, difficulty, spawnType, spawnData, nbt);
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	protected float getSoundVolume() {
		return SOUND_VOLUME;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return RegisterSounds.MRBEAST_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return RegisterSounds.MRBEAST_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource damageSource) {
		return RegisterSounds.MRBEAST_HURT;
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(RegisterSounds.MRBEAST_STEP, 2.0F, 1.0F);
	}
}
