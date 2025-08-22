package com.idtech.entity.redstone_golem;

import com.idtech.BaseMod;
import com.idtech.entity.EntityUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import javax.swing.text.html.parser.Entity;

public class RedstoneGolem extends AbstractGolem {
    public static final EntityType<RedstoneGolem> TYPE = (EntityType<RedstoneGolem>)
            EntityType.Builder.<RedstoneGolem>of(RedstoneGolem::new, MobCategory.MISC).sized(1.4f,2.7f)
                    .clientTrackingRange(12).build("redstone_golem").setRegistryName(BaseMod.MODID,"redstone_golem");

    public static final Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE,0x605E5E, 0xF60B0B);

    public RedstoneGolem(EntityType<? extends RedstoneGolem> entityIn, Level levelIn){
        super(entityIn,levelIn);
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(1,new MeleeAttackGoal(this,1.0d,true));
        this.goalSelector.addGoal(2,new MoveTowardsTargetGoal(this,0.9d,32.0f));
        this.goalSelector.addGoal(7,new LookAtPlayerGoal(this, Player.class,6.0f));
        this.goalSelector.addGoal(8,new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5,new RandomStrollGoal(this,1.0d));
        this.targetSelector.addGoal(1,new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2,new NearestAttackableTargetGoal<>(this,Player.class,true));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH,100.0d).add(Attributes.MOVEMENT_SPEED,0.25D).add(Attributes.KNOCKBACK_RESISTANCE,1.0d).add(Attributes.ATTACK_DAMAGE,15.0d);
    }
}
