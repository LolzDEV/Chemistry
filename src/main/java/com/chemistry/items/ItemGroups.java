package com.chemistry.items;

import com.chemistry.elements.Elements;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static final ItemGroup CHEMISTRY_ITEMS = FabricItemGroupBuilder.build(
            new Identifier("chemistry", "items"),
            () -> new ItemStack(Items.TUBE));
    public static final ItemGroup CHEMISTRY_ELEMENTS = FabricItemGroupBuilder.build(
            new Identifier("chemistry", "elements"),
            () -> new ItemStack(Elements.elements.get("hydrogen")));
}
