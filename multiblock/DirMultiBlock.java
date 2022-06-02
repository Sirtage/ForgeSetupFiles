package net.sirtage.content.multiblock;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class DirMultiBlock implements IMultiBlock{

    private final List<DirDeposedBlock> blocks;

    public DirMultiBlock(List<DirDeposedBlock> blocks) {
        this.blocks = blocks;
    }

    @Override
    public void construct(DeposedContext context) {
        for(DirDeposedBlock block: blocks) {
            context.getWorld().setBlockState(block.getRelativePos(context.getStartPos(), context.getDirection()), block.getBlockState());
        }
    }

    @Override
    public boolean scan(DeposedContext context) {
        World world = context.getWorld();
        BlockPos startPos = context.getStartPos();
        for(DirDeposedBlock depblock: blocks) {
            if (world.getBlockState(depblock.getRelativePos(startPos, context.getDirection()))!=depblock.getBlockState()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(Object obj) {
        blocks.add((DirDeposedBlock) obj);
    }
}
