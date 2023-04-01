package net.frozenblock.mrbeast.mixin.wildlesswild;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Allay.class)
public class AllayMixin extends PathfinderMob {

	protected AllayMixin(EntityType<? extends PathfinderMob> entityType, Level level) {
		super(entityType, level);
	}

	@Inject(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/allay/Allay;setItemInHand(Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/item/ItemStack;)V", ordinal = 0))
	private void displayCannotSleepMessage(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
		player.displayClientMessage(Player.BedSleepingProblem.NOT_POSSIBLE_NOW.getMessage(), true);
	}

	@Override
	public void setItemInHand(InteractionHand hand, ItemStack stack) {
		this.level.explode(this, this.getX(), this.getY(), this.getZ(), 5F, Level.ExplosionInteraction.MOB);
		this.discard();
	}
}
