package com.chemistry.blockentities;

import com.chemistry.api.ChemicalComposition;
import com.chemistry.screen.ScreenHandlerDecomposer;
import com.chemistry.utils.FormulaSerializer;
import com.chemistry.utils.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
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

public class BlockEntityDecomposer extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory, Tickable, SidedInventory, EnergyStorage {

    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    boolean working = false;
    ArrayList<ItemStack> result = new ArrayList<>();
    double energy;


    public BlockEntityDecomposer() {
        super(BlockEntities.BLOCK_ENTITY_DECOMPOSER);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return (int) BlockEntityDecomposer.this.getStored(EnergySide.UNKNOWN);
            }

            public void set(int index, int value) {
                if (index == 0) {
                    BlockEntityDecomposer.this.setStored(value);
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
                System.out.println("false!");
                return false;
            }
        }
        System.out.println("true!");
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
        return new ScreenHandlerDecomposer(syncId, inv, this, this.propertyDelegate);
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
        working = tag.getBoolean("working");
        result = FormulaSerializer.deserialize(tag.getString("result"));
        energy = tag.getDouble("energy");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        tag.putBoolean("working", working);
        tag.putString("result", FormulaSerializer.serialize(result));
        tag.putDouble("energy", energy);
        return tag;
    }

    @Override
    public void tick() {
        if(ChemicalComposition.hasDecomposerComposition(inventory.get(0).getItem()) && !working) {
            for (ItemStack i : FormulaSerializer.deserialize(ChemicalComposition.getDecomposerComposition(inventory.get(0).getItem()))) {
                result.add(i);
            }
            this.inventory.get(0).setCount(this.inventory.get(0).getCount()-1);
            working = true;
        }
        if(working && this.energy >= 32){
            if(result.size() <= 0) working = false;
            for (int i = 0; i < result.size(); i++){
                ItemStack item = result.get(i);
                if (insertItem(item, 1, inventory.size(), false)) {
                    this.useEnergy(32);
                    result.remove(i);
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
