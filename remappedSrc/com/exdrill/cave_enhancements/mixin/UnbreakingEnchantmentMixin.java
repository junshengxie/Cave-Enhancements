package com.exdrill.cave_enhancements.mixin;

import com.exdrill.cave_enhancements.registry.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DigDurabilityEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DigDurabilityEnchantment.class)
public class UnbreakingEnchantmentMixin {
    @Inject(method="isAcceptableItem", at = @At("HEAD"), cancellable=true)
    private void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> ci) {
        if(stack.getItem() == ModItems.GLOW_PASTE){
            ci.setReturnValue(false);
        }
    }
}
