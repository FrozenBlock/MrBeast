package net.frozenblock.mrbeast.mixin.wildlesswild;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Allay.class)
public class AllayMixin extends PathfinderMob {

	protected AllayMixin(EntityType<? extends PathfinderMob> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public void setItemInHand(InteractionHand hand, ItemStack stack) {
		this.level.explode(this, this.getX(), this.getY(), this.getZ(), 5F, Level.ExplosionInteraction.MOB);
		this.discard();
	}
}
