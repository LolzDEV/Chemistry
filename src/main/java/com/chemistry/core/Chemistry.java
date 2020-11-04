package com.chemistry.core;

import com.chemistry.api.ChemicalComposition;
import com.chemistry.blockentities.BlockEntities;
import com.chemistry.blocks.Blocks;
import com.chemistry.elements.Elements;
import com.chemistry.items.Items;
import com.chemistry.screen.ScreenHandlerDecomposer;
import com.chemistry.screen.ScreenHandlerSynthesizer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class Chemistry implements ModInitializer {

    public static final ScreenHandlerType<ScreenHandlerDecomposer> DECOMPOSER_SCREEN_HANDLER;
    public static final ScreenHandlerType<ScreenHandlerSynthesizer> SYNTHESIZER_SCREEN_HANDLER;

    static {
        DECOMPOSER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("chemistry", "decomposer"), ScreenHandlerDecomposer::new);
        SYNTHESIZER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("chemistry", "synthesizer"), ScreenHandlerSynthesizer::new);
    }

    @Override
    public void onInitialize() {
        Elements.initializeElements();
        Items.registerItems();
        Blocks.registerBlocks();
        BlockEntities.registerBlockEntities();

        //Adding chemical compositions
        ChemicalComposition.addComposition(net.minecraft.item.Items.APPLE, "C8He4");
    }
}
