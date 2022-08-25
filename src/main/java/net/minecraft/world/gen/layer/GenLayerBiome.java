package net.minecraft.world.gen.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerBiome extends GenLayer
{
    private BiomeGenBase[] field_151623_c;
    private BiomeGenBase[] field_151621_d;
    private BiomeGenBase[] field_151622_e;
    private BiomeGenBase[] field_151620_f;
    private static final String __OBFID = "CL_00000555";

    public GenLayerBiome(long par1, GenLayer par3GenLayer, WorldType par4WorldType)
    {
        super(par1);
        this.field_151623_c = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.desert, BiomeGenBase.desert, BiomeGenBase.field_150588_X, BiomeGenBase.field_150588_X, BiomeGenBase.plains};
        this.field_151621_d = new BiomeGenBase[] {BiomeGenBase.forest, BiomeGenBase.field_150585_R, BiomeGenBase.extremeHills, BiomeGenBase.plains, BiomeGenBase.field_150583_P, BiomeGenBase.swampland};
        this.field_151622_e = new BiomeGenBase[] {BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.taiga, BiomeGenBase.plains};
        this.field_151620_f = new BiomeGenBase[] {BiomeGenBase.icePlains, BiomeGenBase.icePlains, BiomeGenBase.icePlains, BiomeGenBase.field_150584_S};
        this.parent = par3GenLayer;

        if (par4WorldType == WorldType.DEFAULT_1_1)
        {
            this.field_151623_c = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga};
        }
    }

    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int[] var5 = this.parent.getInts(par1, par2, par3, par4);
        int[] var6 = IntCache.getIntCache(par3 * par4);

        for (int var7 = 0; var7 < par4; ++var7)
        {
            for (int var8 = 0; var8 < par3; ++var8)
            {
                this.initChunkSeed((long)(var8 + par1), (long)(var7 + par2));
                int var9 = var5[var8 + var7 * par3];
                int var10 = (var9 & 3840) >> 8;
                var9 &= -3841;

                if (func_151618_b(var9))
                {
                    var6[var8 + var7 * par3] = var9;
                }
                else if (var9 == BiomeGenBase.mushroomIsland.biomeID)
                {
                    var6[var8 + var7 * par3] = var9;
                }
                else if (var9 == 1)
                {
                    if (var10 > 0)
                    {
                        if (this.nextInt(3) == 0)
                        {
                            var6[var8 + var7 * par3] = BiomeGenBase.field_150608_ab.biomeID;
                        }
                        else
                        {
                            var6[var8 + var7 * par3] = BiomeGenBase.field_150607_aa.biomeID;
                        }
                    }
                    else
                    {
                        var6[var8 + var7 * par3] = this.field_151623_c[this.nextInt(this.field_151623_c.length)].biomeID;
                    }
                }
                else if (var9 == 2)
                {
                    if (var10 > 0)
                    {
                        var6[var8 + var7 * par3] = BiomeGenBase.jungle.biomeID;
                    }
                    else
                    {
                        var6[var8 + var7 * par3] = this.field_151621_d[this.nextInt(this.field_151621_d.length)].biomeID;
                    }
                }
                else if (var9 == 3)
                {
                    if (var10 > 0)
                    {
                        var6[var8 + var7 * par3] = BiomeGenBase.field_150578_U.biomeID;
                    }
                    else
                    {
                        var6[var8 + var7 * par3] = this.field_151622_e[this.nextInt(this.field_151622_e.length)].biomeID;
                    }
                }
                else if (var9 == 4)
                {
                    var6[var8 + var7 * par3] = this.field_151620_f[this.nextInt(this.field_151620_f.length)].biomeID;
                }
                else
                {
                    var6[var8 + var7 * par3] = BiomeGenBase.mushroomIsland.biomeID;
                }
            }
        }

        return var6;
    }
}
