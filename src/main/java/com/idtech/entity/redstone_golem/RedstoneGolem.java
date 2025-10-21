package com.idtech.entity.redstone_golem;

import com.idtech.BaseMod;
import com.idtech.entity.CartoonMan;
import com.idtech.entity.EntityMod;
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
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.swing.text.html.parser.Entity;

public class RedstoneGolem extends AbstractGolem implements IAnimatable {
   //public static final EntityType<RedstoneGolem> TYPE = (EntityType<RedstoneGolem>)
   //        EntityType.Builder.<RedstoneGolem>of(RedstoneGolem::new, MobCategory.MISC).sized(1.4f,2.7f)
   //               .clientTrackingRange(12).build("redstone_golem");
//   public static EntityType<RedstoneGolem> TYPE = (EntityType<RedstoneGolem>)
//           EntityType.Builder.of(RedstoneGolem::new, MobCategory.MONSTER).sized(0.6F, 1.95F).
//                   clientTrackingRange(8).build("redstone_golem").setRegistryName(BaseMod.MODID, "redstone_golem");
//    public static final Item EGG = EntityUtils.buildEntitySpawnEgg(EntityMod.REDSTONE_GOLEM.get(),0x605E5E, 0xF60B0B);

    private AnimationFactory factory = new AnimationFactory(this);



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

    public static AttributeSupplier setAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH,250.0d).add(Attributes.MOVEMENT_SPEED,0.25D).add(Attributes.KNOCKBACK_RESISTANCE,1.0d).add(Attributes.ATTACK_DAMAGE,20.0d).build();
    }

   private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event){
        if(event.isMoving()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.redstone_golem.walking",true));
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
