package net.mcreator.ritualsofthewilds.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class RitualsOfTheWildsConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ALCHEMYCAULDRONRECIPESREGEN;
	public static final ForgeConfigSpec.ConfigValue<Boolean> AUTOREGENINGREDIENTSTAB;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DRYINGRACKRECIPESREGEN;
	public static final ForgeConfigSpec.ConfigValue<Boolean> MORTARANDPESTLERECIPESREGENERATE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CATALYSTGRINDERRECIPESREGENERATE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISTILATIONFLASKRECIPESREGENERATE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> RUNESCRIBERTABLERECIPESREGENERATE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> FUMEEXTRACTORRECIPESREGENERATE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> RITUALRECIPESREGENERATE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> AUTOREGENJARTAB;
	public static final ForgeConfigSpec.ConfigValue<Double> DRYINGTIME;
	public static final ForgeConfigSpec.ConfigValue<Double> TIMESACRIFICESLEFT;
	public static final ForgeConfigSpec.ConfigValue<Boolean> AUTOREGENDIALOGUES;
	public static final ForgeConfigSpec.ConfigValue<Boolean> AUTOREGENQUESTS;
	static {
		BUILDER.push("Recipes AutoRegen");
		ALCHEMYCAULDRONRECIPESREGEN = BUILDER.comment("Regenerates all mod recipes in alchemy cauldron(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Auto Regenerate Alchemy Cauldron recipes",
				true);
		AUTOREGENINGREDIENTSTAB = BUILDER
				.comment("Regenerates all mod basic ingredients in alchemy cauldron, catalyst grinder, fume extractor, distilation flask(Turn off only if you don't need ones that's by default in mod or if you want to edit it)")
				.define("Auto Regenerate Ingredients possible to put in some blocks", true);
		DRYINGRACKRECIPESREGEN = BUILDER.comment("Regenerates all mod recipes in drying rack(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Auto Regenerate Drying Rack recipes", true);
		MORTARANDPESTLERECIPESREGENERATE = BUILDER.comment("Regenerates all mod recipes in mortar and pestle(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Regenerate Mortal and Pestle recipes",
				true);
		CATALYSTGRINDERRECIPESREGENERATE = BUILDER.comment("Regenerates all mod recipes in catalyst grinder(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Regenerate Catalyst Grinder recipes",
				true);
		DISTILATIONFLASKRECIPESREGENERATE = BUILDER.comment("Regenerates all mod recipes in distilation flask(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Regenerate Distilation Flask recipes",
				true);
		RUNESCRIBERTABLERECIPESREGENERATE = BUILDER.comment("Regenerates all mod recipes in rune scriber table(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Regenerate Rune Scriber Table recipes",
				true);
		FUMEEXTRACTORRECIPESREGENERATE = BUILDER.comment("Regenerates all mod recipes in fume extractor(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Regenerate Fume Extractor recipes", true);
		RITUALRECIPESREGENERATE = BUILDER.comment("Regenerates all mod rituals(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Regenerate Rituals", true);
		AUTOREGENJARTAB = BUILDER.comment("Regenerates all things that you can put in jars(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Regenerate Items that you can put in jars", true);
		BUILDER.pop();
		BUILDER.push("Timers");
		DRYINGTIME = BUILDER.comment("Ticks(20 ticks = 1 second) needed to dry item that's on drying rack").define("Drying Rack Time to Dry Item", (double) 4800);
		TIMESACRIFICESLEFT = BUILDER.define("Time for sacrifices to become zero", (double) 2400);
		BUILDER.pop();
		BUILDER.push("Regenerating all other stuff");
		AUTOREGENDIALOGUES = BUILDER.comment("Regenerates all basic mod dialogues that's in this mod(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Regenerate Dialogues", true);
		AUTOREGENQUESTS = BUILDER.comment("Regenerates all basic mod quests that's in this mod(Turn off only if you don't need ones that's by default in mod or if you want to edit it)").define("Regenerate Quests", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
