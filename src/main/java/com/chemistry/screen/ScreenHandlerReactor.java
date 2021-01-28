package com.chemistry.screen;

import com.chemistry.blockentities.BlockEntityReactor;
import com.chemistry.blockentities.BlockEntitySynthesizer;
import com.chemistry.containers.ReactorInputSlot;
import com.chemistry.containers.ReactorOutputSlot;
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

public class ScreenHandlerReactor extends ScreenHandler {
    private final Inventory inventory;
    public PropertyDelegate propertyDelegate;
    BlockEntityReactor reactor;

    public ScreenHandlerReactor(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(3), new ArrayPropertyDelegate(1), null);
    }

    public ScreenHandlerReactor(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate, BlockEntityReactor reactor) {
        super(Chemistry.REACTOR_SCREEN_HANDLER, syncId);
        this.propertyDelegate = propertyDelegate;
        checkSize(inventory, 3);
        this.inventory = inventory;
        this.reactor = reactor;
        inventory.onOpen(playerInventory.player);

        this.addProperties(propertyDelegate);

        int m;
        int l;
        //Input slots
        this.addSlot(new ReactorInputSlot(inventory, 0, 44, 33));
        this.addSlot(new ReactorInputSlot(inventory, 1, 116, 33));

        //Output slot
        this.addSlot(new ReactorOutputSlot(inventory, 2, 80, 33));

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
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
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
