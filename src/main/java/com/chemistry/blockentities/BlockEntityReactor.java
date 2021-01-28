package com.chemistry.blockentities;

import com.chemistry.api.ItemElement;
import com.chemistry.blocks.Blocks;
import com.chemistry.elements.Elements;
import com.chemistry.screen.ScreenHandlerReactor;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

import java.util.ArrayList;

import static net.minecraft.screen.ScreenHandler.canStacksCombine;

public class BlockEntityReactor extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory, Tickable, SidedInventory, EnergyStorage {
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    double energy;



    public BlockEntityReactor() {
        super(BlockEntities.BLOCK_ENTITY_REACTOR);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return (int) BlockEntityReactor.this.getStored(EnergySide.UNKNOWN);
            }

            public void set(int index, int value) {
                if (index == 0) {
                    BlockEntityReactor.this.setStored(value);
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


    public boolean checkMultiBlock(){

        boolean check = true;

        int x = this.getPos().getX() - 1;
        int y = this.getPos().getY() - 1;
        int z = this.getPos().getZ() - 1;

        for (int i = x; i < x + 2; i++){
            for (int b = z; b < z + 2; b++){
                BlockState cur = this.world.getBlockState(new BlockPos(x, y, z));
                if (cur != Blocks.REACTOR_CORE.getDefaultState()) check = false;
            }
        }

        x = this.getPos().getX() - 2;
        z = this.getPos().getZ() - 1;

        for (int i = 0; i < 3; i++){
            BlockState cur = this.world.getBlockState(new BlockPos(x, y, z+i));
            if (cur != Blocks.REACTOR_CORE.getDefaultState()) check = false;
        }

        x = this.getPos().getX() + 2;

        for (int i = 0; i < 3; i++){
            BlockState cur = this.world.getBlockState(new BlockPos(x, y, z+i));
            if (cur != Blocks.REACTOR_CORE.getDefaultState()) check = false;
        }

        x = this.getPos().getX() - 1;
        z = this.getPos().getZ() - 2;

        for (int i = 0; i < 3; i++){
            BlockState cur = this.world.getBlockState(new BlockPos(x+i, y, z));
            if (cur != Blocks.REACTOR_CORE.getDefaultState()) check = false;
        }

        x = this.getPos().getX() - 1;
        z = this.getPos().getZ() + 2;

        for (int i = 0; i < 3; i++){
            BlockState cur = this.world.getBlockState(new BlockPos(x+i, y, z));
            if (cur != Blocks.REACTOR_CORE.getDefaultState()) check = false;
        }

        for (int b=0; b < 2; b++) {
            switch (b){
                case 0:
                    y = this.getPos().getY() -1;
                case 1:
                    y = this.getPos().getY();
            }
            x = this.getPos().getX() + 3;
            z = this.getPos().getZ() + 1;

            for (int i = 0; i < 3; i++) {
                BlockState cur = this.world.getBlockState(new BlockPos(x, y, z - i));
                if (cur != Blocks.REACTOR_COIL.getDefaultState()) check = false;
            }

            x = this.getPos().getX() - 3;

            for (int i = 0; i < 3; i++) {
                BlockState cur = this.world.getBlockState(new BlockPos(x, y, z - i));
                if (cur != Blocks.REACTOR_COIL.getDefaultState()) check = false;
            }

            x = this.getPos().getX() + 1;
            z = this.getPos().getZ() - 3;

            for (int i = 0; i < 3; i++) {
                BlockState cur = this.world.getBlockState(new BlockPos(x - i, y, z));
                if (cur != Blocks.REACTOR_COIL.getDefaultState()) check = false;
            }

            z = this.getPos().getZ() + 3;

            for (int i = 0; i < 3; i++) {
                BlockState cur = this.world.getBlockState(new BlockPos(x - i, y, z));
                if (cur != Blocks.REACTOR_COIL.getDefaultState()) check = false;
            }

            x = this.getPos().getX();
            z = this.getPos().getZ();

            BlockState cur = this.world.getBlockState(new BlockPos(x + 2, y, z - 2));
            if (cur != Blocks.REACTOR_COIL.getDefaultState()) check = false;

            cur = this.world.getBlockState(new BlockPos(x + 2, y, z + 2));
            if (cur != Blocks.REACTOR_COIL.getDefaultState()) check = false;

            cur = this.world.getBlockState(new BlockPos(x + 2, y, z - 2));
            if (cur != Blocks.REACTOR_COIL.getDefaultState()) check = false;

            cur = this.world.getBlockState(new BlockPos(x - 2, y, z + 2));
            if (cur != Blocks.REACTOR_COIL.getDefaultState()) check = false;

            cur = this.world.getBlockState(new BlockPos(x - 2, y, z - 2));
            if (cur != Blocks.REACTOR_COIL.getDefaultState()) check = false;
        }
        return check;
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
        return new ScreenHandlerReactor(syncId, inv, this, this.propertyDelegate, this);
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
        energy = tag.getDouble("energy");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        tag.putDouble("energy", energy);
        return tag;
    }

    @Override
    public void tick() {
        if(world.isClient) return;
        System.out.println(checkMultiBlock());
        if (this.energy >= 150000 && this.inventory.get(0) != null && this.inventory.get(0) != ItemStack.EMPTY && this.inventory.get(1) != null && this.inventory.get(1) != ItemStack.EMPTY){
            Item result = Elements.getFromNumber(((ItemElement)this.inventory.get(0).getItem()).getAtomicNumber() + ((ItemElement)this.inventory.get(1).getItem()).getAtomicNumber());
            if (result != null) {
                if (checkMultiBlock() && ((this.inventory.get(2).getItem() == result && this.inventory.get(2).getCount() < 64) || (this.inventory.get(2) == ItemStack.EMPTY || this.inventory.get(2) == null))) {
                    this.useEnergy(150000);
                    this.inventory.set(0, ItemStack.EMPTY);
                    this.inventory.set(1, ItemStack.EMPTY);
                    if(inventory.get(2) == null || inventory.get(2) == ItemStack.EMPTY){
                        this.inventory.set(2, new ItemStack(result));
                    } else {
                        this.inventory.set(2, new ItemStack(result, this.inventory.get(2).getCount()+1));
                    }
                }
            }
        }
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.UP) {
            return new int[]{0, 1};
        }

        return new int[]{2};

    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return (this.inventory.get(slot) == null || this.inventory.get(slot) == ItemStack.EMPTY) && dir == Direction.UP;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return dir != Direction.UP;
    }

    @Override
    public double getMaxStoredPower() {
        return 6000000;
    }

    @Override
    public EnergyTier getTier() {
        return EnergyTier.EXTREME;
    }

    @Override
    public double getMaxInput(EnergySide side) {
        return 200000;
    }

    @Override
    public double getMaxOutput(EnergySide side) {
        return 0;
    }
}
