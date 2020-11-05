package com.chemistry.blockentities;

import com.chemistry.blocks.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;


public class BlockEntities {

    public static BlockEntityType<BlockEntityDecomposer> BLOCK_ENTITY_DECOMPOSER;
    public static BlockEntityType<BlockEntitySynthesizer> BLOCK_ENTITY_SYNTHESIZER;
    public static BlockEntityType<BlockEntityMicroscope> BLOCK_ENTITY_MICROSCOPE;

    public static void registerBlockEntities(){
        BLOCK_ENTITY_DECOMPOSER = Registry.register(Registry.BLOCK_ENTITY_TYPE, "chemistry:blockentitydecomposer", BlockEntityType.Builder.create(BlockEntityDecomposer::new, Blocks.DECOMPOSER).build(null));
        BLOCK_ENTITY_SYNTHESIZER = Registry.register(Registry.BLOCK_ENTITY_TYPE, "chemistry:blockentitysynthesizer", BlockEntityType.Builder.create(BlockEntitySynthesizer::new, Blocks.SYNTHESIZER).build(null));
        BLOCK_ENTITY_MICROSCOPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, "chemistry:blockentitymicroscope", BlockEntityType.Builder.create(BlockEntityMicroscope::new, Blocks.MICROSCOPE).build(null));
    }

}
