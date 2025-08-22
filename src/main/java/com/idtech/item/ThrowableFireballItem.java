package com.idtech.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ThrowableFireballItem extends Item {

    public static final Properties props = new Properties().tab(CreativeModeTab.TAB_MISC);
    public static final Item INSTANCE = new ThrowableFireballItem(props).setRegistryName("throwable_fireball_item");

    public ThrowableFireballItem(Properties props){
        super(props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn){
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        levelIn.playSound((Player) null, playerIn.getX(),playerIn.getY(),playerIn.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL,0.5f,0.4f/(levelIn.getRandom().nextFloat()*0.4f+0.8f));
        if (!levelIn.isClientSide){
            Vec3 tar;
            Vec3 view = playerIn.getViewVector(1.0f);
            LargeFireball projectile = new LargeFireball(levelIn,playerIn, view.x, view.y, view.z,3);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(playerIn,playerIn.getXRot(),playerIn. getYRot(),0.0f,1.5f,1.0f);
            levelIn.addFreshEntity(projectile);
        }

        if(!playerIn.getAbilities().instabuild){
            itemStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,levelIn.isClientSide());
    }
}

