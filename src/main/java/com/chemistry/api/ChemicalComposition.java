package com.chemistry.api;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChemicalComposition {
    public static HashMap<Item, ArrayList<String>> synthesizer_recipes = new HashMap<>();
    public static HashMap<Item, String> compositions = new HashMap<>();

    public static void addComposition(Item item, String composition){
        compositions.put(item, composition);
    }

    public static void addSynthesizerRecipe(Item item, ArrayList<String> recipe){
        synthesizer_recipes.put(item, recipe);
    }

    public static String getDecomposerComposition(Item item){
        return compositions.get(item);
    }

    public static boolean hasDecomposerComposition(Item item){
       return compositions.containsKey(item);
    }

    public static ArrayList<String> getSynthesizerRecipe(Item item){
        return synthesizer_recipes.get(item);
    }

    public static boolean hasSynthesizerRecipe(Item item){
        return synthesizer_recipes.containsKey(item);
    }

    public static Item getItemFromRecipe(ArrayList<String> recipe){
        for (Map.Entry<Item, ArrayList<String>> entry : synthesizer_recipes.entrySet()) {
            if (entry.getValue().equals(recipe)) {
                return entry.getKey();
            }
        }
        return null;
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
