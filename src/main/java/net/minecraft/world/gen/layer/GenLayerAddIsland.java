package net.minecraft.world.gen.layer;

public class GenLayerAddIsland extends GenLayer
{
    private static final String __OBFID = "CL_00000551";

    public GenLayerAddIsland(long par1, GenLayer par3GenLayer)
    {
        super(par1);
        this.parent = par3GenLayer;
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
                int var13 = var9[var12 + 0 + (var11 + 0) * var7];
                int var14 = var9[var12 + 2 + (var11 + 0) * var7];
                int var15 = var9[var12 + 0 + (var11 + 2) * var7];
                int var16 = var9[var12 + 2 + (var11 + 2) * var7];
                int var17 = var9[var12 + 1 + (var11 + 1) * var7];
                this.initChunkSeed((long)(var12 + par1), (long)(var11 + par2));

                if (var17 == 0 && (var13 != 0 || var14 != 0 || var15 != 0 || var16 != 0))
                {
                    int var18 = 1;
                    int var19 = 1;

                    if (var13 != 0 && this.nextInt(var18++) == 0)
                    {
                        var19 = var13;
                    }

                    if (var14 != 0 && this.nextInt(var18++) == 0)
                    {
                        var19 = var14;
                    }

                    if (var15 != 0 && this.nextInt(var18++) == 0)
                    {
                        var19 = var15;
                    }

                    if (var16 != 0 && this.nextInt(var18++) == 0)
                    {
                        var19 = var16;
                    }

                    if (this.nextInt(3) == 0)
                    {
                        var10[var12 + var11 * par3] = var19;
                    }
                    else if (var19 == 4)
                    {
                        var10[var12 + var11 * par3] = 4;
                    }
                    else
                    {
                        var10[var12 + var11 * par3] = 0;
                    }
                }
                else if (var17 > 0 && (var13 == 0 || var14 == 0 || var15 == 0 || var16 == 0))
                {
                    if (this.nextInt(5) == 0)
                    {
                        if (var17 == 4)
                        {
                            var10[var12 + var11 * par3] = 4;
                        }
                        else
                        {
                            var10[var12 + var11 * par3] = 0;
                        }
                    }
                    else
                    {
                        var10[var12 + var11 * par3] = var17;
                    }
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
