package com.chemistry.compounds;

import com.chemistry.api.ChemicalComposition;
import com.chemistry.api.ItemCompound;
import com.chemistry.items.ItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import java.util.HashMap;
import java.util.Map;

public class Compounds {

    public static HashMap<String, ItemCompound> compounds = new HashMap<>();

    public static ItemCompound getFromSymbol(String symbol){
        for(Map.Entry<String, ItemCompound> entry : compounds.entrySet()){
            if (entry.getValue().getSymbol().equals(symbol)) return entry.getValue();
        }
        return null;
    }

    public static void addCompound(String name, String composition){
        compounds.put(name, new ItemCompound(new FabricItemSettings().group(ItemGroups.CHEMISTRY_COMPOUNDS), name, composition));
        ChemicalComposition.addComposition(compounds.get(name), composition);
    }

    public static void initializeElements() {
        addCompound("carbon_dioxide", "CO2");
        addCompound("cellulose", "C6H10O5");
        addCompound("silicon_dioxide", "SiO2");
        addCompound("nitrate", "NO3");
        addCompound("aluminium_oxide", "Al2O3");
        addCompound("magnesium_oxide", "MgO");
        addCompound("potassium_chloride", "KCl");
        addCompound("sodium_chloride", "NaCl");
        addCompound("water", "H2O");
        addCompound("kaolinite", "Al2O3Si2O4H4O2");
        addCompound("protein", "C3H7NO2S");
        addCompound("iron_oxide", "Fe2O3");
        addCompound("sucrose", "C12H22O11");
        addCompound("carbonate", "CO3");
        addCompound("calcium_carbonate", "CaCO3");
        addCompound("phosphate", "PO4");
        addCompound("hydroxide", "OH");
        addCompound("hydroxylapatite", "Ca5P6O24O2H2");

    }
}
