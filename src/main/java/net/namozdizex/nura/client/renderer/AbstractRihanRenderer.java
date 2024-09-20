package net.namozdizex.nura.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.namozdizex.nura.client.model.NurarihanModel;
import net.namozdizex.nura.entity.Nurarihan;

public class AbstractRihanRenderer <T extends Nurarihan, M extends NurarihanModel<T>> extends HumanoidMobRenderer<T, M> {

    private static final ResourceLocation RIHAN = new ResourceLocation("nura:textures/entity/yokai/nura_rihan.png");
    public AbstractRihanRenderer(EntityRendererProvider.Context context, M nurarihanModel, M nurarihanModel1, M nurarihanModel2) {
        super(context, nurarihanModel, 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, nurarihanModel1, nurarihanModel2));
    }

    public ResourceLocation getTextureLocation(Nurarihan nurarihan) {return RIHAN;}
}
