package net.sirtage.content.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DirDeposedBlock{

    public final int vertical;
    public final int front;
    public final int side;

    protected BlockState block=null;
    private Lazy<Block> nonInitBlock=null;

    public DirDeposedBlock(@Nonnull BlockState block, int front, int vertical, int side) {
        this.block=block;
        this.front=front;
        this.vertical=vertical;
        this.side=side;
    }

    public DirDeposedBlock(@Nonnull Lazy<Block> nonInitBlock, int front, int vertical, int side) {
        this.nonInitBlock=nonInitBlock;
        this.front=front;
        this.vertical=vertical;
        this.side=side;
    }


    /**
     * if block right of position, then side+, if left - side-
     *
     */

    @Nullable
    public BlockPos getRelativePos(@Nonnull BlockPos relativity, Direction direction) {

        BlockPos blockPos = null;

        switch (direction) {
            case NORTH:
                blockPos = new BlockPos(
                        relativity.getX()+side,
                        relativity.getY()+vertical,
                        relativity.getZ()-front
                );
                break;
            case SOUTH:
                blockPos = new BlockPos(
                        relativity.getX()-side,
                        relativity.getY()+vertical,
                        relativity.getZ()+front
                );
                break;
            case EAST:
                blockPos = new BlockPos(
                        relativity.getX()+front,
                        relativity.getY()+vertical,
                        relativity.getZ()+side
                );
                break;
            case WEST:
                blockPos = new BlockPos(
                        relativity.getX()-front,
                        relativity.getY()+vertical,
                        relativity.getZ()-side
                );
                break;
        }

        return blockPos;
    }

    public BlockState getBlockState() {
        if (block!=null) {
            return block;
        } else {
            return nonInitBlock.get().getDefaultState();
        }
    }
}
