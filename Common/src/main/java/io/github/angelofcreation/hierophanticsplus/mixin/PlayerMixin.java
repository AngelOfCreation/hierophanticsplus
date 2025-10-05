package io.github.angelofcreation.hierophanticsplus.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import robotgiggle.hierophantics.data.HieroServerState;


@Mixin(Player.class)
public class PlayerMixin {
  @Inject(method = "tick", at = @At("TAIL"))
  private void fireTickTriggers(CallbackInfo ci) {
    Player player = (Player) (Object) this;
    if (player.level().isClientSide) {
      return;
    }
    HieroServerState.getPlayerState(player).triggerMinds((ServerPlayer) player, "tick");
  }
}
