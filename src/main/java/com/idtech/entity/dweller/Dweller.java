package com.idtech.entity.dweller;

import com.idtech.entity.redstone_golem.RedstoneGolem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Dweller extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);



    public Dweller(EntityType<? extends Monster> entityIn, Level levelIn){
        super(entityIn,levelIn);
    }

    protected void registerGoals(){
//        this.goalSelector.addGoal(1,new MeleeAttackGoal(this,1.0d,true));
//        this.goalSelector.addGoal(2,new MoveTowardsTargetGoal(this,0.9d,32.0f));
//        this.goalSelector.addGoal(7,new LookAtPlayerGoal(this, Player.class,6.0f));
//        this.goalSelector.addGoal(8,new RandomLookAroundGoal(this));
//        this.goalSelector.addGoal(5,new RandomStrollGoal(this,1.0d));
//        this.targetSelector.addGoal(1,new HurtByTargetGoal(this));
//        this.targetSelector.addGoal(2,new NearestAttackableTargetGoal<>(this,Player.class,true
    }

    public static AttributeSupplier setAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH,99999999.0d).add(Attributes.MOVEMENT_SPEED,0.25D).add(Attributes.KNOCKBACK_RESISTANCE,1.0d).add(Attributes.ATTACK_DAMAGE,20.0d).build();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if(event.isMoving()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dweller.walk",true));
        }
        return PlayState.CONTINUE;
    }



    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this,"controller",0,this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

}
