package net.kaloo234.tutorialmod.datagen;

import net.kaloo234.tutorialmod.block.ModBlocks;
import net.kaloo234.tutorialmod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLUESTONE_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());

        add(ModBlocks.BLUESTONE_ORE.get(),
                block -> createOreDrop(ModBlocks.BLUESTONE_BLOCK.get(), ModItems.RAW_BLUESTONE.get()));
        add(ModBlocks.DEEPSLATE_BLUESTONE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_BLUESTONE_ORE.get(),
                        ModItems.RAW_BLUESTONE.get(), 1, 3));

        dropSelf(ModBlocks.BLUESTONE_STAIRS.get());
        add(ModBlocks.BLUESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLUESTONE_SLAB.get()));
        dropSelf(ModBlocks.BLUESTONE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.BLUESTONE_BUTTON.get());
        dropSelf(ModBlocks.BLUESTONE_FENCE.get());
        dropSelf(ModBlocks.BLUESTONE_FENCE_GATE.get());
        dropSelf(ModBlocks.BLUESTONE_WALL.get());
        add(ModBlocks.BLUESTONE_DOOR.get(),
                block -> createDoorTable(ModBlocks.BLUESTONE_DOOR.get()));
        dropSelf(ModBlocks.BLUESTONE_TRAPDOOR.get());

        dropSelf(ModBlocks.BLUESTONE_LAMP.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
