package com.chemistry.elements;

import com.chemistry.api.ItemElement;
import com.chemistry.items.ItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import java.util.HashMap;
import java.util.Map;

public class Elements {
    public static HashMap<String, ItemElement> elements = new HashMap<>();

    public static ItemElement getFromSymbol(String symbol){
        for(Map.Entry<String, ItemElement> entry : elements.entrySet()){
            if (entry.getValue().getSymbol().equals(symbol)) return entry.getValue();
        }
        return null;
    }

    public static ItemElement getFromNumber(int atomicNumber){
        for(Map.Entry<String, ItemElement> entry : elements.entrySet()){
            if (entry.getValue().getAtomicNumber() == atomicNumber) return entry.getValue();
        }
        return null;
    }

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
        elements.put("cerium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Cerium", "Ce", 58, ChemicalType.SOLID));
        elements.put("prasseodymium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Prasseodymium", "Pr", 59, ChemicalType.SOLID));
        elements.put("neodymium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Neodymium", "Nd", 60, ChemicalType.SOLID));
        elements.put("promethium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Promethium", "Pm", 61, ChemicalType.SOLID));
        elements.put("samarium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Samarium", "Sm", 62, ChemicalType.SOLID));
        elements.put("europium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Europium", "Eu", 63, ChemicalType.SOLID));
        elements.put("gadolinium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Gadolinium", "Gd", 64, ChemicalType.SOLID));
        elements.put("terbium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Terbium", "Tb", 65, ChemicalType.SOLID));
        elements.put("dysprosium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Dysprosium", "Dy", 66, ChemicalType.SOLID));
        elements.put("holmium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Holmium", "Ho", 67, ChemicalType.SOLID));
        elements.put("erbium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Erbium", "Er", 68, ChemicalType.SOLID));
        elements.put("thulium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Thulium", "Tm", 69, ChemicalType.SOLID));
        elements.put("ytterbium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Ytterbium", "Yb", 70, ChemicalType.SOLID));
        elements.put("lutetium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Lutetium", "Lu", 71, ChemicalType.SOLID));
        elements.put("hafnium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Hafnium", "Hf", 72, ChemicalType.SOLID));
        elements.put("tantalum", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Tantalum", "Ta", 73, ChemicalType.SOLID));
        elements.put("tungsten", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Tungsten", "W", 74, ChemicalType.SOLID));
        elements.put("rhenium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Rhenium", "Re", 75, ChemicalType.SOLID));
        elements.put("osmium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Osmium", "Os", 76, ChemicalType.SOLID));
        elements.put("iridium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Iridium", "Ir", 77, ChemicalType.SOLID));
        elements.put("platinum", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Platinum", "Pt", 78, ChemicalType.SOLID));
        elements.put("gold", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Gold", "Au", 79, ChemicalType.SOLID));
        elements.put("mercury", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Mercury", "Hg", 80, ChemicalType.LIQUID));
        elements.put("thallium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Thallium", "Tl", 81, ChemicalType.SOLID));
        elements.put("lead", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Lead", "Pb", 82, ChemicalType.SOLID));
        elements.put("bismuth", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Bismuth", "Bi", 83, ChemicalType.SOLID));
        elements.put("polonium", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Polonium", "Po", 84, ChemicalType.SOLID));
        elements.put("astatine", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Radon", "Rn", 86, ChemicalType.GAS));
        elements.put("radon", new ItemElement(new FabricItemSettings().group(ItemGroups.CHEMISTRY_ELEMENTS), "Astatine", "At", 85, ChemicalType.SOLID));
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
