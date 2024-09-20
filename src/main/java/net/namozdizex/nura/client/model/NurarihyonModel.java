package net.namozdizex.nura.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.namozdizex.nura.NuraRise;
import net.namozdizex.nura.entity.Nurarihyon;

@Environment(EnvType.CLIENT)
public class NurarihyonModel <T extends Nurarihyon> extends AbstractZombieModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(new ResourceLocation(NuraRise.MOD_ID, "nurarihyon"), "main");
    public NurarihyonModel(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public boolean isAggressive(T monster) {
        return monster.isAggressive();
    }
}
