package com.chemistry.api;

import com.chemistry.elements.ChemicalType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class ItemCompound extends Item {

    String symbol;
    ChemicalType type;
    String name;

    public ItemCompound(Settings settings, String name, String symbol) {
        super(settings);
        this.symbol = symbol;
        this.name = name;
        this.type = ChemicalType.COMPOUND;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        tooltip.add(new TranslatableText("§3".concat(this.symbol)));
        tooltip.add(new TranslatableText("chemistry.compound.tooltip"));
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
     * @return the element state: Solid, Liquid, Gas or Unknown
     */
    public ChemicalType getType() {
        return type;
    }

    public void setType(ChemicalType type) {
        this.type = type;
    }
}
