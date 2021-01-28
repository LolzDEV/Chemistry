package com.chemistry.containers;

import com.chemistry.blockentities.BlockEntitySynthesizer;
import com.chemistry.screen.ScreenHandlerSynthesizer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;


public class ReactorOutputSlot extends Slot {

    public ReactorOutputSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        return true;
    }



}
