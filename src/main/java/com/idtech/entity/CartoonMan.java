



package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class CartoonMan extends PathfinderMob implements Enemy
{
    //TYPE
    public static EntityType<CartoonMan> TYPE = (EntityType<CartoonMan>)
            EntityType.Builder.of(CartoonMan::new, MobCategory.MONSTER).sized(0.6F, 1.95F).
                    clientTrackingRange(8).build("cartoonman").setRegistryName(BaseMod.MODID, "cartoonman");
    //EGG
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xfef9f8 , 0x383737);

    public CartoonMan (EntityType<? extends PathfinderMob> cartoon_man, Level level ) {
        super(cartoon_man, level);
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 10000000)
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.ATTACK_DAMAGE, 10000)
                .add(Attributes.FOLLOW_RANGE, 10000);
    }

    @Override
    public void registerGoals(){
        this.targetSelector.addGoal(0,new FloatGoal(this));
        this.targetSelector.addGoal(1,new NearestAttackableTargetGoal<>(this, Player.class,true));
        this.targetSelector.addGoal(2,new NearestAttackableTargetGoal<>(this, Mob.class,true));
        this.targetSelector.addGoal(1,new MeleeAttackGoal(this,1.0D,false));
        this.targetSelector.addGoal(2,new WaterAvoidingRandomStrollGoal(this,1.0d));
        this.targetSelector.addGoal(8,new LookAtPlayerGoal(this,Player.class,8.0F));
        this.targetSelector.addGoal(8,new RandomLookAroundGoal(this));

    }

}


