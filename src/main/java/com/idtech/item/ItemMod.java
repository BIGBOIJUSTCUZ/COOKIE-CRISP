package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber
public class ItemMod {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BaseMod.MODID);

    public static final RegistryObject<Item> STRUCTURE_GEL = ITEMS.register("structurgel",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> OHS_ITEM = ITEMS.register("ohs",
            () -> new OHS (Tiers.NETHERITE,1000000, 100, OHS.properties));
    public static final RegistryObject<Item> CHUNKPICK_ITEM = ITEMS.register("chunckpick",
            () -> new Chunkpick(Tiers.IRON,100, 100, Chunkpick.properties));
    public static final RegistryObject<Item> CARTOON_HAMMER_ITEM = ITEMS.register("cartoonh",
            () -> new CartoonHamer(Tiers.IRON, 25, 30, CartoonHamer.properties));
    public static final RegistryObject<Item> LIGHTNING_ROD_ITEM = ITEMS.register("lightning_rod",
            () -> new LightningRod(LightningRod.props));
    public static final RegistryObject<Item> TELEPORT_ROD_ITEM = ITEMS.register("teleport_rod",
            () -> new TeleportRodItem(TeleportRodItem.props));
    public static final RegistryObject<Item> BOMB_ARROW_ITEM = ITEMS.register("bombarrow",
            () -> new BombArrowItem(BombArrowItem.properties));
    public static final RegistryObject<Item> THROWABLE_FIREBALL_ITEM = ITEMS.register("throwable_fireball_item",
            () -> new ThrowableFireballItem(ThrowableFireballItem.props));
    //FOODS

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }

}
