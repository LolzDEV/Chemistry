package com.chemistry.core;

import com.chemistry.api.ChemicalComposition;
import com.chemistry.blockentities.BlockEntities;
import com.chemistry.blocks.Blocks;
import com.chemistry.compounds.Compounds;
import com.chemistry.elements.Elements;
import com.chemistry.items.Items;
import com.chemistry.screen.ScreenHandlerDecomposer;
import com.chemistry.screen.ScreenHandlerMicroscope;
import com.chemistry.screen.ScreenHandlerReactor;
import com.chemistry.screen.ScreenHandlerSynthesizer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;

public class Chemistry implements ModInitializer {

    public static final ScreenHandlerType<ScreenHandlerDecomposer> DECOMPOSER_SCREEN_HANDLER;
    public static final ScreenHandlerType<ScreenHandlerSynthesizer> SYNTHESIZER_SCREEN_HANDLER;
    public static final ScreenHandlerType<ScreenHandlerMicroscope> MICROSCOPE_SCREEN_HANDLER;
    public static final ScreenHandlerType<ScreenHandlerReactor> REACTOR_SCREEN_HANDLER;
    public static final String MODID = "chemistry";


    static {
        DECOMPOSER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("chemistry", "decomposer"), ScreenHandlerDecomposer::new);
        SYNTHESIZER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("chemistry", "synthesizer"), ScreenHandlerSynthesizer::new);
        MICROSCOPE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("chemistry", "microscope"), ScreenHandlerMicroscope::new);
        REACTOR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("chemistry", "reactor"), ScreenHandlerReactor::new);
    }

    @Override
    public void onInitialize() {
        Elements.initializeElements();
        Compounds.initializeElements();
        Items.registerItems();
        Blocks.registerBlocks();
        BlockEntities.registerBlockEntities();

        ChemicalComposition.addSynthesizerRecipe(net.minecraft.item.Items.IRON_INGOT, new ArrayList<>(Arrays.asList("Fe", null, "Fe", null, null, null, null, null, null)));

        //Adding chemical compositions



        ChemicalComposition.addComposition(net.minecraft.item.Items.IRON_INGOT, "Fe2");
        ChemicalComposition.addComposition(net.minecraft.item.Items.IRON_AXE, "Fe6");
        ChemicalComposition.addComposition(net.minecraft.item.Items.IRON_BLOCK, "Fe18");
        ChemicalComposition.addComposition(net.minecraft.item.Items.IRON_HOE, "Fe4");
        ChemicalComposition.addComposition(net.minecraft.item.Items.IRON_SHOVEL, "Fe2");
        ChemicalComposition.addComposition(net.minecraft.item.Items.IRON_SWORD, "Fe4");
        ChemicalComposition.addComposition(net.minecraft.item.Items.IRON_PICKAXE, "Fe6");
        ChemicalComposition.addComposition(net.minecraft.item.Items.IRON_BARS, "Fe2");

    }
}
