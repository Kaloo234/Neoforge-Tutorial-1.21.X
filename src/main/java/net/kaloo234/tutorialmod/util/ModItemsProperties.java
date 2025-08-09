package net.kaloo234.tutorialmod.util;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.component.ModDataComponent;
import net.kaloo234.tutorialmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemsProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "used"),
                (stack, level, entity, seed) ->
                        stack.get(ModDataComponent.COORDINATES) != null ? 1f : 0f);
    }
}
