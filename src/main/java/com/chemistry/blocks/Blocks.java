package com.chemistry.blocks;


import com.chemistry.items.ItemGroups;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {

    public static final Block DECOMPOSER = new BlockDecomposer(FabricBlockSettings.of(Material.METAL));
    public static final Block SYNTHESIZER = new BlockSynthesizer(FabricBlockSettings.of(Material.METAL).nonOpaque());

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier("chemistry", "decomposer"), DECOMPOSER);
        Registry.register(Registry.ITEM, new Identifier("chemistry", "decomposer"), new BlockItem(DECOMPOSER, new Item.Settings().group(ItemGroups.CHEMISTRY_MACHINES)));

        Registry.register(Registry.BLOCK, new Identifier("chemistry", "synthesizer"), SYNTHESIZER);
        Registry.register(Registry.ITEM, new Identifier("chemistry", "synthesizer"), new BlockItem(SYNTHESIZER, new Item.Settings().group(ItemGroups.CHEMISTRY_MACHINES)));
    }
}
