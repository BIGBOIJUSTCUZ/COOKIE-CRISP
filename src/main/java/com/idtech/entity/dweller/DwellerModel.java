package com.idtech.entity.dweller;

import com.idtech.BaseMod;
import com.idtech.entity.redstone_golem.RedstoneGolem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DwellerModel extends AnimatedGeoModel<Dweller> {
    @Override
    public ResourceLocation getModelLocation(Dweller obj){
        return new ResourceLocation(BaseMod.MODID, "geo/dweller.geo.json");
    }
    @Override
    public ResourceLocation getTextureLocation(Dweller obj){
        return new ResourceLocation(BaseMod.MODID, "textures/entity/dweller.png");
    }
    @Override
    public ResourceLocation getAnimationFileLocation(Dweller obj){
        return new ResourceLocation(BaseMod.MODID, "animations/dweller.animation.json");
    }
}
