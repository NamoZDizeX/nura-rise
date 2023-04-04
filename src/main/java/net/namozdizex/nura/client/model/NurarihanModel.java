package net.namozdizex.nura.client.model;

import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.namozdizex.nura.NuraRise;
import net.namozdizex.nura.entity.Nurarihan;
import net.namozdizex.nura.entity.Nurarihyon;

public class NurarihanModel <T extends Nurarihan> extends AbstractZombieModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(new ResourceLocation(NuraRise.MOD_ID, "nurarihan"), "main");
    public NurarihanModel(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public boolean isAggressive(T monster) {
        return monster.isAggressive();
    }
}
