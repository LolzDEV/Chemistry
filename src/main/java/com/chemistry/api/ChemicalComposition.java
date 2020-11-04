package com.chemistry.api;

import net.minecraft.item.Item;
import java.util.HashMap;
import java.util.Map;

public class ChemicalComposition {
    public static HashMap<Item, String> compositions = new HashMap<>();


    public static void addComposition(Item item, String composition){
        compositions.put(item, composition);
    }

    public static String getComposition(Item item){
        return compositions.get(item);
    }

    public static boolean hasComposition(Item item){
       return compositions.containsKey(item);
    }

    public static Item getItemFromComposition(String composition){
        for (Map.Entry<Item, String> entry : compositions.entrySet()) {
            if (entry.getValue().equals(composition)) {
                return entry.getKey();
            }
        }
        return null;
    }


}
