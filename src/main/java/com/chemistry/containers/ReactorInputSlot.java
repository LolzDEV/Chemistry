package com.chemistry.containers;

import com.chemistry.api.ItemElement;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;


public class ReactorInputSlot extends Slot {

    public ReactorInputSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {

        if (stack.getItem() instanceof ItemElement){
            return true;
        }

        return false;
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        return true;
    }

    @Override
    public int getMaxItemCount() {
        return 1;
    }
}
