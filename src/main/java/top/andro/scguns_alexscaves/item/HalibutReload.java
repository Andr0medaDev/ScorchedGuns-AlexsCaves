package top.andro.scguns_alexscaves.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.andro.scguns_alexscaves.init.ModItems;
import top.ribs.scguns.item.GunItem;
import top.ribs.scguns.util.GunModifierHelper;

public class HalibutReload {
    private static void isUnderWater(ServerPlayer player) {
        ItemStack heldItem = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (!(heldItem.getItem() instanceof GunItem gunItem)) {
            return;
        }

        if (heldItem.is(ModItems.HALIBUT_CANNON.get())) {
            if (player.isUnderWater()) {
                if (!player.isCreative()) {
                    CompoundTag tag = heldItem.getOrCreateTag();
                    int currentAmmo = tag.getInt("AmmoCount");

                    GunItem gun = (GunItem) heldItem.getItem();

                    int maxAmmo = GunModifierHelper.getModifiedAmmoCapacity(heldItem, gun.getModifiedGun(heldItem));

                    int newAmmo = Math.min(Math.max(0, currentAmmo), maxAmmo);
                    tag.putInt("AmmoCount", newAmmo);
                }
            }
        }
    }
}
