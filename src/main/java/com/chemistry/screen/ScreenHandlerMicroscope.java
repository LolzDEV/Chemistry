package com.chemistry.screen;

import com.chemistry.containers.MicroscopeResultSlot;
import com.chemistry.core.Chemistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ScreenHandlerMicroscope extends ScreenHandler {

    private final Inventory inventory;

    public ScreenHandlerMicroscope(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(10));
    }

    public ScreenHandlerMicroscope(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(Chemistry.MICROSCOPE_SCREEN_HANDLER, syncId);
        checkSize(inventory, 10);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        int m;
        int l;
        int sl = 1;

        //Input slot
        this.addSlot(new Slot(inventory, 0, 26, 34));

        //Result slots
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 3; ++l) {
                this.addSlot(new MicroscopeResultSlot(inventory, sl, 116 + (l) * 18, 17 + (m) * 18));
                sl++;
            }
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


}
