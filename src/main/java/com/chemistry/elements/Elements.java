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

        elements.put("francium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Francium", "Fr", 87, ChemicalType.Unknown));
        elements.put("radium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Radium", "Ra", 88, ChemicalType.SOLID));
        elements.put("actinium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Actinium", "Ac", 89, ChemicalType.SOLID));
        elements.put("thorium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Thorium", "Th", 90, ChemicalType.SOLID));
        elements.put("protactinium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Protactinium", "Pa", 91, ChemicalType.SOLID));
        elements.put("uranium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Uranium", "U", 92, ChemicalType.SOLID));
        elements.put("neptunium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Neptunium", "Np", 93, ChemicalType.SOLID));
        elements.put("plutonium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Plutonium", "Pu", 94, ChemicalType.SOLID));
        elements.put("americium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Americium", "Am", 95, ChemicalType.SOLID));
        elements.put("curium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Curium", "Cm", 96, ChemicalType.SOLID));
        elements.put("berkelium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Berkelium", "Bk", 97, ChemicalType.SOLID));
        elements.put("californium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Californium", "Cf", 98, ChemicalType.SOLID)); // The CurseForge element
        elements.put("einsteinium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Einsteinium", "Es", 99, ChemicalType.SOLID));
        elements.put("fermium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Fermium", "Fm", 100, ChemicalType.SOLID));
        elements.put("mendelevium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Mendelevium", "Md", 101, ChemicalType.SOLID)); // The MarkDown element
        elements.put("nobelium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Nobelium", "No", 102, ChemicalType.SOLID));
        elements.put("lawrencium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Lawrencium", "Lr", 103, ChemicalType.SOLID));
        elements.put("rutherfordium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Rutherfordium", "Rf", 104, ChemicalType.Unknown));
        elements.put("dubnium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Dubnium", "Db", 105, ChemicalType.Unknown)); // The Database element
        elements.put("seaborgium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Seaborgium", "Sg", 106, ChemicalType.Unknown));
        elements.put("bohrium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Bohrium", "Bh", 107, ChemicalType.Unknown));
        elements.put("hassium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Hassium", "Hs", 108, ChemicalType.Unknown));
        elements.put("meitnerium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Meitnerium", "Mt", 109, ChemicalType.Unknown));
        elements.put("darmstadtium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Darmstadtium", "Ds", 110, ChemicalType.Unknown));
        elements.put("roentgenium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Roentgenium", "Rg", 111, ChemicalType.Unknown));
        elements.put("copernicium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Copernicium", "Cn", 112, ChemicalType.Unknown));
        elements.put("nihonium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Nihonium", "Nh", 113, ChemicalType.Unknown));
        elements.put("flerovium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Flerovium", "Fl", 114, ChemicalType.Unknown));
        elements.put("moscovium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Moscovium", "Mc", 115, ChemicalType.Unknown)); // The Minecraft element
        elements.put("livermorium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Livermorium", "Lv", 116, ChemicalType.Unknown));
        elements.put("tennessine", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Tennessine", "Ts", 117, ChemicalType.Unknown)); // The Typescript element
        elements.put("oganesson", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Oganesson", "Og", 118, ChemicalType.Unknown));
    }
}
