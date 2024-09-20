package net.namozdizex.nura.client.renderer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.namozdizex.nura.client.model.NurarihyonModel;
import net.namozdizex.nura.entity.Nurarihyon;

public class NurarihyonRenderer extends AbstractRihyonRenderer<Nurarihyon, NurarihyonModel<Nurarihyon>> {
    private static final ResourceLocation RIHYON = new ResourceLocation("nura:textures/entity/yokai/nurarihyon.png");
    public NurarihyonRenderer(EntityRendererProvider.Context context) {
        this(context, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
    }

    public NurarihyonRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, ModelLayerLocation modelLayerLocation2, ModelLayerLocation modelLayerLocation3) {
        super(context, new NurarihyonModel<>(context.bakeLayer(modelLayerLocation)), new NurarihyonModel(context.bakeLayer(modelLayerLocation2)), new NurarihyonModel(context.bakeLayer(modelLayerLocation3)));
    }
}
