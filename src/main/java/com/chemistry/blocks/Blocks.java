package com.chemistry.blocks;


import com.chemistry.items.ItemGroups;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {

    public static final Block DECOMPOSER = new BlockDecomposer(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block SYNTHESIZER = new BlockSynthesizer(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block MICROSCOPE = new BlockMicroscope(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block REACTOR = new BlockReactor(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block REACTOR_CORE = new Block(FabricBlockSettings.of(Material.METAL));
    public static final Block REACTOR_COIL = new Block(FabricBlockSettings.of(Material.METAL));


    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("chemistry", "decomposer"), DECOMPOSER);
        Registry.register(Registry.ITEM, new Identifier("chemistry", "decomposer"), new BlockItem(DECOMPOSER, new Item.Settings().group(ItemGroups.CHEMISTRY_MACHINES)));

        Registry.register(Registry.BLOCK, new Identifier("chemistry", "synthesizer"), SYNTHESIZER);
        Registry.register(Registry.ITEM, new Identifier("chemistry", "synthesizer"), new BlockItem(SYNTHESIZER, new Item.Settings().group(ItemGroups.CHEMISTRY_MACHINES)));

        Registry.register(Registry.BLOCK, new Identifier("chemistry", "microscope"), MICROSCOPE);
        Registry.register(Registry.ITEM, new Identifier("chemistry", "microscope"), new BlockItem(MICROSCOPE, new Item.Settings().group(ItemGroups.CHEMISTRY_MACHINES)));

        Registry.register(Registry.BLOCK, new Identifier("chemistry", "reactor"), REACTOR);
        Registry.register(Registry.ITEM, new Identifier("chemistry", "reactor"), new BlockItem(REACTOR, new Item.Settings().group(ItemGroups.CHEMISTRY_MACHINES)));

        Registry.register(Registry.BLOCK, new Identifier("chemistry", "reactor_core"), REACTOR_CORE);
        Registry.register(Registry.ITEM, new Identifier("chemistry", "reactor_core"), new BlockItem(REACTOR_CORE, new Item.Settings().group(ItemGroups.CHEMISTRY_MACHINES)));

        Registry.register(Registry.BLOCK, new Identifier("chemistry", "reactor_coil"), REACTOR_COIL);
        Registry.register(Registry.ITEM, new Identifier("chemistry", "reactor_coil"), new BlockItem(REACTOR_COIL, new Item.Settings().group(ItemGroups.CHEMISTRY_MACHINES)));

    }
}
