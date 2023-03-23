package net.frozenblock.mrbeast.mixin.wildlesswild;

import net.frozenblock.mrbeast.entity.MrBeast;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.SculkShriekerBlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SculkShriekerBlockEntity.class)
public class DeadShriekerMixin {
/*
	@Inject(method = "shouldListen", at = @At("HEAD"), cancellable = true)
	public void MrBeast$HatesSculkShriekers(ServerLevel level, GameEventListener listener, BlockPos pos, GameEvent gameEvent, @Nullable GameEvent.Context context, CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(false);
		level.destroyBlock(SculkShriekerBlockEntity.class.cast(this).getBlockPos(), false);
	}
*/
}
