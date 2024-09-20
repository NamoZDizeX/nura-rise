package net.namozdizex.nura;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.namozdizex.nura.client.renderer.NurarihanRenderer;
import net.namozdizex.nura.client.renderer.NurarihyonRenderer;
import net.namozdizex.nura.registry.NRBlocks;
import net.namozdizex.nura.registry.NREntity;

public class NuraRiseClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        var cutout = RenderType.cutout();
        var translucent = RenderType.translucent();

        BlockRenderLayerMap.INSTANCE.putBlocks(translucent, NRBlocks.TATAMI_BLOCK);
        BlockRenderLayerMap.INSTANCE.putBlocks(translucent, NRBlocks.TSUGIKUMO_WEB_BLOCK);

        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, NRBlocks.ICE_YOKAI_CLUSTER);
        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, NRBlocks.SMALL_ICE_YOKAI_BUD);
        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, NRBlocks.MEDIUM_ICE_YOKAI_BUD);
        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, NRBlocks.LARGE_ICE_YOKAI_BUD);

        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, NRBlocks.YOKAI_LAMP);
        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, NRBlocks.SOUL_YOKAI_LAMP);
        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, NRBlocks.BLADE_STAND);

        EntityRendererRegistry.register(NREntity.NURARIHYON, NurarihyonRenderer::new);
        EntityRendererRegistry.register(NREntity.NURARIHAN, NurarihanRenderer::new);
    }
}
