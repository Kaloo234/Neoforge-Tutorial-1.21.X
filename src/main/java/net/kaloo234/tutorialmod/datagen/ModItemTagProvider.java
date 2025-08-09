package net.kaloo234.tutorialmod.datagen;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.item.ModItems;
import net.kaloo234.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BLUESTONE.get())
                .add(ModItems.RAW_BLUESTONE.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.SWORDS)
                .add(ModItems.BLUESTONE_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.BLUESTONE_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.BLUESTONE_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.BLUESTONE_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.BLUESTONE_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BLUESTONE_HELMET.get())
                .add(ModItems.BLUESTONE_CHEStPLATE.get())
                .add(ModItems.BLUESTONE_LEGGINGS.get())
                .add(ModItems.BLUESTONE_BOOTS.get());
    }
}
