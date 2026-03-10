package com.idtech.sound;

import com.idtech.BaseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundMod {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BaseMod.MODID);

    private static RegistryObject <SoundEvent> registerSoundEvent (String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(BaseMod.MODID, name)));
    }

    public static void register(IEventBus bus){
        SOUND_EVENTS.register(bus);
    }
}
