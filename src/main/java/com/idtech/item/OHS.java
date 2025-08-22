package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class OHS extends SwordItem {


    public static Tier tier = new ForgeTier(4, 1000000, 25.0F, 10.0F, 10,null, ()->{return Ingredient.of(ItemMod.STRUCTURE_GEL.get());});
    public static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);
    public static Item INSTANCE = new OHS (Tiers.NETHERITE,1000000, 100, properties).setRegistryName(BaseMod.MODID,"ohs");

    public OHS (Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
    }