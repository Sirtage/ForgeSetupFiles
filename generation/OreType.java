package net.sirtage.content.generations;

import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;
import net.sirtage.reg.Register;

public enum OreType {

    CHUNKIUM(Lazy.of(Register.content.CHUNKIUM_ORE), 3, 3, 40);

    private final Lazy<Block> block;
    private final int maxVein;
    private final int minH;
    private final int maxH;

    OreType(Lazy<Block> block, int maxVein, int minH, int maxH) {
        this.block = block;
        this.maxVein = maxVein;
        this.minH = minH;
        this.maxH = maxH;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVein() {
        return maxVein;
    }

    public int getMinH() {
        return minH;
    }

    public int getMaxH() {
        return maxH;
    }

    public static OreType get(Block block) {
        for (OreType ore: OreType.values()) {
            if (block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}
