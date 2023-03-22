package net.frozenblock.mrbeast.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;

public class MrBeast extends PathfinderMob {

	public MrBeast(EntityType<? extends MrBeast> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier.Builder addAttributes() {
		return PathfinderMob.createMobAttributes();
	}
}
