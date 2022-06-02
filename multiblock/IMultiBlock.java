package net.sirtage.content.multiblock;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;

public interface IMultiBlock {
    void construct(DeposedContext context);
    boolean scan(DeposedContext context);
    void add(Object obj);
}
