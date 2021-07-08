
package net.mcreator.antimatter.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.antimatter.itemgroup.AntiMatterModItemGroup;
import net.mcreator.antimatter.AntimatterModElements;

import java.util.List;

@AntimatterModElements.ModElement.Tag
public class AntiMatterToolsHoeItem extends AntimatterModElements.ModElement {
	@ObjectHolder("antimatter:anti_matter_tools_hoe")
	public static final Item block = null;
	public AntiMatterToolsHoeItem(AntimatterModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 500f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AntiMatterIngotItem.block, (int) (1)));
			}
		}, 0, -3f, new Item.Properties().group(AntiMatterModItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("The hoe pulses with raw power... (why did you make this)"));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("anti_matter_tools_hoe"));
	}
}
