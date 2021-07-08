
package net.mcreator.antimatter.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.antimatter.itemgroup.AntiMatterModItemGroup;
import net.mcreator.antimatter.AntimatterModElements;

import java.util.List;

@AntimatterModElements.ModElement.Tag
public class AntiMatterToolsPickaxeItem extends AntimatterModElements.ModElement {
	@ObjectHolder("antimatter:anti_matter_tools_pickaxe")
	public static final Item block = null;
	public AntiMatterToolsPickaxeItem(AntimatterModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
				return 10;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AntiMatterIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(AntiMatterModItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("The pickaxe pulses with raw power..."));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("anti_matter_tools_pickaxe"));
	}
}
