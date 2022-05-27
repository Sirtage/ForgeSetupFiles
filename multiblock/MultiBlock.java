package net.sirtage.content.multiblock;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sirtage.WeatherCrystals;

import java.util.List;

public class MultiBlock implements IMultiBlock{

    private final List<DeposedBlock> blocks;

    public MultiBlock(List<DeposedBlock> blocks) {
        this.blocks=blocks;
    }
    public boolean scan(World world, BlockPos startPos) {
        for(DeposedBlock depblock: blocks) {
            if (world.getBlockState(depblock.getRelativePos(startPos))!=depblock.getBlockState()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void construct(World world, BlockPos blockPos) {
        for(DeposedBlock block: blocks) {
            world.setBlockState(block.getRelativePos(blockPos), block.getBlockState());
        }
    }

    @Override
    public void add(Object obj) {
        blocks.add((DeposedBlock) obj);
    }
}
