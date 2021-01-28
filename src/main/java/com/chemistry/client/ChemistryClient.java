package com.chemistry.client;

import com.chemistry.core.Chemistry;
import com.chemistry.screen.DecomposerScreen;
import com.chemistry.screen.MicroscopeScreen;
import com.chemistry.screen.ReactorScreen;
import com.chemistry.screen.SynthesizerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class ChemistryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(Chemistry.DECOMPOSER_SCREEN_HANDLER, DecomposerScreen::new);
        ScreenRegistry.register(Chemistry.SYNTHESIZER_SCREEN_HANDLER, SynthesizerScreen::new);
        ScreenRegistry.register(Chemistry.MICROSCOPE_SCREEN_HANDLER, MicroscopeScreen::new);
        ScreenRegistry.register(Chemistry.REACTOR_SCREEN_HANDLER, ReactorScreen::new);
    }
}
