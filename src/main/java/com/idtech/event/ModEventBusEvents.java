package com.idtech.event;

import com.idtech.BaseMod;
import com.idtech.entity.CartoonMan;
import com.idtech.entity.EntityMod;
import com.idtech.entity.ZomboEntity;
import com.idtech.entity.redstone_golem.RedstoneGolem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BaseMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(EntityMod.REDSTONE_GOLEM.get(),RedstoneGolem.setAttributes());
        event.put(EntityMod.ZOMBO_ENTITY.get(),ZomboEntity.setAttributes());
    }
}
