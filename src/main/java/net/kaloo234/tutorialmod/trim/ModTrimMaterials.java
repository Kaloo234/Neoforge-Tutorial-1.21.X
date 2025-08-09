package net.kaloo234.tutorialmod.trim;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.Map;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> BLUESTONE =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bluestone"));

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, BLUESTONE, ModItems.BLUESTONE.get(), Style.EMPTY.withColor(TextColor.parseColor("#2679ad").getOrThrow()), 0.9F);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item,
                                 Style style, float itemModelIndex) {
        TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimmaterial);
    }
}
