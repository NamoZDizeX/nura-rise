package net.namozdizex.nura.client.renderer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.namozdizex.nura.client.model.NurarihanModel;
import net.namozdizex.nura.client.model.NurarihyonModel;
import net.namozdizex.nura.entity.Nurarihan;

public class NurarihanRenderer extends AbstractRihanRenderer<Nurarihan, NurarihanModel<Nurarihan>>{

    private static final ResourceLocation RIHYON = new ResourceLocation("nura:textures/entity/yokai/nurarihyon.png");
    public NurarihanRenderer(EntityRendererProvider.Context context) {
        this(context, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
    }
    public NurarihanRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, ModelLayerLocation modelLayerLocation2, ModelLayerLocation modelLayerLocation3) {
        super(context, new NurarihanModel<>(context.bakeLayer(modelLayerLocation)), new NurarihanModel(context.bakeLayer(modelLayerLocation2)), new NurarihanModel(context.bakeLayer(modelLayerLocation3)));
    }
}
