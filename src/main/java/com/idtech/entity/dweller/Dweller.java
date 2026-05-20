package com.idtech.entity.dweller;

import com.idtech.BaseMod;
import com.idtech.entity.redstone_golem.RedstoneGolem;
import com.idtech.sound.SoundMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class Dweller extends Monster implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);



    public Dweller(EntityType<? extends Monster> entityIn, Level levelIn){
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

    public static AttributeSupplier setAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH,99999999.0d).add(Attributes.MOVEMENT_SPEED,0.25D).add(Attributes.KNOCKBACK_RESISTANCE,1.0d).add(Attributes.ATTACK_DAMAGE,20.0d).build();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if(event.isMoving()){
            LivingEntity target = getTarget();
            if(target instanceof Player){
                BaseMod.LOGGER.info("THIS SHOULD BE RUNNING");
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dweller.chase", ILoopType.EDefaultLoopTypes.LOOP));
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dweller.walk", ILoopType.EDefaultLoopTypes.LOOP));
            }
            return PlayState.CONTINUE;
        }


        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dweller.stand_still", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor a, DifficultyInstance d, MobSpawnType t, @Nullable SpawnGroupData g, @Nullable CompoundTag c){
        this.playSound(SoundMod.DWELLER_SPAWN.get(),1.0f,1.0f);
        return super.finalizeSpawn(a,d,t,g,c);
    }

    public int getAmbientSoundInterval() {
        return 40;
    }

    protected float getSoundVolume(){
        return 0.5f;
    }

    protected SoundEvent getAmbientSound(){
        return SoundMod.DWELLER_AMBIENT.get();
//        return SoundEvents.CAT_STRAY_AMBIENT;
    }

 /*   public void tick (){

    }*/

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this,"controller",0,this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

}
