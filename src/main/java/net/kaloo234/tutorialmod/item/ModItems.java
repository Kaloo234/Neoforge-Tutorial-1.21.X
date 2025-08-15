package net.kaloo234.tutorialmod.item;

import net.kaloo234.tutorialmod.TutorialMod;
import net.kaloo234.tutorialmod.block.ModBlocks;
import net.kaloo234.tutorialmod.item.custom.*;
import net.kaloo234.tutorialmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
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
    public static final DeferredItem<Item> BLUESTONE_BOW = ITEMS.register("bluestone_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    public static final DeferredItem<HammerItem> BLUESTONE_HAMMER = ITEMS.register("bluestone_hammer",
            () -> new HammerItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BLUESTONE, 7.0f, -3.5f))));
    public static final DeferredItem<ExcavatorItem> BLUESTONE_EXCAVATOR = ITEMS.register("bluestone_excavator",
            () -> new ExcavatorItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.BLUESTONE, 7.0f, -3.5f))));

    public static final DeferredItem<ArmorItem> BLUESTONE_HELMET = ITEMS.register("bluestone_helmet",
            () -> new ModArmorItem(ModArmorMaterials.BLUESTONE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(22))));
    public static final DeferredItem<ArmorItem> BLUESTONE_CHEStPLATE = ITEMS.register("bluestone_chestplate",
            () -> new ArmorItem(ModArmorMaterials.BLUESTONE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(22))));
    public static final DeferredItem<ArmorItem> BLUESTONE_LEGGINGS = ITEMS.register("bluestone_leggings",
            () -> new ArmorItem(ModArmorMaterials.BLUESTONE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(22))));
    public static final DeferredItem<ArmorItem> BLUESTONE_BOOTS = ITEMS.register("bluestone_boots",
            () -> new ArmorItem(ModArmorMaterials.BLUESTONE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(22))));

    public static final DeferredItem<Item> BLUESTONE_HORSE_ARMOR = ITEMS.register("bluestone_horse_armor",
        () -> new AnimalArmorItem(ModArmorMaterials.BLUESTONE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                false, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> KALOO234_SMITHING_TEMPLATE = ITEMS.register("kaloo234_armor_trim_smithing_template",
        () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "kaloo234")));

    public static final DeferredItem<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).stacksTo(1)));

    public static final DeferredItem<Item> RADISH_SEEDS = ITEMS.register("radish_seeds",
            () -> new ItemNameBlockItem(ModBlocks.RADISH_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
