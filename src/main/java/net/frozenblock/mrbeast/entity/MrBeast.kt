package net.frozenblock.mrbeast.entity

import net.frozenblock.lib.FrozenMain
import net.frozenblock.lib.spotting_icons.impl.EntitySpottingIconInterface
import net.frozenblock.mrbeast.registry.RegisterSounds
import net.frozenblock.mrbeast.util.MrBeastSharedConstants.id
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.sounds.SoundEvent
import net.minecraft.util.RandomSource
import net.minecraft.world.DifficultyInstance
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobSpawnType
import net.minecraft.world.entity.PathfinderMob
import net.minecraft.world.entity.SpawnGroupData
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.ai.goal.*
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.ServerLevelAccessor
import net.minecraft.world.level.block.state.BlockState

class MrBeast(entityType: EntityType<out MrBeast>, level: Level) : PathfinderMob(entityType, level) {
    companion object {
        private const val SOUND_VOLUME = 3.5f

        @JvmStatic
        fun addAttributes(): AttributeSupplier.Builder {
            return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25)
        }

        @JvmStatic
        fun checkSpawnRules(
            mrbeast: EntityType<out MrBeast>,
            level: LevelAccessor,
            spawnType: MobSpawnType,
            pos: BlockPos,
            random: RandomSource
        ): Boolean {
            return level.getRawBrightness(pos, 0) > 8 && pos.y > 58
        }
    }

    init {
        (this as EntitySpottingIconInterface).spottingIconManager.setIcon(
            id("icon.png"),
            8f,
            12f,
            FrozenMain.id("default")
        )
    }

    override fun registerGoals() {
        goalSelector.addGoal(0, FloatGoal(this))
        goalSelector.addGoal(1, PanicGoal(this, 2.0))
        goalSelector.addGoal(4, TemptGoal(this, 1.8, Ingredient.of(Items.EMERALD), false))
        goalSelector.addGoal(6, WaterAvoidingRandomStrollGoal(this, 1.0))
        goalSelector.addGoal(7, LookAtPlayerGoal(this, Player::class.java, 24.0f))
        goalSelector.addGoal(8, RandomLookAroundGoal(this))
    }

    override fun finalizeSpawn(
        level: ServerLevelAccessor,
        difficulty: DifficultyInstance,
        spawnType: MobSpawnType,
        spawnData: SpawnGroupData?,
        nbt: CompoundTag?
    ): SpawnGroupData? {
        this.playSound(RegisterSounds.MRBEAST_SPAWN, 10.0f, 1.0f)
        return super.finalizeSpawn(level, difficulty, spawnType, spawnData, nbt)
    }

    override fun removeWhenFarAway(distanceToClosestPlayer: Double): Boolean {
        return false
    }

    override fun getSoundVolume(): Float {
        return SOUND_VOLUME
    }

    public override fun getAmbientSound(): SoundEvent {
        return RegisterSounds.MRBEAST_AMBIENT
    }

    public override fun getDeathSound(): SoundEvent {
        return RegisterSounds.MRBEAST_DEATH
    }

    public override fun getHurtSound(damageSource: DamageSource): SoundEvent {
        return RegisterSounds.MRBEAST_HURT
    }

    public override fun playStepSound(pos: BlockPos, state: BlockState) {
        this.playSound(RegisterSounds.MRBEAST_STEP, 2.0f, 1.0f)
    }
}
