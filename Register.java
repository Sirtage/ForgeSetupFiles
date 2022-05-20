package net.sirtage.reg;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sirtage.SomeTest;

import net.sirtage.content.Tabs;
import net.sirtage.content.blocks.BlackShit;
import net.sirtage.content.blocks.TestBlock;
import net.sirtage.content.items.HelloNewContent;
import net.sirtage.content.items.idfk;
import net.sirtage.content.items.sstaff;

import java.util.function.Supplier;

public class Register {

    public static final class Content {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SomeTest.MOD_ID);
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SomeTest.MOD_ID);




        /*  
        
            Items:
                public static final RegistryObject<Item> ITEM = Content.ITEMS.register(item_id, item_class::new);

            Blocks:
                public static final RegistryObject<Block> BLOCK = registryBlock({block_id}, block_class::new);\
                
                
        */     
    }



    public static void __init__() {
        Content.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Content.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Content.BLOCKS.register(name, block);
        registryBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registryBlockItem(String name, RegistryObject<T> block) {
        Content.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(Tabs.SirMainTab)));
    }

}
