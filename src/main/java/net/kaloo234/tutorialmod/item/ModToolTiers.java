package net.kaloo234.tutorialmod.item;

import net.kaloo234.tutorialmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier BLUESTONE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_BLUESTONE_TOOL,
            1400, 4, 3f, 28, () -> Ingredient.of(ModItems.BLUESTONE));
}
