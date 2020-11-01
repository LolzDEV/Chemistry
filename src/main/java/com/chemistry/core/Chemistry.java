package com.chemistry.core;

import com.chemistry.blocks.Blocks;
import com.chemistry.elements.Elements;
import com.chemistry.items.Items;
import net.fabricmc.api.ModInitializer;

public class Chemistry implements ModInitializer {
    @Override
    public void onInitialize() {
        Elements.initializeElements();
        Items.registerItems();
        Blocks.registerBlocks();
    }
}
