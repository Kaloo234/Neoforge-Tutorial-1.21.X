package net.kaloo234.tutorialmod.datagen;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.block.ModBlocks;
import net.kaloo234.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLUESTONE_BLOCK.get())
                .add(ModBlocks.BLUESTONE_ORE.get())
                .add(ModBlocks.BLUESTONE_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.BLUESTONE_LAMP.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.BLOODWOOD_PLANKS.get())
                .add(ModBlocks.BLOODWOOD_STAIRS.get())
                .add(ModBlocks.BLOODWOOD_SLAB.get())
                .add(ModBlocks.BLOODWOOD_BUTTON.get())
                .add(ModBlocks.BLOODWOOD_PRESSURE_PLATE.get())
                .add(ModBlocks.BLOODWOOD_FENCE.get())
                .add(ModBlocks.BLOODWOOD_FENCE_GATE.get())
                .add(ModBlocks.BLOODWOOD_DOOR.get())
                .add(ModBlocks.BLOODWOOD_TRAPDOOR.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLUESTONE_ORE.get())
                .add(ModBlocks.BLUESTONE_LAMP.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BLUESTONE_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.BLUESTONE_FENCE.get());
        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.BLOODWOOD_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.BLUESTONE_FENCE_GATE.get())
                .add(ModBlocks.BLOODWOOD_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.BLUESTONE_WALL.get());

        tag(ModTags.Blocks.NEEDS_BLUESTONE_TOOL)
                .add(ModBlocks.BLUESTONE_LAMP.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BLUESTONE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BLUESTONE_TOOL);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLOODWOOD_LOG.get())
                .add(ModBlocks.BLOODWOOD_WOOD.get())
                .add(ModBlocks.STRIPPED_BLOODWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get());
    }
}
