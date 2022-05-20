package net.sirtage.reg;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sirtage.SomeTest;

import net.sirtage.content.Tabs;

import java.util.function.Supplier;

public class Register {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SomeTest.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SomeTest.MOD_ID);

    public static void __init__() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registryBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(Tabs.SirMainTab)));
    }

    public static Tags.IOptionalNamedTag<Item> registerItemTag(String namespace, String tagName) {
        return ItemTags.createOptional(new ResourceLocation(namespace, tagName));
    }

    public static Tags.IOptionalNamedTag<Block> registerBlockTag(String namespace, String tagName) {
        return BlockTags.createOptional(new ResourceLocation(namespace, tagName));
    }
}
