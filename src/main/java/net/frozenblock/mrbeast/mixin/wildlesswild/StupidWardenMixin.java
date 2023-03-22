package net.frozenblock.mrbeast.mixin.wildlesswild;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Warden.class)
public class StupidWardenMixin {

	@Inject(method = "onSignalReceive", at = @At("HEAD"), cancellable = true)
	public void MrBeast$HatesWardens(ServerLevel level, GameEventListener listener, BlockPos sourcePos, GameEvent gameEvent, @Nullable Entity sourceEntity, @Nullable Entity projectileOwner, float distance, CallbackInfo info) {
		Warden warden = Warden.class.cast(this);
		level.explode(warden, warden.getX(), warden.getY(), warden.getZ(), 5F, Level.ExplosionInteraction.MOB);
		warden.discard();
	}

}
