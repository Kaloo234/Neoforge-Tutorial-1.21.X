package net.kaloo234.tutorialmod.datagen;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.block.ModBlocks;
import net.kaloo234.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BLUESTONE_SMELTABLES = List.of(ModItems.RAW_BLUESTONE.get(),
                ModBlocks.BLUESTONE_ORE.get(), ModBlocks.DEEPSLATE_BLUESTONE_ORE.get());

//############################
//          SMELTING
//############################

        oreSmelting(recipeOutput, BLUESTONE_SMELTABLES, RecipeCategory.MISC, ModItems.BLUESTONE.get(),
                0.25f, 200, "bluestone");
        oreBlasting(recipeOutput, BLUESTONE_SMELTABLES, RecipeCategory.MISC, ModItems.BLUESTONE.get(),
                0.25f, 100, "bluestone");

//############################
//          BLOCKS
//############################

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUESTONE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLUESTONE.get())
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);

        stairBuilder(ModBlocks.BLUESTONE_STAIRS.get(), Ingredient.of(ModItems.BLUESTONE)).group("bluestone")
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUESTONE_SLAB.get(), ModItems.BLUESTONE.get());

        buttonBuilder(ModBlocks.BLUESTONE_BUTTON.get(), Ingredient.of(ModItems.BLUESTONE.get())).group("BLUESTONE")
                .unlockedBy("has_BLUESTONE", has(ModItems.BLUESTONE.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.BLUESTONE_PRESSURE_PLATE.get(), ModItems.BLUESTONE.get());

        fenceBuilder(ModBlocks.BLUESTONE_FENCE.get(), Ingredient.of(ModItems.BLUESTONE.get())).group("BLUESTONE")
                .unlockedBy("has_BLUESTONE", has(ModItems.BLUESTONE.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.BLUESTONE_FENCE_GATE.get(), Ingredient.of(ModItems.BLUESTONE.get())).group("BLUESTONE")
                .unlockedBy("has_BLUESTONE", has(ModItems.BLUESTONE.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUESTONE_WALL.get(), ModItems.BLUESTONE.get());

        doorBuilder(ModBlocks.BLUESTONE_DOOR.get(), Ingredient.of(ModItems.BLUESTONE.get())).group("BLUESTONE")
                .unlockedBy("has_BLUESTONE", has(ModItems.BLUESTONE.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.BLUESTONE_TRAPDOOR.get(), Ingredient.of(ModItems.BLUESTONE.get())).group("BLUESTONE")
                .unlockedBy("has_BLUESTONE", has(ModItems.BLUESTONE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUESTONE_LAMP.get())
                .pattern("BBB")
                .pattern("BLB")
                .pattern("BBB")
                .define('B', ModItems.BLUESTONE.get())
                .define('L', Blocks.REDSTONE_LAMP)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("BBB")
                .pattern("BCB")
                .pattern("BBB")
                .define('B', ModBlocks.BLUESTONE_BLOCK.get())
                .define('C', ModItems.CHISEL.get())
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);

//############################
//          ITEMS
//############################

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLUESTONE.get(), 9)
                .requires(ModBlocks.BLUESTONE_BLOCK.get())
                .unlockedBy("has_bluestone_block", has(ModBlocks.BLUESTONE_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern("  B")
                .pattern(" B ")
                .pattern("S  ")
                .define('B', ModItems.BLUESTONE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUESTONE_SWORD.get())
                .pattern("B")
                .pattern("B")
                .pattern("S")
                .define('B', ModItems.BLUESTONE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUESTONE_PICKAXE.get())
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .define('B', ModItems.BLUESTONE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUESTONE_SHOVEL.get())
                .pattern("B")
                .pattern("S")
                .pattern("S")
                .define('B', ModItems.BLUESTONE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUESTONE_AXE.get())
                .pattern("BB")
                .pattern("SB")
                .pattern("S ")
                .define('B', ModItems.BLUESTONE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUESTONE_HOE.get())
                .pattern("BB")
                .pattern("S ")
                .pattern("S ")
                .define('B', ModItems.BLUESTONE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUESTONE_HAMMER.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern(" S ")
                .define('B', ModBlocks.BLUESTONE_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUESTONE_EXCAVATOR.get())
                .pattern(" BB")
                .pattern(" BB")
                .pattern("S  ")
                .define('B', ModBlocks.BLUESTONE_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);

//############################
//          TRIMS
//############################

        trimSmithing(recipeOutput, ModItems.KALOO234_SMITHING_TEMPLATE.get(),
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "kaloo234"));
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
