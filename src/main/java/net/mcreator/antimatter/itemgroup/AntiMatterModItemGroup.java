
package net.mcreator.antimatter.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.antimatter.block.AntiMatterBlock;
import net.mcreator.antimatter.AntimatterModElements;

@AntimatterModElements.ModElement.Tag
public class AntiMatterModItemGroup extends AntimatterModElements.ModElement {
	public AntiMatterModItemGroup(AntimatterModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanti_matter_mod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AntiMatterBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
