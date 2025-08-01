package net.kaloo234.tutorialmod.datagen;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLUESTONE_BLOCK);

        blockWithItem(ModBlocks.BLUESTONE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_BLUESTONE_ORE);

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
