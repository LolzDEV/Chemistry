package com.chemistry.screen;

import com.chemistry.containers.DecomposerOutputSlot;
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

public class ScreenHandlerDecomposer extends ScreenHandler {
    private final Inventory inventory;
    PropertyDelegate propertyDelegate;

    public ScreenHandlerDecomposer(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(10), new ArrayPropertyDelegate(1));
    }

    public ScreenHandlerDecomposer(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(Chemistry.DECOMPOSER_SCREEN_HANDLER, syncId);
        this.propertyDelegate = propertyDelegate;
        checkSize(inventory, 10);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        this.addProperties(propertyDelegate);

        int m;
        int l;
        //Input slot
        this.addSlot(new Slot(inventory, 0, 80, 20));

        //Output slots
        for (m = 1; m < 10; ++m) {
            this.addSlot(new DecomposerOutputSlot(inventory, m, 8 + (m-1) * 18, 43));
        }

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
