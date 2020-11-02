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
        elements.put("phosphor", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Phosphor", "P", 15, ChemicalType.SOLID));
        elements.put("sulfur", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Sulfur", "S", 16, ChemicalType.SOLID));
        elements.put("chlorine", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Chlorine", "Cl", 17, ChemicalType.LIQUID));
        elements.put("argon", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Argon", "Ar", 18, ChemicalType.GAS));
        elements.put("potassium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Potassium", "K", 19, ChemicalType.SOLID));
        elements.put("calcium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Calcium", "Ca", 20, ChemicalType.SOLID));
        elements.put("scandium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Scandium", "Sc", 21, ChemicalType.SOLID));
        elements.put("titanium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Titanium", "Ti", 22, ChemicalType.SOLID));
        elements.put("vanadium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Vanadium", "V", 23, ChemicalType.SOLID));
        elements.put("chromium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Chromium", "Cr", 24, ChemicalType.SOLID));
        elements.put("manganese", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Manganese", "Mn", 25, ChemicalType.SOLID));
        elements.put("iron", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Iron", "Fe", 26, ChemicalType.SOLID));
        elements.put("cobalt", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Cobalt", "Co", 27, ChemicalType.SOLID));
        elements.put("nickel", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Nickel", "Ni", 28, ChemicalType.SOLID));
        elements.put("copper", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Copper", "Cu", 29, ChemicalType.SOLID));
        elements.put("zinc", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Zinc", "Zn", 30, ChemicalType.SOLID));
        elements.put("gallium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Gallium", "Ga", 31, ChemicalType.SOLID));
        elements.put("germanium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Germanium", "Ge", 32, ChemicalType.SOLID));
        elements.put("arsenic", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Arsenic", "As", 33, ChemicalType.SOLID));
        elements.put("selenium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Selenium", "Se", 34, ChemicalType.SOLID));
        elements.put("bromine", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Bromine", "Br", 35, ChemicalType.LIQUID));
        elements.put("krypton", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Krypton", "Kr", 36, ChemicalType.GAS));
        elements.put("rubidium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Rubidium", "Rb", 37, ChemicalType.SOLID));
        elements.put("strontium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Strontium", "Sr", 38, ChemicalType.SOLID));
        elements.put("yttrium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Yttrium", "Y", 39, ChemicalType.SOLID));
        elements.put("zincronium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Zincronium", "Zr", 40, ChemicalType.SOLID));
        elements.put("niobium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Niobium", "Nb", 41, ChemicalType.SOLID));
        elements.put("molybdenum", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Molybdenum", "Mo", 42, ChemicalType.SOLID));
        elements.put("technetium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Technetium", "Tc", 43, ChemicalType.SOLID));
        elements.put("ruthenium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Ruthenium", "Ru", 44, ChemicalType.SOLID));
        elements.put("rhodium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Rhodium", "Rh", 45, ChemicalType.SOLID));
        elements.put("palladium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Palladium", "Pd", 46, ChemicalType.SOLID));
        elements.put("silver", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Silver", "Ag", 47, ChemicalType.SOLID));
        elements.put("cadmium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Cadmium", "Cd", 48, ChemicalType.SOLID));
        elements.put("indium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Indium", "In", 49, ChemicalType.SOLID));
        elements.put("tin", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Tin", "Sn", 50, ChemicalType.SOLID));
        elements.put("antimony", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Antimony", "Sb", 51, ChemicalType.SOLID));
        elements.put("tellurium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Tellurium", "Te", 52, ChemicalType.SOLID));
        elements.put("iodine", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Iodine", "I", 53, ChemicalType.SOLID));
        elements.put("xenon", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Xenon", "Xe", 54, ChemicalType.GAS));
        elements.put("cesium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Cesium", "Cs", 55, ChemicalType.SOLID));
        elements.put("barium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Barium", "Ba", 56, ChemicalType.SOLID));
        elements.put("lanthanum", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Lanthanum", "La", 57, ChemicalType.SOLID));

    }

}
