


package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class Chunkpick extends PickaxeItem {


    public static Tier tier = new ForgeTier(4, 9999
            , 9999.0F, 10.0F, 30,
            null, ()->{return Ingredient.of(ItemMod.STRUCTURE_GEL.get());});
    public static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);
    public static Item INSTANCE = new Chunkpick(Tiers.IRON,100, 100, properties).setRegistryName(BaseMod.MODID,"chunkpick");

    public Chunkpick(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}



