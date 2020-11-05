package com.chemistry.containers;

import com.chemistry.blockentities.BlockEntitySynthesizer;
import com.chemistry.screen.ScreenHandlerSynthesizer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;


public class SynthesizerOutputSlot extends Slot {

    BlockEntitySynthesizer synthesizer;
    ScreenHandlerSynthesizer handler;

    public SynthesizerOutputSlot(Inventory inventory, int index, int x, int y, BlockEntitySynthesizer synthesizer, ScreenHandlerSynthesizer handler) {
        super(inventory, index, x, y);
        this.synthesizer = synthesizer;
        this.handler = handler;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        return this.handler.propertyDelegate.get(0) >= 500;
    }

    @Override
    public ItemStack onTakeItem(PlayerEntity player, ItemStack stack) {
        inventory.clear();
        if(synthesizer != null) this.synthesizer.useEnergy(500); //On the client-side synthesizer is null
        return ItemStack.EMPTY;
    }

}
