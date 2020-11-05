package com.chemistry.blockentities;

import com.chemistry.api.ChemicalComposition;
import com.chemistry.screen.ScreenHandlerMicroscope;
import com.chemistry.utils.FormulaSerializer;
import com.chemistry.utils.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import static net.minecraft.screen.ScreenHandler.canStacksCombine;

public class BlockEntityMicroscope extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory, Tickable, SidedInventory {
    public BlockEntityMicroscope() {
        super(BlockEntities.BLOCK_ENTITY_MICROSCOPE);
    }

    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);

    protected boolean insertItem(ItemStack stack, int startIndex, int endIndex, boolean fromLast) {
        boolean bl = false;
        int i = startIndex;
        if (fromLast) {
            i = endIndex - 1;
        }

        ItemStack itemStack;
        if (stack.isStackable()) {
            while(!stack.isEmpty()) {
                if (fromLast) {
                    if (i < startIndex) {
                        break;
                    }
                } else if (i >= endIndex) {
                    break;
                }

                itemStack = this.inventory.get(i);
                if (!itemStack.isEmpty() && canStacksCombine(stack, itemStack)) {
                    int j = itemStack.getCount() + stack.getCount();
                    if (j <= stack.getMaxCount()) {
                        stack.setCount(0);
                        itemStack.setCount(j);
                        this.markDirty();
                        bl = true;
                    } else if (itemStack.getCount() < stack.getMaxCount()) {
                        stack.decrement(stack.getMaxCount() - itemStack.getCount());
                        itemStack.setCount(stack.getMaxCount());
                        this.markDirty();
                        bl = true;
                    }
                }

                if (fromLast) {
                    --i;
                } else {
                    ++i;
                }
            }
        }

        if (!stack.isEmpty()) {
            if (fromLast) {
                i = endIndex - 1;
            } else {
                i = startIndex;
            }

            while(true) {
                if (fromLast) {
                    if (i < startIndex) {
                        break;
                    }
                } else if (i >= endIndex) {
                    break;
                }

                itemStack = this.inventory.get(i);
                if (itemStack.isEmpty()) {
                    if (stack.getCount() > this.inventory.get(i).getMaxCount()) {
                        this.inventory.set(i,stack.split(this.inventory.get(i).getMaxCount()));
                    } else {
                        this.inventory.set(i, stack.split(stack.getCount()));
                    }

                    this.markDirty();
                    bl = true;
                    break;
                }

                if (fromLast) {
                    --i;
                } else {
                    ++i;
                }
            }
        }

        return bl;
    }



    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ScreenHandlerMicroscope(syncId, inv, this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        inventory = DefaultedList.ofSize(this.inventory.size(), ItemStack.EMPTY);
        Inventories.fromTag(tag, this.inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        return tag;
    }

    @Override
    public void tick() {
        if(inventory.get(0).equals(ItemStack.EMPTY)){
            inventory.clear();
        } else {
            ArrayList<String> recipe = ChemicalComposition.getSynthesizerRecipe(inventory.get(0).getItem());
            if (recipe != null) {
                int slot = 1;
                for (int i = 0; i < recipe.size(); i++) {
                    if (recipe.get(i) == null) {
                        inventory.set(slot, ItemStack.EMPTY);
                    } else {
                        ArrayList<ItemStack> cell = FormulaSerializer.deserialize(recipe.get(i));
                        inventory.set(slot, cell.get(0));
                    }
                    slot++;
                }
            }
        }
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return new int[0];
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return dir == Direction.UP;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return dir != Direction.UP;
    }
}
