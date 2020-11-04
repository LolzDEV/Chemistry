package com.chemistry.containers;

import com.chemistry.blockentities.BlockEntitySynthesizer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import team.reborn.energy.EnergySide;

public class SynthesizerOutputSlot extends Slot {

    BlockEntitySynthesizer synthesizer;

    public SynthesizerOutputSlot(Inventory inventory, int index, int x, int y, BlockEntitySynthesizer synthesizer) {
        super(inventory, index, x, y);
        this.synthesizer = synthesizer;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        if(synthesizer != null) return this.synthesizer.getStored(EnergySide.UNKNOWN) >= 500;
        return true;
    }

    @Override
    public ItemStack onTakeItem(PlayerEntity player, ItemStack stack) {
        inventory.clear();
        if(synthesizer != null) this.synthesizer.useEnergy(500); //On the client-side synthesizer is null
        return ItemStack.EMPTY;
    }

}
