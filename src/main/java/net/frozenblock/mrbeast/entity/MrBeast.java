package net.frozenblock.mrbeast.entity;

import net.frozenblock.mrbeast.registry.RegisterSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class MrBeast extends PathfinderMob {

	// do not save this to NBT. It should be used each time the entity is loaded.
	private boolean firstTick = true;

	public MrBeast(EntityType<? extends MrBeast> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier.Builder addAttributes() {
		return PathfinderMob.createMobAttributes();
	}

	@Override
	public void tick() {
		super.tick();
		if (this.firstTick) {
			this.firstTick = false;
			this.level.playSound(null, this, RegisterSounds.MRBEAST_SPAWN, getSoundSource(), 10.0F, 1.0F);
		}
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
