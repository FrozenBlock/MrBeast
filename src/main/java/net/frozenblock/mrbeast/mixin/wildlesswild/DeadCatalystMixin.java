package net.frozenblock.mrbeast.mixin.wildlesswild;

import net.frozenblock.mrbeast.entity.MrBeast;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.SculkCatalystBlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SculkCatalystBlockEntity.class)
public class DeadCatalystMixin {
/*
	@Inject(method = "handleGameEvent", at = @At("HEAD"), cancellable = true)
	public void MrBeast$HatesSculkCatalysts(ServerLevel world, GameEvent event, GameEvent.Context context, Vec3 pos, CallbackInfoReturnable<Boolean> info) {
		if (context.sourceEntity() instanceof MrBeast) {
			world.destroyBlock(SculkCatalystBlockEntity.class.cast(this).getBlockPos(), false);
			info.setReturnValue(false);
		}
	}
*/
}
