package net.kaloo234.tutorialmod.datagen;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.block.ModBlocks;
import net.kaloo234.tutorialmod.block.custom.BluestoneLampBlock;
import net.kaloo234.tutorialmod.block.custom.GojiBerryBushBlock;
import net.kaloo234.tutorialmod.block.custom.RadishCropBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLUESTONE_BLOCK);

        blockWithItem(ModBlocks.BLUESTONE_ORE);
        blockWithItem(ModBlocks.BLUESTONE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.BLUESTONE_END_ORE);
        blockWithItem(ModBlocks.BLUESTONE_NETHER_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(ModBlocks.BLUESTONE_STAIRS.get(), blockTexture(ModBlocks.BLUESTONE_BLOCK.get()));
        slabBlock(ModBlocks.BLUESTONE_SLAB.get(), blockTexture(ModBlocks.BLUESTONE_BLOCK.get()),
                blockTexture(ModBlocks.BLUESTONE_BLOCK.get()));

        buttonBlock(ModBlocks.BLUESTONE_BUTTON.get(), blockTexture(ModBlocks.BLUESTONE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.BLUESTONE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BLUESTONE_BLOCK.get()));

        fenceBlock(ModBlocks.BLUESTONE_FENCE.get(), blockTexture(ModBlocks.BLUESTONE_BLOCK.get()));
        fenceGateBlock(ModBlocks.BLUESTONE_FENCE_GATE.get(), blockTexture(ModBlocks.BLUESTONE_BLOCK.get()));
        wallBlock(ModBlocks.BLUESTONE_WALL.get(), blockTexture(ModBlocks.BLUESTONE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.BLUESTONE_DOOR.get(), modLoc("block/bluestone_door_bottom"),
                modLoc("block/bluestone_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BLUESTONE_TRAPDOOR.get(), modLoc("block/bluestone_trapdoor"),
                true, "cutout");

        blockItem(ModBlocks.BLUESTONE_STAIRS);
        blockItem(ModBlocks.BLUESTONE_SLAB);
        blockItem(ModBlocks.BLUESTONE_PRESSURE_PLATE);
        blockItem(ModBlocks.BLUESTONE_FENCE_GATE);
        blockItem(ModBlocks.BLUESTONE_TRAPDOOR, "_bottom");

        blockWithItem(ModBlocks.BLOODWOOD_PLANKS);

        stairsBlock(ModBlocks.BLOODWOOD_STAIRS.get(), blockTexture(ModBlocks.BLOODWOOD_PLANKS.get()));
        slabBlock(ModBlocks.BLOODWOOD_SLAB.get(), blockTexture(ModBlocks.BLOODWOOD_PLANKS.get()),
                blockTexture(ModBlocks.BLOODWOOD_PLANKS.get()));

        buttonBlock(ModBlocks.BLOODWOOD_BUTTON.get(), blockTexture(ModBlocks.BLOODWOOD_PLANKS.get()));
        pressurePlateBlock(ModBlocks.BLOODWOOD_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BLOODWOOD_PLANKS.get()));

        fenceBlock(ModBlocks.BLOODWOOD_FENCE.get(), blockTexture(ModBlocks.BLOODWOOD_PLANKS.get()));
        fenceGateBlock(ModBlocks.BLOODWOOD_FENCE_GATE.get(), blockTexture(ModBlocks.BLOODWOOD_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.BLOODWOOD_DOOR.get(), modLoc("block/bloodwood_door_bottom"),
                modLoc("block/bloodwood_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BLOODWOOD_TRAPDOOR.get(), modLoc("block/bloodwood_trapdoor"),
                true, "cutout");

        blockItem(ModBlocks.BLOODWOOD_STAIRS);
        blockItem(ModBlocks.BLOODWOOD_SLAB);
        blockItem(ModBlocks.BLOODWOOD_PRESSURE_PLATE);
        blockItem(ModBlocks.BLOODWOOD_FENCE_GATE);
        blockItem(ModBlocks.BLOODWOOD_TRAPDOOR, "_bottom");

        logBlock(((RotatedPillarBlock) ModBlocks.BLOODWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.BLOODWOOD_WOOD.get()),
                blockTexture(ModBlocks.BLOODWOOD_LOG.get()), blockTexture(ModBlocks.BLOODWOOD_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLOODWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLOODWOOD_WOOD.get()),
                blockTexture(ModBlocks.STRIPPED_BLOODWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_BLOODWOOD_LOG.get()));

        blockItem(ModBlocks.BLOODWOOD_LOG);
        blockItem(ModBlocks.BLOODWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_BLOODWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_BLOODWOOD_WOOD);

        leavesBlock(ModBlocks.BLOODWOOD_LEAVES);
        saplingBlock(ModBlocks.BLOODWOOD_SAPLING);

        customLamp();

        makeCrop(((CropBlock) ModBlocks.RADISH_CROP.get()),
                "radish_crop_stage", "radish_crop_stage");
        makeBush(((SweetBerryBushBlock) ModBlocks.GOJI_BERRY_BUSH.get()),
                "goji_berry_bush_stage", "goji_berry_bush_stage");
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(GojiBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(GojiBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((RadishCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(((RadishCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.BLUESTONE_LAMP.get()).forAllStates(state -> {
            if(state.getValue(BluestoneLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("bluestone_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "bluestone_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("bluestone_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "bluestone_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.BLUESTONE_LAMP.get(), models().cubeAll("bluestone_lamp_on",
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "bluestone_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
