package net.sirtage.reg;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sirtage.SomeTest;

import java.util.function.Supplier;

public class Register {
    public static class content {

        public static final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, SomeTest.MOD_ID);
        public static final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, SomeTest.MOD_ID);
        
    }

    public static class nonPhysical {
        public static final DeferredRegister<TileEntityType<?>> tileEntities = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SomeTest.MOD_ID);
        public static DeferredRegister<ContainerType<?>> containers = DeferredRegister.create(ForgeRegistries.CONTAINERS, SomeTest.MOD_ID);

        /*public static RegistryObject<TileEntityType<!type!>> !name! =
                tileEntities.register("<id>", () -> TileEntityType.Builder.create(
                        <Te class>::new, <Block>).build(null));
         */

        /*public static final RegistryObject<ContainerType<!type!>> !name!
                = containers.register("<id>",
                () -> IForgeContainerType.create(((windowId, inv, data) -> {
                    BlockPos pos = data.readBlockPos();
                    World world = inv.player.getEntityWorld();
                    return new !type!(windowId, world, pos, inv, inv.player);
                })));
         */
    }


    public static void __init__() {
        content.items.register(FMLJavaModLoadingContext.get().getModEventBus());
        content.blocks.register(FMLJavaModLoadingContext.get().getModEventBus());
        nonPhysical.tileEntities.register(FMLJavaModLoadingContext.get().getModEventBus());
        nonPhysical.containers.register(FMLJavaModLoadingContext.get().getModEventBus());
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
