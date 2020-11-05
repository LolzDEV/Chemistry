package com.chemistry.screen;

import com.chemistry.blockentities.BlockEntitySynthesizer;
import com.chemistry.containers.SynthesizerOutputSlot;
import com.chemistry.core.Chemistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ScreenHandlerSynthesizer extends ScreenHandler {
    private final Inventory inventory;
    public PropertyDelegate propertyDelegate;
    BlockEntitySynthesizer synthesizer;

    public ScreenHandlerSynthesizer(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(10), new ArrayPropertyDelegate(1), null);
    }

    public ScreenHandlerSynthesizer(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate, BlockEntitySynthesizer synthesizer) {
        super(Chemistry.SYNTHESIZER_SCREEN_HANDLER, syncId);
        this.propertyDelegate = propertyDelegate;
        checkSize(inventory, 10);
        this.inventory = inventory;
        this.synthesizer = synthesizer;
        inventory.onOpen(playerInventory.player);

        this.addProperties(propertyDelegate);

        int m;
        int l;
        //Input slots
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 3; ++l) {
                this.addSlot(new Slot(inventory, m + l * 3, 8 + (m) * 18, 15 + (l) * 18));
            }
        }

        //Output slot
        this.addSlot(new SynthesizerOutputSlot(inventory, 9, 115, 33, this.synthesizer, this));

        //The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        if(propertyDelegate.get(0) < 500 && invSlot == 9) return ItemStack.EMPTY;
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                } else {
                    if (slot instanceof SynthesizerOutputSlot){
                        this.inventory.clear();
                        if(synthesizer != null) this.synthesizer.useEnergy(500);
                    }
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            } else {
                if (slot instanceof SynthesizerOutputSlot){
                    this.inventory.clear();
                    if(synthesizer != null) this.synthesizer.useEnergy(500);
                }
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    public int getBattery() {
        int i = this.propertyDelegate.get(0);
        if(i == 0) i = 1;
        return i;
    }
}
