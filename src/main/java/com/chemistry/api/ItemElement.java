package com.chemistry.api;

import com.chemistry.elements.ChemicalType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class ItemElement extends Item {

    String symbol;
    int atomicNumber;
    ChemicalType type;
    String name;

    public ItemElement(Settings settings, String name, String symbol, int atomicNumber, ChemicalType type) {
        super(settings);
        this.symbol = symbol;
        this.name = name;
        this.atomicNumber = atomicNumber;
        this.type = type;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        tooltip.add(new TranslatableText("§3" + String.valueOf(this.atomicNumber).concat(" - ").concat(this.name)));

        if(this.type == ChemicalType.SOLID) tooltip.add(new TranslatableText("chemistry.solid.tooltip"));
        if(this.type == ChemicalType.LIQUID) tooltip.add(new TranslatableText("chemistry.liquid.tooltip"));
        if(this.type == ChemicalType.GAS) tooltip.add(new TranslatableText("chemistry.gas.tooltip"));
        if(this.type == ChemicalType.Unknown) tooltip.add(new TranslatableText("chemistry.unknown.tooltip"));
    }

    //Getters and setters

    /**
     * @return the element name
     */
    public String getElementName() {
        return name;
    }

    public void setElementName(String name) {
        this.name = name;
    }

    /**
     * @return the element symbol: e.g. H for Hydrogen
     */
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the element atomic number: e.g. 1 for Hydrogen
     */
    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    /**
     * @return the element state: Solid, Liquid, Gas or Unknown
     */
    public ChemicalType getType() {
        return type;
    }

    public void setType(ChemicalType type) {
        this.type = type;
    }
}
