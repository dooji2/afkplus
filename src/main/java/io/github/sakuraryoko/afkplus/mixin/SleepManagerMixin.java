package io.github.sakuraryoko.afkplus.mixin;

import static io.github.sakuraryoko.afkplus.config.ConfigManager.CONFIG;

import io.github.sakuraryoko.afkplus.data.IAfkPlayer;
import io.github.sakuraryoko.afkplus.util.AfkPlusLogger;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.SleepManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;

@Mixin(SleepManager.class)
public class SleepManagerMixin {
    @Shadow private int total;
    @Shadow private int sleeping;

    @Inject(method = "update(Ljava/util/List;)Z",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/server/network/ServerPlayerEntity;isSleeping()Z",
                    shift = At.Shift.BEFORE),
                    locals = LocalCapture.CAPTURE_FAILHARD)
    private void checkSleepCount(List<ServerPlayerEntity> players, CallbackInfoReturnable<Boolean> cir,
                                 int i, int j, Iterator var4, ServerPlayerEntity serverPlayerEntity) {
        // Count AFK Players into the total, they can't be marked as Sleeping, so don't increment that value.
        IAfkPlayer player = (IAfkPlayer) serverPlayerEntity;
        AfkPlusLogger.debug("checkSleepCount(): Current values i:"+i+" j:"+j+" // total: "+this.total+" sleeping: "+this.sleeping);
        if (player.afkplus$isAfk() && CONFIG.packetOptions.bypassSleepCount) {
            AfkPlusLogger.info("AFK Player: "+player.afkplus$getName()+" is being excluded from the sleep requirements.");
            --this.total;
        }
    }
}
