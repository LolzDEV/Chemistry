package com.chemistry.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class SynthesizerOutputSlot extends Slot {

    public SynthesizerOutputSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack onTakeItem(PlayerEntity player, ItemStack stack) {
        inventory.clear();
        return stack;
    }
}
