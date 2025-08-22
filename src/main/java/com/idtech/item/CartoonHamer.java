package com.idtech.item;

import net.minecraft.world.item.*;

public class CartoonHamer extends SwordItem {
    public static Properties properties = new Properties().tab(CreativeModeTab.TAB_MISC);
    public static Item INSTANCE = new CartoonHamer(Tiers.IRON, 25, 30, properties).setRegistryName("cartoonh");

    public CartoonHamer(Tier tier, int speed, float damage, Properties properties) {
        super(tier, speed, damage, properties);
    }
}