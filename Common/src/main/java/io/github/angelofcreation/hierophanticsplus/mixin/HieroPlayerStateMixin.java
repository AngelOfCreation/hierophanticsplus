package io.github.angelofcreation.hierophanticsplus.mixin;

import at.petrak.hexcasting.api.casting.iota.Iota;
import java.util.List;
import java.util.Map;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import robotgiggle.hierophantics.data.HieroMind;
import robotgiggle.hierophantics.data.HieroPlayerState;

@Mixin(value = robotgiggle.hierophantics.data.HieroPlayerState.class, remap = false)
public abstract class HieroPlayerStateMixin {

  @Shadow
  public abstract Map<String, HieroMind> getHieroMinds();

  @Shadow
  public abstract boolean getDisabled();

  @Inject(method = "triggerMinds", at = @At("HEAD"), cancellable = true)
  private void triggerMinds(ServerPlayer player, String trigger, List<Iota> initialStack, CallbackInfo ci) {
    getHieroMinds().forEach((string, mind) -> {
      if (mind.getTrigger().type().equals(trigger)) {
        if (!trigger.equals("tick") || !getDisabled()) {
          mind.cast(player, initialStack);
        }
      }
      ci.cancel();
    });
  }
}
