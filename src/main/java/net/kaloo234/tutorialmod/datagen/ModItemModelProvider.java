package net.kaloo234.tutorialmod.datagen;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.block.ModBlocks;
import net.kaloo234.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BLUESTONE.get());
        basicItem(ModItems.RAW_BLUESTONE.get());
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.CHISEL.get());

        buttonItem(ModBlocks.BLUESTONE_BUTTON, ModBlocks.BLUESTONE_BLOCK);
        fenceItem(ModBlocks.BLUESTONE_FENCE, ModBlocks.BLUESTONE_BLOCK);
        wallItem(ModBlocks.BLUESTONE_WALL, ModBlocks.BLUESTONE_BLOCK);

        basicItem(ModBlocks.BLUESTONE_DOOR.asItem());

        handheldItem(ModItems.BLUESTONE_SWORD.get());
        handheldItem(ModItems.BLUESTONE_PICKAXE.get());
        handheldItem(ModItems.BLUESTONE_SHOVEL.get());
        handheldItem(ModItems.BLUESTONE_AXE.get());
        handheldItem(ModItems.BLUESTONE_HOE.get());

        handheldItem(ModItems.BLUESTONE_HAMMER.get());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
