package net.sirtage.content.multiblock;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DeposedContext {

    //stable
    private World world;
    private BlockPos startPos;

    //can be null
    private Direction direction = null;

    public static DeposedContext create(World world, BlockPos startPos) {
        DeposedContext context = new DeposedContext();
        context.world=world;
        context.startPos=startPos;
        return context;
    }

    public DeposedContext direction(Direction direction) {
        this.direction=direction;
        return this;
    }

    public World getWorld() {
        return world;
    }

    public BlockPos getStartPos() {
        return startPos;
    }

    public Direction getDirection() {
        return direction;
    }
}
