package net.kaloo234.tutorialmod.item;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.item.custom.ChiselItem;
import net.kaloo234.tutorialmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> BLUESTONE = ITEMS.register("bluestone",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BLUESTONE = ITEMS.register("raw_bluestone",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.tutorialmod.radish.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public  static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 800));
    public  static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> BLUESTONE_SWORD = ITEMS.register("bluestone_sword",
            () -> new SwordItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.BLUESTONE, 5.0f, -2.4f))));
    public static final DeferredItem<PickaxeItem> BLUESTONE_PICKAXE = ITEMS.register("bluestone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BLUESTONE, 1.4f, -2.8f))));
    public static final DeferredItem<ShovelItem> BLUESTONE_SHOVEL = ITEMS.register("bluestone_shovel",
            () -> new ShovelItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.BLUESTONE, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> BLUESTONE_AXE = ITEMS.register("bluestone_axe",
            () -> new AxeItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.BLUESTONE, 6.0f, -3.2f))));
    public static final DeferredItem<HoeItem> BLUESTONE_HOE = ITEMS.register("bluestone_hoe",
            () -> new HoeItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.BLUESTONE, 0.0f, -3.0f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
