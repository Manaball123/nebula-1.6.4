package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerDeepOcean extends GenLayer
{
    private static final String __OBFID = "CL_00000546";

    public GenLayerDeepOcean(long p_i45472_1_, GenLayer p_i45472_3_)
    {
        super(p_i45472_1_);
        this.parent = p_i45472_3_;
    }

    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int var5 = par1 - 1;
        int var6 = par2 - 1;
        int var7 = par3 + 2;
        int var8 = par4 + 2;
        int[] var9 = this.parent.getInts(var5, var6, var7, var8);
        int[] var10 = IntCache.getIntCache(par3 * par4);

        for (int var11 = 0; var11 < par4; ++var11)
        {
            for (int var12 = 0; var12 < par3; ++var12)
            {
                int var13 = var9[var12 + 1 + (var11 + 1 - 1) * (par3 + 2)];
                int var14 = var9[var12 + 1 + 1 + (var11 + 1) * (par3 + 2)];
                int var15 = var9[var12 + 1 - 1 + (var11 + 1) * (par3 + 2)];
                int var16 = var9[var12 + 1 + (var11 + 1 + 1) * (par3 + 2)];
                int var17 = var9[var12 + 1 + (var11 + 1) * var7];
                int var18 = 0;

                if (var13 == 0)
                {
                    ++var18;
                }

                if (var14 == 0)
                {
                    ++var18;
                }

                if (var15 == 0)
                {
                    ++var18;
                }

                if (var16 == 0)
                {
                    ++var18;
                }

                if (var17 == 0 && var18 > 3)
                {
                    var10[var12 + var11 * par3] = BiomeGenBase.field_150575_M.biomeID;
                }
                else
                {
                    var10[var12 + var11 * par3] = var17;
                }
            }
        }

        return var10;
    }
}
