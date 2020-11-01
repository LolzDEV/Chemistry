package com.chemistry.items;

import com.chemistry.api.ItemElement;
import com.chemistry.elements.Elements;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class Items {

    public static HashMap<String, Item> chemistry_elements = new HashMap<>();

    public static final Item TUBE = new Item(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ITEMS));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier("chemistry", "tube"), TUBE);

        for(Map.Entry<String, ItemElement> entry : Elements.elements.entrySet()){
            Registry.register(Registry.ITEM, new Identifier("chemistry", entry.getKey()), entry.getValue());
            chemistry_elements.put("item/" + entry.getKey(), entry.getValue());
        }
    }

}
