package net.minecraft.item.crafting;

import java.util.ArrayList;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class RecipeFireworks implements IRecipe
{
    private ItemStack field_92102_a;
    private static final String __OBFID = "CL_00000083";

    public boolean matches(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        this.field_92102_a = null;
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;

        for (int var9 = 0; var9 < par1InventoryCrafting.getSizeInventory(); ++var9)
        {
            ItemStack var10 = par1InventoryCrafting.getStackInSlot(var9);

            if (var10 != null)
            {
                if (var10.getItem() == Items.gunpowder)
                {
                    ++var4;
                }
                else if (var10.getItem() == Items.firework_charge)
                {
                    ++var6;
                }
                else if (var10.getItem() == Items.dye)
                {
                    ++var5;
                }
                else if (var10.getItem() == Items.paper)
                {
                    ++var3;
                }
                else if (var10.getItem() == Items.glowstone_dust)
                {
                    ++var7;
                }
                else if (var10.getItem() == Items.diamond)
                {
                    ++var7;
                }
                else if (var10.getItem() == Items.fire_charge)
                {
                    ++var8;
                }
                else if (var10.getItem() == Items.feather)
                {
                    ++var8;
                }
                else if (var10.getItem() == Items.gold_nugget)
                {
                    ++var8;
                }
                else
                {
                    if (var10.getItem() != Items.skull)
                    {
                        return false;
                    }

                    ++var8;
                }
            }
        }

        var7 += var5 + var8;

        if (var4 <= 3 && var3 <= 1)
        {
            NBTTagCompound var16;
            NBTTagCompound var19;

            if (var4 >= 1 && var3 == 1 && var7 == 0)
            {
                this.field_92102_a = new ItemStack(Items.fireworks);

                if (var6 > 0)
                {
                    var16 = new NBTTagCompound();
                    var19 = new NBTTagCompound();
                    NBTTagList var25 = new NBTTagList();

                    for (int var22 = 0; var22 < par1InventoryCrafting.getSizeInventory(); ++var22)
                    {
                        ItemStack var26 = par1InventoryCrafting.getStackInSlot(var22);

                        if (var26 != null && var26.getItem() == Items.firework_charge && var26.hasTagCompound() && var26.getTagCompound().hasKey("Explosion", 10))
                        {
                            var25.appendTag(var26.getTagCompound().getCompoundTag("Explosion"));
                        }
                    }

                    var19.setTag("Explosions", var25);
                    var19.setByte("Flight", (byte)var4);
                    var16.setTag("Fireworks", var19);
                    this.field_92102_a.setTagCompound(var16);
                }

                return true;
            }
            else if (var4 == 1 && var3 == 0 && var6 == 0 && var5 > 0 && var8 <= 1)
            {
                this.field_92102_a = new ItemStack(Items.firework_charge);
                var16 = new NBTTagCompound();
                var19 = new NBTTagCompound();
                byte var23 = 0;
                ArrayList var12 = new ArrayList();

                for (int var13 = 0; var13 < par1InventoryCrafting.getSizeInventory(); ++var13)
                {
                    ItemStack var14 = par1InventoryCrafting.getStackInSlot(var13);

                    if (var14 != null)
                    {
                        if (var14.getItem() == Items.dye)
                        {
                            var12.add(Integer.valueOf(ItemDye.field_150922_c[var14.getItemDamage()]));
                        }
                        else if (var14.getItem() == Items.glowstone_dust)
                        {
                            var19.setBoolean("Flicker", true);
                        }
                        else if (var14.getItem() == Items.diamond)
                        {
                            var19.setBoolean("Trail", true);
                        }
                        else if (var14.getItem() == Items.fire_charge)
                        {
                            var23 = 1;
                        }
                        else if (var14.getItem() == Items.feather)
                        {
                            var23 = 4;
                        }
                        else if (var14.getItem() == Items.gold_nugget)
                        {
                            var23 = 2;
                        }
                        else if (var14.getItem() == Items.skull)
                        {
                            var23 = 3;
                        }
                    }
                }

                int[] var24 = new int[var12.size()];

                for (int var27 = 0; var27 < var24.length; ++var27)
                {
                    var24[var27] = ((Integer)var12.get(var27)).intValue();
                }

                var19.setIntArray("Colors", var24);
                var19.setByte("Type", var23);
                var16.setTag("Explosion", var19);
                this.field_92102_a.setTagCompound(var16);
                return true;
            }
            else if (var4 == 0 && var3 == 0 && var6 == 1 && var5 > 0 && var5 == var7)
            {
                ArrayList var15 = new ArrayList();

                for (int var17 = 0; var17 < par1InventoryCrafting.getSizeInventory(); ++var17)
                {
                    ItemStack var11 = par1InventoryCrafting.getStackInSlot(var17);

                    if (var11 != null)
                    {
                        if (var11.getItem() == Items.dye)
                        {
                            var15.add(Integer.valueOf(ItemDye.field_150922_c[var11.getItemDamage()]));
                        }
                        else if (var11.getItem() == Items.firework_charge)
                        {
                            this.field_92102_a = var11.copy();
                            this.field_92102_a.stackSize = 1;
                        }
                    }
                }

                int[] var18 = new int[var15.size()];

                for (int var20 = 0; var20 < var18.length; ++var20)
                {
                    var18[var20] = ((Integer)var15.get(var20)).intValue();
                }

                if (this.field_92102_a != null && this.field_92102_a.hasTagCompound())
                {
                    NBTTagCompound var21 = this.field_92102_a.getTagCompound().getCompoundTag("Explosion");

                    if (var21 == null)
                    {
                        return false;
                    }
                    else
                    {
                        var21.setIntArray("FadeColors", var18);
                        return true;
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting)
    {
        return this.field_92102_a.copy();
    }

    public int getRecipeSize()
    {
        return 10;
    }

    public ItemStack getRecipeOutput()
    {
        return this.field_92102_a;
    }
}
