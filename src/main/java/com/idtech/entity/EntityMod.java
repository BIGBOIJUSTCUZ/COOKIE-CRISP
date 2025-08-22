package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.entity.redstone_golem.RedstoneGolem;
import com.idtech.entity.redstone_golem.RedstoneGolemRenderFactory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityMod {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, BaseMod.MODID);

    public static final RegistryObject<EntityType<ZomboEntity>> ZOMBO_ENTITY =
            ENTITY_TYPES.register("zombo",
                    () -> EntityType.Builder.of(ZomboEntity::new, MobCategory.MONSTER)
                            .build(new ResourceLocation(BaseMod.MODID, "zombo").toString()));

    public static final RegistryObject<EntityType<CartoonMan>> CARTOON_MAN =
            ENTITY_TYPES.register("cartoonman",
                    () -> EntityType.Builder.of(CartoonMan::new, MobCategory.MONSTER)
                            .build(new ResourceLocation(BaseMod.MODID, "cartoonman").toString()));

    public static final RegistryObject<EntityType<CartoonMan>> REDSTONE_GOLEM =
            ENTITY_TYPES.register("redstoner_golem",
                    () -> EntityType.Builder.of(CartoonMan::new, MobCategory.MONSTER)
                            .build(new ResourceLocation(BaseMod.MODID, "redstone_golem").toString()));

    public static void register(IEventBus eBus){
        //ENTITY_TYPES.register(eBus )
    }

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
        event.getRegistry().register(ZomboEntity.TYPE);
        event.getRegistry().register(CartoonMan.TYPE);
        event.getRegistry().register(RedstoneGolem.TYPE);
    }
    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(ZomboEntity.EGG);
        event.getRegistry().register(CartoonMan.EGG);
        event.getRegistry().register(RedstoneGolem.EGG);
    }
    @SubscribeEvent
    public static void entityRenderers(final EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ZomboEntity.TYPE, ZomboRenderFactory.INSTANCE);
        event.registerEntityRenderer(CartoonMan.TYPE, CartoonManRenderFactory.INSTANCE);
        event.registerEntityRenderer(RedstoneGolem.TYPE, RedstoneGolemRenderFactory.INSTANCE);
    }

    // this is different than in 1.16 but everything else is the same
    // I do think this makes more sense than the other way but alas change is usually hard.
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ZomboEntity.TYPE, ZomboEntity.createAttributes().build());
        event.put(CartoonMan.TYPE, CartoonMan.createAttributes().build());
        event.put(RedstoneGolem.TYPE, RedstoneGolem.createAttributes().build());
    }

}
