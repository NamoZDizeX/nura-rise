package net.namozdizex.nura;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.namozdizex.nura.entity.Nurarihan;
import net.namozdizex.nura.entity.Nurarihyon;
import net.namozdizex.nura.registry.NRBlocks;
import net.namozdizex.nura.registry.NREntity;
import net.namozdizex.nura.registry.NRItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NuraRise implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static String MOD_ID = "nura";
	public static final CreativeModeTab TAB = FabricItemGroupBuilder.build(new ResourceLocation(NuraRise.MOD_ID, "main"), () -> new ItemStack(NRItems.NENEKIRIMARU));

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		NRItems.init();
		NRBlocks.init();
		NREntity.init();

		FabricDefaultAttributeRegistry.register(NREntity.NURARIHYON, Nurarihyon.createMobAttributes());
		FabricDefaultAttributeRegistry.register(NREntity.NURARIHAN, Nurarihan.createMobAttributes());

	}
}
