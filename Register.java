package net.sirtage.reg;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
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
import net.sirtage.content.blocks.BlackShit;
import net.sirtage.content.blocks.TestBlock;
import net.sirtage.content.items.HelloNewContent;
import net.sirtage.content.items.ShitRemover;
import net.sirtage.content.items.idfk;
import net.sirtage.content.items.sstaff;

import java.util.function.Supplier;

public class Register {
    public static class content {

        public static final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, SomeTest.MOD_ID);
        public static final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, SomeTest.MOD_ID);

        //Items
        public static final RegistryObject<Item> IDFK = items.register("idfk", idfk::new);
        public static final RegistryObject<Item> HNW = items.register("helnewcon", HelloNewContent::new);
        public static final RegistryObject<Item> SHIT_REMOVER = items.register("shit_remover", ShitRemover::new);

        //Tools
        public static final RegistryObject<ToolItem> SWAND = items.register("sstaff", sstaff::new);

        //Blocks
        public static final RegistryObject<Block> BSHIT = Register.registryBlock("blackshit", BlackShit::new);
        public static final RegistryObject<Block> TESTBLOCK = Register.registryBlock("testblock", TestBlock::new);

        //Tags
        public static final Tags.IOptionalNamedTag<Block> IS_SHIT = Register.registerBlockTag(SomeTest.MOD_ID, "is_shit");
    }


    public static void __init__() {
        content.items.register(FMLJavaModLoadingContext.get().getModEventBus());
        content.blocks.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = content.blocks.register(name, block);
        registryBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registryBlockItem(String name, RegistryObject<T> block) {
        content.items.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(Tabs.SirMainTab)));
    }

    public static Tags.IOptionalNamedTag<Item> registerItemTag(String namespace, String tagName) {
        return ItemTags.createOptional(new ResourceLocation(namespace, tagName));
    }

    public static Tags.IOptionalNamedTag<Block> registerBlockTag(String namespace, String tagName) {
        return BlockTags.createOptional(new ResourceLocation(namespace, tagName));
    }
}
