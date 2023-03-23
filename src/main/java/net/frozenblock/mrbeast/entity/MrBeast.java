package net.frozenblock.mrbeast.entity;

import net.frozenblock.mrbeast.registry.RegisterSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class MrBeast extends PathfinderMob {

	private static final float SOUND_VOLUME = 3.5F;

	public MrBeast(EntityType<? extends MrBeast> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier.Builder addAttributes() {
		return PathfinderMob.createMobAttributes();
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, SpawnGroupData spawnData, CompoundTag nbt) {
		this.playSound(RegisterSounds.MRBEAST_SPAWN, 10.0F, 1.0F);
		return super.finalizeSpawn(level, difficulty, spawnType, spawnData, nbt);
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
	public SoundEvent getHurtSound(DamageSource damageSource) {
		return RegisterSounds.MRBEAST_HURT;
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(RegisterSounds.MRBEAST_STEP, 2.0F, 1.0F);
	}
}
