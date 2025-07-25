package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.mcreator.ritualsofthewilds.configuration.RitualsOfTheWildsConfigConfiguration;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

@Mod.EventBusSubscriber
public class GenerataDialogue26Procedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		if (RitualsOfTheWildsConfigConfiguration.AUTOREGENDIALOGUES.get() == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/eng"), File.separator + "rituals_of_the_wilds_chernobog_26.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("First dialogue Based with reputation", false);
			object.addProperty("Bad Reputation", 0);
			object.addProperty("Neutral Reputation", 0);
			object.addProperty("Normal Reputation", 0);
			object.addProperty("Good Reputation", 0);
			object.addProperty("High Reputation", 0);
			object.addProperty("Text Line", "The tribute is received. Now choose. What truth do you seek, and what will it unmake in you?");
			object.addProperty("First Answer Text Line", "\u300B Tell me about the world\u2019s breaking \u2014 the old scars in the land.");
			object.addProperty("First Answer Quest Requirement", "chernobog_color_dust_give");
			object.addProperty("First Answer Quest Requirement State", 0);
			object.addProperty("First Answer Result Dialogue Number", 0);
			object.addProperty("First Answer Result Command",
					"tellraw @s \"<Chernobog> The world was never whole. It was born torn \u2014 split by will and weight the moment we were shaped. Not created by love, no \u2014 forged by a thing greater than understanding. The Architect. The Nameless One. It made us to wrestle, not to rest. And so we did. Every god, every force, an echo of that first fracture. The lands bleed because we breathe. The void seeps because I exist. The cracks you see are not wounds \u2014 they are veins, pulsing with purpose you were never meant to comprehend.\"");
			object.addProperty("First Answer Result Quest Give ID", "");
			object.addProperty("First Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("First Answer Sound", "");
			object.addProperty("Second Answer Text Line", "\u300B Whisper to me of the forgotten gods \u2014 those who came before.");
			object.addProperty("Second Answer Quest Requirement", "chernobog_tied_dried_voidroot_give");
			object.addProperty("Second Answer Quest Requirement State", 0);
			object.addProperty("Second Answer Result Dialogue Number", 0);
			object.addProperty("Second Answer Result Command",
					"tellraw @s \"<Chernobog> There were many. Some still slumber, others scream beneath mountains. They were not good. They were not bad. They were true. Leshy was among them \u2014 old as breath. Once a god of resistance, now just a whisper in leaves. He traded the shape of a god for bark and bone, to hide in the soil he loved. Even now, forests feed him. Each uncut tree a prayer. Each burned grove a wound. He slows rot. I spread it. And still, we were both born from the same breath. You name us gods. We were never that. We are... instruments. Instruments with teeth.\"");
			object.addProperty("Second Answer Result Quest Give ID", "");
			object.addProperty("Second Answer Sound", "");
			object.addProperty("Second Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("Third Answer Text Line", "\u300B I want power. Forbidden, if needed.");
			object.addProperty("Third Answer Quest Requirement", "chernobog_storm_ink_bottle_give");
			object.addProperty("Third Answer Quest Requirement State", 0);
			object.addProperty("Third Answer Result Dialogue Number", 27);
			object.addProperty("Third Answer Result Command", "");
			object.addProperty("Third Answer Result Quest Give ID", "");
			object.addProperty("Third Answer Sound", "");
			object.addProperty("Third Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("Fourth Answer Text Line", "\u300B What do you want, Chernobog?");
			object.addProperty("Fourth Answer Quest Requirement", "chernobog_moonlight_ink_bottle_give");
			object.addProperty("Fourth Answer Quest Requirement State", 0);
			object.addProperty("Fourth Answer Result Dialogue Number", 0);
			object.addProperty("Fourth Answer Result Command",
					"tellraw @s \"<Chernobog> Ah... the question that dares. What does a storm want? What does rust seek? I was made to unravel. To peel back the lies of creation. I am entropy with a name. And yet... I wonder. If Leshy can change \u2014 if roots can remember \u2014 can I? What I want is to be seen. Not as evil. Not as feared. But as a truth that no longer has to scream through dying worlds to be heard.\"");
			object.addProperty("Fourth Answer Result Quest Give ID", "");
			object.addProperty("Fourth Answer Sound", "");
			object.addProperty("Fourth Answer Result Command Player, World or Entity Executed", 0);
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(object));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
