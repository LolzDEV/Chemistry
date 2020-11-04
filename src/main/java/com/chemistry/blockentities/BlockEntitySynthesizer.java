package com.chemistry.blockentities;

import com.chemistry.api.ChemicalComposition;
import com.chemistry.screen.ScreenHandlerSynthesizer;
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
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;
import java.util.ArrayList;

import static net.minecraft.screen.ScreenHandler.canStacksCombine;

public class BlockEntitySynthesizer extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory, Tickable, SidedInventory, EnergyStorage {
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    boolean created = false;
    double energy;



    public BlockEntitySynthesizer() {
        super(BlockEntities.BLOCK_ENTITY_SYNTHESIZER);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return (int) BlockEntitySynthesizer.this.getStored(EnergySide.UNKNOWN);
            }

            public void set(int index, int value) {
                if (index == 0) {
                    BlockEntitySynthesizer.this.setStored(value);
                }

            }

            public int size() {
                return 1;
            }
        };
    }

    @Override
    public double getStored(EnergySide face) {
        return this.energy;
    }

    @Override
    public void setStored(double amount) {
        this.energy = amount;
        this.energy = Math.max(Math.min(this.energy, this.getMaxStoredPower()), 0.0D);

        this.markDirty();
    }

    public void useEnergy(double amount) {
        if (this.energy > amount) {
            this.setStored(this.energy - amount);
        } else {
            this.setStored(0.0D);
        }

    }

    public boolean canInsert(ArrayList<ItemStack> stacks, int startIndex, int endIndex, boolean fromLast){
        boolean[] bls = new boolean[stacks.size()];
        int i = startIndex;
        int ind = 0;
        if (fromLast) {
            i = endIndex - 1;
        }

        for (ItemStack stack : stacks) {
            ItemStack itemStack;
            if (stack.isStackable()) {
                while (!stack.isEmpty()) {
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
                        if (j > stack.getMaxCount()) {
                            stack.setCount(0);
                            itemStack.setCount(j);
                            this.markDirty();
                            bls[ind] = false;
                        } else if (itemStack.getCount() > stack.getMaxCount()) {
                            stack.decrement(stack.getMaxCount() - itemStack.getCount());
                            itemStack.setCount(stack.getMaxCount());
                            this.markDirty();
                            bls[ind] = false;
                        } else {
                            bls[ind] = true;
                        }
                    }

                    if (fromLast) {
                        --i;
                    } else {
                        ++i;
                    }
                }
            }
            ind++;
        }

        for (boolean bl : bls) {
            if(bl){
                return false;
            }
        }
        return true;
    }



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
        return new ScreenHandlerSynthesizer(syncId, inv, this, this.propertyDelegate, this);
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
        created = tag.getBoolean("created");
        energy = tag.getDouble("energy");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        tag.putBoolean("working", created);
        tag.putDouble("energy", energy);
        return tag;
    }

    @Override
    public void tick() {
        ArrayList<ItemStack> current = new ArrayList<>();
        for(ItemStack i : inventory){
            for (int it = 0; it < i.getCount(); it++) {
                current.add(new ItemStack(i.getItem()));
            }
        }
        String formula = FormulaSerializer.serialize(current);
        Item result = ChemicalComposition.getItemFromComposition(formula);
        this.inventory.set(9, new ItemStack(result));
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

    @Override
    public double getMaxStoredPower() {
        return 4000;
    }

    @Override
    public EnergyTier getTier() {
        return EnergyTier.MEDIUM;
    }

    @Override
    public double getMaxInput(EnergySide side) {
        return 128;
    }

    @Override
    public double getMaxOutput(EnergySide side) {
        return 0;
    }
}
