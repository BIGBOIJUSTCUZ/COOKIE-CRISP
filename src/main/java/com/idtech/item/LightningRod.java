package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LightningRod extends Item {
    public static Properties props = new Properties().tab(CreativeModeTab.TAB_MISC);
    public static final Item INSTANCE = new LightningRod(props).setRegistryName(BaseMod.MODID, "lightning_rod");

    public LightningRod(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder <ItemStack> use(Level level, Player player, InteractionHand hand){
        ItemStack iStack = player.getItemInHand(hand);
        BlockPos loc = Utils.getBlockAtCursor(player,200.0d,true);
        float explosionRadius = 10.0f;

        if(loc != null){
            Utils.createExplosion(level,loc,explosionRadius);
            Utils.strikeLightning(level,loc);
            return InteractionResultHolder.success(iStack);
        } else {
            return InteractionResultHolder.fail(iStack);
        }
    }
}
