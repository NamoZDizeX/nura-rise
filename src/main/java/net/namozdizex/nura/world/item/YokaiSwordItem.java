package net.namozdizex.nura.world.item;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class YokaiSwordItem extends SwordItem {

    public YokaiSwordItem(Item.Properties properties) {
        super(TiersNR.YOKAI_HEART, 12, -2.4F, properties);
    }
}
