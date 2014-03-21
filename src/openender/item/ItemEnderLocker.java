package openender.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import openender.Config;
import openender.OpenEnder;
import openender.common.DimensionDataManager;
import openender.common.EnderTeleporter;
import openender.utils.PlayerDataManager;

public class ItemEnderLocker extends Item {

	public ItemEnderLocker() {
		super(Config.itemEnderLockerId);
		setCreativeTab(OpenEnder.tabOpenEnder);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

		if (player instanceof EntityPlayerMP) {
			final int privateWorldId = DimensionDataManager.instance.getDimensionForPlayer(player.username);
			if (privateWorldId != world.provider.dimensionId) {
				PlayerDataManager.pushSpawnLocation(player);
				EnderTeleporter.teleport(player, privateWorldId);
			}
		}

		return stack;

	}
}
