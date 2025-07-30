package net.kaloo234.tutorialmod.item;

import net.kaloo234.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> BLUESTONE = ITEMS.register("bluestone",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BLUESTONE = ITEMS.register("raw_bluestone",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
