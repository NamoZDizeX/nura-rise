package net.namozdizex.nura.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.namozdizex.nura.NuraRise;
import net.namozdizex.nura.world.level.block.*;

public class NRBlocks
{
    public static final Block YOKAI_LAMP = new YokaiLampBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).lightLevel(state -> 15).requiresCorrectToolForDrops().strength(1.0F,15.5F));
    public static final Block SOUL_YOKAI_LAMP = new YokaiLampBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).lightLevel(state -> 15).requiresCorrectToolForDrops().strength(1.0F,15.5F));
    public static final Block TATAMI_BLOCK = new Block(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).requiresCorrectToolForDrops().strength(1.2f, 0.5f));
    public static final Block TSUGIKUMO_WEB_BLOCK = new Block(BlockBehaviour.Properties.of(Material.WEB).sound(SoundType.SLIME_BLOCK).requiresCorrectToolForDrops().strength(10.5f, 25.5f));
    public static final Block ICE_YOKAI_CLUSTER = new IceYokaiClusterBlock(7, 3, BlockBehaviour.Properties.of(Material.AMETHYST).sound(SoundType.AMETHYST_CLUSTER).lightLevel(state -> 6).requiresCorrectToolForDrops().strength(1.5F).isValidSpawn(NRBlocks::never).isSuffocating(NRBlocks::never).isViewBlocking(NRBlocks::never));
    public static final Block SMALL_ICE_YOKAI_BUD = new IceYokaiClusterBlock(3, 4 ,BlockBehaviour.Properties.of(Material.AMETHYST).sound(SoundType.AMETHYST_CLUSTER).lightLevel(state -> 3).requiresCorrectToolForDrops().strength(1.5F).isValidSpawn(NRBlocks::never).isSuffocating(NRBlocks::never).isViewBlocking(NRBlocks::never));
    public static final Block MEDIUM_ICE_YOKAI_BUD = new IceYokaiClusterBlock(4, 3, BlockBehaviour.Properties.of(Material.AMETHYST).sound(SoundType.AMETHYST_CLUSTER).lightLevel(state -> 4).requiresCorrectToolForDrops().strength(1.5F).isValidSpawn(NRBlocks::never).isSuffocating(NRBlocks::never).isViewBlocking(NRBlocks::never));
    public static final Block LARGE_ICE_YOKAI_BUD = new IceYokaiClusterBlock(5, 3, BlockBehaviour.Properties.of(Material.AMETHYST).sound(SoundType.AMETHYST_CLUSTER).lightLevel(state -> 5).requiresCorrectToolForDrops().strength(1.5F).isValidSpawn(NRBlocks::never).isSuffocating(NRBlocks::never).isViewBlocking(NRBlocks::never));
    public static final Block BLADE_STAND = new BladeStandBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).requiresCorrectToolForDrops().strength(0.3f, 5.4f));
    public static final Block UNFIRE_YOKAI_LAMP = new YokaiLampBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops());
    public static final Block CURSED_YOKAI_LAMP = new CursedYokaiLampBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(0.3f,5.4f));
    public static final Block TAMATSUKI_LAMP = new CursedYokaiLampBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(0.3f,5.4f));

    public static void init()
    {
        register("yokai_lamp", YOKAI_LAMP, new Item.Properties().tab(NuraRise.TAB));
        register("soul_yokai_lamp", SOUL_YOKAI_LAMP, new Item.Properties().tab(NuraRise.TAB));
        register("tatami_block", TATAMI_BLOCK, new Item.Properties().tab(NuraRise.TAB));
        register("tsugikumo_web_block", TSUGIKUMO_WEB_BLOCK, new Item.Properties().tab(NuraRise.TAB));
        register("ice_yokai_cluster", ICE_YOKAI_CLUSTER, new Item.Properties().tab(NuraRise.TAB));
        register("small_ice_yokai_bud", SMALL_ICE_YOKAI_BUD, new Item.Properties().tab(NuraRise.TAB));
        register("medium_ice_yokai_bud", MEDIUM_ICE_YOKAI_BUD, new Item.Properties().tab(NuraRise.TAB));
        register("large_ice_yokai_bud", LARGE_ICE_YOKAI_BUD, new Item.Properties().tab(NuraRise.TAB));
        register("blade_stand", BLADE_STAND, new Item.Properties().tab(NuraRise.TAB));
        register("unfire_yokai_lamp", UNFIRE_YOKAI_LAMP, new Item.Properties().tab(NuraRise.TAB));
        register("cursed_yokai_lamp", CURSED_YOKAI_LAMP, new Item.Properties().tab(NuraRise.TAB));
        register("tamatsuki_lamp", TAMATSUKI_LAMP, new Item.Properties().tab(NuraRise.TAB));
    }

    public static void register(String key, Block block, Object o)
    {
        register(key, block, null);
    }

    public static void register(String key, Block block, Item.Properties properties)
    {
        Registry.register(Registry.BLOCK, new ResourceLocation(NuraRise.MOD_ID, key), block);

        if (properties != null);
        {
            Registry.register(Registry.ITEM, new ResourceLocation(NuraRise.MOD_ID, key), new BlockItem(block, properties));
        }
    }
    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType entityType)
    {
        return false;
    }

    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos)
    {
        return false;
    }
}
