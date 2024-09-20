package net.namozdizex.nura.world.item;

import net.minecraft.client.GuiMessageTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;

import java.util.List;

public class RihyonSwordItem extends SwordItem {

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        tooltipFlag.equals(Component.translatable("This item from dungeon recipe"));

        super.appendHoverText(itemStack, level, list, tooltipFlag);
    }

    public RihyonSwordItem(Item.Properties properties) {
        super(TiersNR.RIHYON, 12, -2.4F, properties);
    }
}
