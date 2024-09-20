package net.namozdizex.nura.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;
import net.namozdizex.nura.client.model.NurarihyonModel;
import net.namozdizex.nura.entity.Nurarihyon;

public class AbstractRihyonRenderer <T extends Nurarihyon, M extends NurarihyonModel<T>> extends HumanoidMobRenderer<T, M> {
    private static final ResourceLocation RIHYON = new ResourceLocation("nura:textures/entity/yokai/nurarihyon.png");

    public AbstractRihyonRenderer(EntityRendererProvider.Context context, M nurarihyonModel, M nurarihyonModel1, M nurarihyonModel2) {
        super(context, nurarihyonModel, 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, nurarihyonModel1, nurarihyonModel2));
    }

    public ResourceLocation getTextureLocation(Nurarihyon nurarihyon) {
        return RIHYON;
    }
}
