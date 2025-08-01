package net.kaloo234.tutorialmod.datagen;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.block.ModBlocks;
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
                .add(ModBlocks.DEEPSLATE_BLUESTONE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLUESTONE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_BLUESTONE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.BLUESTONE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BLUESTONE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BLUESTONE_WALL.get());
    }
}
