package net.kaloo234.tutorialmod.item;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BLUESTONE_ITEMS_TAB =
            CREATIVE_MODE_TAB.register("bluestone_items_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.BLUESTONE.get()))
                            .title(Component.translatable("creativetab.tutorialmod.bluestone_items"))
                            .displayItems((parameters, output) -> {
                                output.accept(ModItems.BLUESTONE);
                                output.accept(ModItems.RAW_BLUESTONE);

                                output.accept(ModItems.CHISEL);

                                output.accept(ModItems.RADISH);

                                output.accept(ModItems.FROSTFIRE_ICE);
                                output.accept(ModItems.STARLIGHT_ASHES);

                                output.accept(ModItems.BLUESTONE_SWORD);
                                output.accept(ModItems.BLUESTONE_PICKAXE);
                                output.accept(ModItems.BLUESTONE_SHOVEL);
                                output.accept(ModItems.BLUESTONE_AXE);
                                output.accept(ModItems.BLUESTONE_HOE);

                                output.accept(ModItems.BLUESTONE_HAMMER);
                            }).build());

    public static final Supplier<CreativeModeTab> BLUESTONE_BLOCKS_TAB =
            CREATIVE_MODE_TAB.register("bluestone_blocks_tab",
                    () -> CreativeModeTab.builder()
                            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
                                    "bluestone_items_tab"))
                            .icon(() -> new ItemStack(ModBlocks.BLUESTONE_BLOCK.get()))
                            .title(Component.translatable("creativetab.tutorialmod.bluestone_blocks"))
                            .displayItems((parameters, output) -> {
                                output.accept(ModBlocks.BLUESTONE_BLOCK);
                                output.accept(ModBlocks.BLUESTONE_ORE);
                                output.accept(ModBlocks.DEEPSLATE_BLUESTONE_ORE);

                                output.accept(ModBlocks.MAGIC_BLOCK);

                                output.accept(ModBlocks.BLUESTONE_STAIRS);
                                output.accept(ModBlocks.BLUESTONE_SLAB);
                                output.accept(ModBlocks.BLUESTONE_PRESSURE_PLATE);
                                output.accept(ModBlocks.BLUESTONE_BUTTON);
                                output.accept(ModBlocks.BLUESTONE_FENCE);
                                output.accept(ModBlocks.BLUESTONE_FENCE_GATE);
                                output.accept(ModBlocks.BLUESTONE_WALL);
                                output.accept(ModBlocks.BLUESTONE_DOOR);
                                output.accept(ModBlocks.BLUESTONE_TRAPDOOR);

                                output.accept(ModBlocks.BLUESTONE_LAMP);
                            }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
