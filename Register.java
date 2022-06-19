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

import net.sirtage.content.Tabs;
import net.sirtage.content.blocks.*;
import net.sirtage.content.blocks.machine.Casing;
import net.sirtage.content.blocks.machine.Smeltery;
import net.sirtage.content.items.*;
import net.sirtage.content.multiblock.DirMultiBlock;
import ru.sirtage.tiles.ContClassBuilder;

import java.util.function.Supplier;

public class Register {
    public static class content {

        public static final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, SomeTest.MOD_ID);
        public static final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, SomeTest.MOD_ID);



        //Items
        public static final RegistryObject<Item> IDFK = items.register("idfk", idfk::new);
        public static final RegistryObject<Item> HNW = items.register("helnewcon", HelloNewContent::new);
        public static final RegistryObject<Item> SHIT_REMOVER = items.register("shit_remover", ShitRemover::new);
        public static final RegistryObject<Item> PERSISTENT_SHIT = items.register("persistent_shit", PersistenShit::new);
        public static final RegistryObject<Item> ULTRA_RANDOM = items.register("ultra_random", UltraRandom::new);
        public static final RegistryObject<Item> VOID_STONE_SEEDS = items.register("void_stone_seeds", VoidStonSeed::new);
        public static final RegistryObject<Item> ENDER_CORE = items.register("ender_core", EnderCore::new);

        //Tools
        public static final RegistryObject<ToolItem> SWAND = items.register("sstaff", sstaff::new);

        //Blocks
        public static final RegistryObject<Block> BSHIT = Register.registryBlock("blackshit", BlackShit::new);
        public static final RegistryObject<Block> TESTBLOCK = Register.registryBlock("testblock", TestBlock::new);
        public static final RegistryObject<Block> TEST_STAIRS = Register.registryBlock("test_stairs", TestStairs::new);
        public static final RegistryObject<Block> CORRUPTION = Register.registryBlock("corruption", Corruption::new);

        public static final RegistryObject<Block> CHUNKIUM_ORE = Register.registryBlock("chunkium_ore", ChunkiumOre::new);
        public static final RegistryObject<Item> CHUNKIUM_INGOT = items.register("chunkium_ingot", ChunkiumIngot::new);

        public static final RegistryObject<Block> VOID_STONE_CROP = blocks.register("void_stone_crop", VoidStoneCrop::new);

        public static final RegistryObject<Item> SCREWDRIVER = items.register("screwdriver", Screwdriver::new);

        //Tags
        public static final Tags.IOptionalNamedTag<Block> IS_SHIT = Register.registerBlockTag(SomeTest.MOD_ID, "is_shit");
        public static final Tags.IOptionalNamedTag<Block> CHUNKIUM_GEN = Register.registerBlockTag(SomeTest.MOD_ID, "chunkium_gen");

        public static final RegistryObject<Block> SIMPLE_CASING = Register.registryBlock("simple_casing", Casing.Simple::new);


        public static final RegistryObject<Block> SMELTERY_BLOCK = Register.registryBlock("smeltery_block",
                () -> new Smeltery(AbstractBlock.Properties.from(Register.content.SIMPLE_CASING.get())));
        public static final DirMultiBlock SMELTERY_MULTIBLOCK = new Smeltery.Structure();
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
                })));*/
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
