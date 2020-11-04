package com.chemistry.items;

import com.chemistry.api.ItemElement;
import com.chemistry.blocks.Blocks;
import com.chemistry.elements.Elements;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.TreeMap;

public class ItemGroups {
    public static final ItemGroup CHEMISTRY_ITEMS = FabricItemGroupBuilder.build(
            new Identifier("chemistry", "items"),
            () -> new ItemStack(Items.TUBE));
    public static final ItemGroup CHEMISTRY_ELEMENTS = FabricItemGroupBuilder.create(
            new Identifier("chemistry", "elements")).icon(() -> new ItemStack(Elements.elements.get("hydrogen"))).appendItems(itemStacks -> {
            TreeMap<Integer, ItemElement> sorted = new TreeMap<>();
            for(Map.Entry<String, ItemElement> entry : Elements.elements.entrySet()) sorted.put(entry.getValue().getAtomicNumber(), entry.getValue());
            for(Map.Entry<Integer, ItemElement> entry : sorted.entrySet()) itemStacks.add(new ItemStack(entry.getValue()));
    }).build();
    public static final ItemGroup CHEMISTRY_MACHINES = FabricItemGroupBuilder.build(
            new Identifier("chemistry", "machines"),
            () -> new ItemStack(Blocks.DECOMPOSER));
}
