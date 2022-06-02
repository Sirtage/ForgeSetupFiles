package net.sirtage.content.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DeposedBlock {
    public final int offsetX;
    public final int offsetY;
    public final int offsetZ;

    protected BlockState block=null;
    private Lazy<Block> nonInitBlock=null;

    public DeposedBlock(@Nonnull BlockState block, int offsetX, int offsetY, int offsetZ) {
        this.block=block;
        this.offsetX=offsetX;
        this.offsetY=offsetY;
        this.offsetZ=offsetZ;
    }
    public DeposedBlock(@Nonnull BlockState block, BlockPos pos) {
        this.block=block;
        this.offsetX=pos.getX();
        this.offsetY=pos.getY();
        this.offsetZ=pos.getZ();
    }
    public DeposedBlock(@Nonnull Lazy<Block> nonInitBlock, int offsetX, int offsetY, int offsetZ) {
        this.nonInitBlock=nonInitBlock;
        this.offsetX=offsetX;
        this.offsetY=offsetY;
        this.offsetZ=offsetZ;
    }
    public DeposedBlock(@Nonnull Lazy<Block> nonInitBlock, BlockPos pos) {
        this.nonInitBlock=nonInitBlock;
        this.offsetX=pos.getX();
        this.offsetY=pos.getY();
        this.offsetZ=pos.getZ();
    }

    public BlockPos getRelativePos(@Nonnull BlockPos relativity) {
        return new BlockPos(relativity.getX()+offsetX,
                relativity.getY()+offsetY,
                relativity.getZ()+offsetZ);
    }

    public BlockPos getRelativePosWithCustomOffset(@Nonnull BlockPos relativity, int offsetX, int offsetY, int offsetZ) {
        return new BlockPos(relativity.getX()+offsetX,
                relativity.getY()+offsetY,
                relativity.getZ()+offsetZ);
    }

    public BlockState getBlockState() {
        if (block!=null) {
            return block;
        } else {
            return nonInitBlock.get().getDefaultState();
        }
    }
}
