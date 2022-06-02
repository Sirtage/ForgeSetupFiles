package net.sirtage.content.multiblock;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class MultiBlock implements IMultiBlock {

    private final List<DeposedBlock> blocks;

    public MultiBlock(List<DeposedBlock> blocks) {
        this.blocks=blocks;
    }

    @Override
    public boolean scan(DeposedContext context) {
        World world = context.getWorld();
        BlockPos startPos = context.getStartPos();
        for(DeposedBlock depblock: blocks) {
            if (world.getBlockState(depblock.getRelativePos(startPos))!=depblock.getBlockState()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void construct(DeposedContext context) {
        for(DeposedBlock block: blocks) {
            context.getWorld().setBlockState(block.getRelativePos(context.getStartPos()), block.getBlockState());
        }
    }

    @Override
    public void add(Object obj) {
        blocks.add((DeposedBlock) obj);
    }
}
