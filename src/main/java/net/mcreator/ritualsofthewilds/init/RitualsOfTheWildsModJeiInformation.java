
package net.mcreator.ritualsofthewilds.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class RitualsOfTheWildsModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("rituals_of_the_wilds:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(
				List.of(new ItemStack(RitualsOfTheWildsModItems.BLOOD_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.ASH_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.BLOOM_INK_INSCRIBING_QUILL.get()),
						new ItemStack(RitualsOfTheWildsModItems.ELDRITCH_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.EMBER_INK_INSCRIBING_QUILL.get()),
						new ItemStack(RitualsOfTheWildsModItems.FROST_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.LUNAR_SAP_INK_INSCRIBING_QUILL.get()),
						new ItemStack(RitualsOfTheWildsModItems.MOONLIGHT_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.MUSHROOM_INK_INSCRIBING_QUILL.get()),
						new ItemStack(RitualsOfTheWildsModItems.PALE_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.ROOT_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.ROT_INK_INSCRIBING_QUILL.get()),
						new ItemStack(RitualsOfTheWildsModItems.SHADOW_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.SPIRIT_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.STORM_INK_INSCRIBING_QUILL.get()),
						new ItemStack(RitualsOfTheWildsModItems.TIDE_INK_INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.INSCRIBING_QUILL.get()), new ItemStack(RitualsOfTheWildsModItems.BLOOD_INK_BOTTLE.get()),
						new ItemStack(RitualsOfTheWildsModItems.ASH_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.BLOOM_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.ELDRITCH_INK_BOTTLE.get()),
						new ItemStack(RitualsOfTheWildsModItems.EMBER_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.FROST_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.LUNAR_SAP_INK_BOTTLE.get()),
						new ItemStack(RitualsOfTheWildsModItems.MOONLIGHT_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.MUSHROOM_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.PALE_INK_BOTTLE.get()),
						new ItemStack(RitualsOfTheWildsModItems.ROOT_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.ROT_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.SHADOW_INK_BOTTLE.get()),
						new ItemStack(RitualsOfTheWildsModItems.SPIRIT_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.STORM_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.TIDE_INK_BOTTLE.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.rituals_of_the_wilds.quill_fill"));
		registration.addIngredientInfo(List.of(new ItemStack(RitualsOfTheWildsModItems.ELDRITCH_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.STORM_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.SHADOW_INK_BOTTLE.get()),
				new ItemStack(RitualsOfTheWildsModItems.MOONLIGHT_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.PALE_INK_BOTTLE.get()), new ItemStack(RitualsOfTheWildsModItems.FROST_MOSS.get()),
				new ItemStack(RitualsOfTheWildsModItems.MOONPETAL.get()), new ItemStack(RitualsOfTheWildsModItems.AETHER_BLOB.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.rituals_of_the_wilds.made_with_rituals"));
		registration.addIngredientInfo(List.of(new ItemStack(RitualsOfTheWildsModBlocks.STRAW_HAT.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.rituals_of_the_wilds.straw_hat_info"));
		registration.addIngredientInfo(List.of(new ItemStack(RitualsOfTheWildsModItems.BLOOD_FERN.get()), new ItemStack(RitualsOfTheWildsModItems.ETHERGRASS.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.rituals_of_the_wilds.can_be_found_in_nether"));
		registration.addIngredientInfo(List.of(new ItemStack(RitualsOfTheWildsModItems.DREAM_VINE.get()), new ItemStack(RitualsOfTheWildsModItems.MISTCAP_MUSHROOM.get()), new ItemStack(RitualsOfTheWildsModItems.VOIDROOT.get()),
				new ItemStack(RitualsOfTheWildsModItems.SPIRITBLOOM.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.rituals_of_the_wilds.can_be_found_in_dark_forest"));
		registration.addIngredientInfo(List.of(new ItemStack(RitualsOfTheWildsModItems.EMBER_LEAF_BERRY.get()), new ItemStack(RitualsOfTheWildsModItems.SUNS_TEAR.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.rituals_of_the_wilds.can_be_found_in_desert"));
		registration.addIngredientInfo(List.of(new ItemStack(RitualsOfTheWildsModItems.THORNBLOOM.get()), new ItemStack(RitualsOfTheWildsModItems.WITCHTHORN.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.rituals_of_the_wilds.can_be_found_on_swamps"));
		registration.addIngredientInfo(List.of(new ItemStack(RitualsOfTheWildsModItems.RITUAL_SCROLL.get()), new ItemStack(RitualsOfTheWildsModItems.ALCHEMY_SCROLL.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.rituals_of_the_wilds.can_be_found_in_forgoten_alchemy_houses"));
		registration.addIngredientInfo(List.of(new ItemStack(RitualsOfTheWildsModItems.UMBRAL_GEODE.get()), new ItemStack(RitualsOfTheWildsModItems.WHITE_CRYSTAL_SHARD.get()), new ItemStack(RitualsOfTheWildsModItems.INSCRIBING_QUILL.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.rituals_of_the_wilds.can_be_made_with_alchemy_cauldron"));
		registration.addIngredientInfo(List.of(new ItemStack(RitualsOfTheWildsModItems.DANCE_OF_THE_BEAR.get()), new ItemStack(RitualsOfTheWildsModItems.NULL_HEART.get()), new ItemStack(RitualsOfTheWildsModItems.FROM_WAR_TO_LIFE.get()),
				new ItemStack(RitualsOfTheWildsModItems.OLD_CERAMIC_POT.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.rituals_of_the_wilds.can_be_found_around_the_world"));
	}
}
