package net.sirtage.content.multiblock;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

public interface IMultiBlock {
    void construct(World world, BlockPos blockPos);
    void add(Object obj);
}
