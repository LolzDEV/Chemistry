package com.chemistry.elements;

import com.chemistry.api.ItemElement;
import com.chemistry.items.ItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import java.util.HashMap;

public class Elements {
    public static HashMap<String, ItemElement> elements = new HashMap<>();

    public static void initializeElements(){
        elements.put("hydrogen", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Hydrogen", "H", 1, ChemicalType.GAS));
        elements.put("helium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Helium", "He", 2, ChemicalType.GAS));
        elements.put("lithium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Lithium", "Li", 2, ChemicalType.SOLID));
        elements.put("beryllium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Beryllium", "Be", 3, ChemicalType.SOLID));
        elements.put("boron", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Boron", "B", 5, ChemicalType.SOLID));
        elements.put("carbon", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Carbon", "C", 6, ChemicalType.SOLID));
        elements.put("nitrogen", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Nitrogen", "N", 7, ChemicalType.GAS));
        elements.put("oxygen", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Oxygen", "O", 8, ChemicalType.GAS));
        elements.put("fluorine", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Fluorine", "F", 9, ChemicalType.SOLID));
        elements.put("neon", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Neon", "Ne", 10, ChemicalType.SOLID));
        elements.put("sodium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Sodium", "Na", 11, ChemicalType.SOLID));
        elements.put("magnesium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Magnesium", "Mg", 12, ChemicalType.SOLID));
        elements.put("aluminium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Aluminium", "Al", 13, ChemicalType.SOLID));
        elements.put("silicon", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Silicon", "Si", 14, ChemicalType.SOLID));
    }

}
