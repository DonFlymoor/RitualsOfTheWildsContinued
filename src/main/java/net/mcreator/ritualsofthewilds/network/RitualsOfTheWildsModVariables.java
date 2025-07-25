package net.mcreator.ritualsofthewilds.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RitualsOfTheWildsModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		RitualsOfTheWildsMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.RitualChecks = original.RitualChecks;
			clone.entitycheckinginscroll = original.entitycheckinginscroll;
			clone.sacrificesmadetoshow = original.sacrificesmadetoshow;
			clone.entity_checkup = original.entity_checkup;
			clone.talking_to = original.talking_to;
			clone.talking_to_id = original.talking_to_id;
			clone.FirstLineText = original.FirstLineText;
			clone.SecondLineText = original.SecondLineText;
			clone.ThirdLineText = original.ThirdLineText;
			clone.FourthLineText = original.FourthLineText;
			clone.FifthLineText = original.FifthLineText;
			clone.SixthLineText = original.SixthLineText;
			clone.SeventhLineText = original.SeventhLineText;
			clone.EightLineText = original.EightLineText;
			clone.NineLineText = original.NineLineText;
			clone.TenthLineText = original.TenthLineText;
			clone.FirstAnswear = original.FirstAnswear;
			clone.SecondAnswear = original.SecondAnswear;
			clone.ThirdAnswear = original.ThirdAnswear;
			clone.FourthAnswear = original.FourthAnswear;
			clone.filename = original.filename;
			clone.showquests = original.showquests;
			clone.quest_name = original.quest_name;
			clone.questshowing = original.questshowing;
			clone.firstquesttextline = original.firstquesttextline;
			clone.secondquesttextline = original.secondquesttextline;
			clone.thirdquesttextline = original.thirdquesttextline;
			clone.fourthquesttextline = original.fourthquesttextline;
			clone.fifthquesttextline = original.fifthquesttextline;
			clone.firstquestgivenby = original.firstquestgivenby;
			clone.secondquestgivenby = original.secondquestgivenby;
			clone.thirdquestgivenby = original.thirdquestgivenby;
			clone.fourthquestgivenby = original.fourthquestgivenby;
			clone.fifthquestgivenby = original.fifthquestgivenby;
			clone.talking_to_uuid = original.talking_to_uuid;
			clone.firstquestid = original.firstquestid;
			clone.secondquestid = original.secondquestid;
			clone.thirdquestid = original.thirdquestid;
			clone.fourthquestid = original.fourthquestid;
			clone.fifthquestid = original.fifthquestid;
			clone.languagesetted = original.languagesetted;
			clone.questsalreadydone = original.questsalreadydone;
			clone.showupperblock = original.showupperblock;
			clone.showlowerblock = original.showlowerblock;
			clone.previousquestgiver1 = original.previousquestgiver1;
			clone.previousquestgiver2 = original.previousquestgiver2;
			clone.previousquestgiver3 = original.previousquestgiver3;
			clone.previousquestgiver4 = original.previousquestgiver4;
			clone.previousquestgiver5 = original.previousquestgiver5;
			clone.originalquestgiver1 = original.originalquestgiver1;
			clone.originalquestgiver2 = original.originalquestgiver2;
			clone.originalquestgiver3 = original.originalquestgiver3;
			clone.originalquestgiver4 = original.originalquestgiver4;
			clone.originalquestgiver5 = original.originalquestgiver5;
			clone.killcountingquest1 = original.killcountingquest1;
			clone.killcountingquest2 = original.killcountingquest2;
			clone.killcountingquest3 = original.killcountingquest3;
			clone.killcountingquest4 = original.killcountingquest4;
			clone.killcountingquest5 = original.killcountingquest5;
			clone.whokillquest1 = original.whokillquest1;
			clone.whokillquest2 = original.whokillquest2;
			clone.whokillquest3 = original.whokillquest3;
			clone.whokillquest4 = original.whokillquest4;
			clone.whokillquest5 = original.whokillquest5;
			clone.killcountleft1 = original.killcountleft1;
			clone.killstoshow = original.killstoshow;
			clone.ritualsseen = original.ritualsseen;
			clone.alchemyscrollsseen = original.alchemyscrollsseen;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("rituals_of_the_wilds", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double RitualChecks = 1.0;
		public String entitycheckinginscroll = "\"\"";
		public double sacrificesmadetoshow = 0;
		public double entity_checkup = 0;
		public String talking_to = "\"\"";
		public String talking_to_id = "\"\"";
		public String FirstLineText = "\"\"";
		public String SecondLineText = "\"\"";
		public String ThirdLineText = "\"\"";
		public String FourthLineText = "\"\"";
		public String FifthLineText = "\"\"";
		public String SixthLineText = "\"\"";
		public String SeventhLineText = "\"\"";
		public String EightLineText = "\"\"";
		public String NineLineText = "\"\"";
		public String TenthLineText = "\"\"";
		public String FirstAnswear = "\"\"";
		public String SecondAnswear = "\"\"";
		public String ThirdAnswear = "\"\"";
		public String FourthAnswear = "\"\"";
		public String filename = "\"\"";
		public boolean showquests = false;
		public String quest_name = "\"\"";
		public double questshowing = 0;
		public String firstquesttextline = "\"\"";
		public String secondquesttextline = "\"\"";
		public String thirdquesttextline = "\"\"";
		public String fourthquesttextline = "\"\"";
		public String fifthquesttextline = "\"\"";
		public String firstquestgivenby = "\"\"";
		public String secondquestgivenby = "\"\"";
		public String thirdquestgivenby = "\"\"";
		public String fourthquestgivenby = "\"\"";
		public String fifthquestgivenby = "\"\"";
		public String talking_to_uuid = "\"\"";
		public String firstquestid = "\"\"";
		public String secondquestid = "\"\"";
		public String thirdquestid = "\"\"";
		public String fourthquestid = "\"\"";
		public String fifthquestid = "\"\"";
		public String languagesetted = "\"eng\"";
		public String questsalreadydone = "\"\"";
		public boolean showupperblock = false;
		public boolean showlowerblock = false;
		public String previousquestgiver1 = "\"\"";
		public String previousquestgiver2 = "\"\"";
		public String previousquestgiver3 = "\"\"";
		public String previousquestgiver4 = "\"\"";
		public String previousquestgiver5 = "\"\"";
		public String originalquestgiver1 = "\"\"";
		public String originalquestgiver2 = "\"\"";
		public String originalquestgiver3 = "\"\"";
		public String originalquestgiver4 = "\"\"";
		public String originalquestgiver5 = "\"\"";
		public double killcountingquest1 = 0;
		public double killcountingquest2 = 0;
		public double killcountingquest3 = 0;
		public double killcountingquest4 = 0;
		public double killcountingquest5 = 0;
		public String whokillquest1 = "\"\"";
		public String whokillquest2 = "\"\"";
		public String whokillquest3 = "\"\"";
		public String whokillquest4 = "\"\"";
		public String whokillquest5 = "\"\"";
		public double killcountleft1 = 0;
		public double killstoshow = 0;
		public String ritualsseen = "\"\"";
		public String alchemyscrollsseen = "\"\"";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				RitualsOfTheWildsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("RitualChecks", RitualChecks);
			nbt.putString("entitycheckinginscroll", entitycheckinginscroll);
			nbt.putDouble("sacrificesmadetoshow", sacrificesmadetoshow);
			nbt.putDouble("entity_checkup", entity_checkup);
			nbt.putString("talking_to", talking_to);
			nbt.putString("talking_to_id", talking_to_id);
			nbt.putString("FirstLineText", FirstLineText);
			nbt.putString("SecondLineText", SecondLineText);
			nbt.putString("ThirdLineText", ThirdLineText);
			nbt.putString("FourthLineText", FourthLineText);
			nbt.putString("FifthLineText", FifthLineText);
			nbt.putString("SixthLineText", SixthLineText);
			nbt.putString("SeventhLineText", SeventhLineText);
			nbt.putString("EightLineText", EightLineText);
			nbt.putString("NineLineText", NineLineText);
			nbt.putString("TenthLineText", TenthLineText);
			nbt.putString("FirstAnswear", FirstAnswear);
			nbt.putString("SecondAnswear", SecondAnswear);
			nbt.putString("ThirdAnswear", ThirdAnswear);
			nbt.putString("FourthAnswear", FourthAnswear);
			nbt.putString("filename", filename);
			nbt.putBoolean("showquests", showquests);
			nbt.putString("quest_name", quest_name);
			nbt.putDouble("questshowing", questshowing);
			nbt.putString("firstquesttextline", firstquesttextline);
			nbt.putString("secondquesttextline", secondquesttextline);
			nbt.putString("thirdquesttextline", thirdquesttextline);
			nbt.putString("fourthquesttextline", fourthquesttextline);
			nbt.putString("fifthquesttextline", fifthquesttextline);
			nbt.putString("firstquestgivenby", firstquestgivenby);
			nbt.putString("secondquestgivenby", secondquestgivenby);
			nbt.putString("thirdquestgivenby", thirdquestgivenby);
			nbt.putString("fourthquestgivenby", fourthquestgivenby);
			nbt.putString("fifthquestgivenby", fifthquestgivenby);
			nbt.putString("talking_to_uuid", talking_to_uuid);
			nbt.putString("firstquestid", firstquestid);
			nbt.putString("secondquestid", secondquestid);
			nbt.putString("thirdquestid", thirdquestid);
			nbt.putString("fourthquestid", fourthquestid);
			nbt.putString("fifthquestid", fifthquestid);
			nbt.putString("languagesetted", languagesetted);
			nbt.putString("questsalreadydone", questsalreadydone);
			nbt.putBoolean("showupperblock", showupperblock);
			nbt.putBoolean("showlowerblock", showlowerblock);
			nbt.putString("previousquestgiver1", previousquestgiver1);
			nbt.putString("previousquestgiver2", previousquestgiver2);
			nbt.putString("previousquestgiver3", previousquestgiver3);
			nbt.putString("previousquestgiver4", previousquestgiver4);
			nbt.putString("previousquestgiver5", previousquestgiver5);
			nbt.putString("originalquestgiver1", originalquestgiver1);
			nbt.putString("originalquestgiver2", originalquestgiver2);
			nbt.putString("originalquestgiver3", originalquestgiver3);
			nbt.putString("originalquestgiver4", originalquestgiver4);
			nbt.putString("originalquestgiver5", originalquestgiver5);
			nbt.putDouble("killcountingquest1", killcountingquest1);
			nbt.putDouble("killcountingquest2", killcountingquest2);
			nbt.putDouble("killcountingquest3", killcountingquest3);
			nbt.putDouble("killcountingquest4", killcountingquest4);
			nbt.putDouble("killcountingquest5", killcountingquest5);
			nbt.putString("whokillquest1", whokillquest1);
			nbt.putString("whokillquest2", whokillquest2);
			nbt.putString("whokillquest3", whokillquest3);
			nbt.putString("whokillquest4", whokillquest4);
			nbt.putString("whokillquest5", whokillquest5);
			nbt.putDouble("killcountleft1", killcountleft1);
			nbt.putDouble("killstoshow", killstoshow);
			nbt.putString("ritualsseen", ritualsseen);
			nbt.putString("alchemyscrollsseen", alchemyscrollsseen);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			RitualChecks = nbt.getDouble("RitualChecks");
			entitycheckinginscroll = nbt.getString("entitycheckinginscroll");
			sacrificesmadetoshow = nbt.getDouble("sacrificesmadetoshow");
			entity_checkup = nbt.getDouble("entity_checkup");
			talking_to = nbt.getString("talking_to");
			talking_to_id = nbt.getString("talking_to_id");
			FirstLineText = nbt.getString("FirstLineText");
			SecondLineText = nbt.getString("SecondLineText");
			ThirdLineText = nbt.getString("ThirdLineText");
			FourthLineText = nbt.getString("FourthLineText");
			FifthLineText = nbt.getString("FifthLineText");
			SixthLineText = nbt.getString("SixthLineText");
			SeventhLineText = nbt.getString("SeventhLineText");
			EightLineText = nbt.getString("EightLineText");
			NineLineText = nbt.getString("NineLineText");
			TenthLineText = nbt.getString("TenthLineText");
			FirstAnswear = nbt.getString("FirstAnswear");
			SecondAnswear = nbt.getString("SecondAnswear");
			ThirdAnswear = nbt.getString("ThirdAnswear");
			FourthAnswear = nbt.getString("FourthAnswear");
			filename = nbt.getString("filename");
			showquests = nbt.getBoolean("showquests");
			quest_name = nbt.getString("quest_name");
			questshowing = nbt.getDouble("questshowing");
			firstquesttextline = nbt.getString("firstquesttextline");
			secondquesttextline = nbt.getString("secondquesttextline");
			thirdquesttextline = nbt.getString("thirdquesttextline");
			fourthquesttextline = nbt.getString("fourthquesttextline");
			fifthquesttextline = nbt.getString("fifthquesttextline");
			firstquestgivenby = nbt.getString("firstquestgivenby");
			secondquestgivenby = nbt.getString("secondquestgivenby");
			thirdquestgivenby = nbt.getString("thirdquestgivenby");
			fourthquestgivenby = nbt.getString("fourthquestgivenby");
			fifthquestgivenby = nbt.getString("fifthquestgivenby");
			talking_to_uuid = nbt.getString("talking_to_uuid");
			firstquestid = nbt.getString("firstquestid");
			secondquestid = nbt.getString("secondquestid");
			thirdquestid = nbt.getString("thirdquestid");
			fourthquestid = nbt.getString("fourthquestid");
			fifthquestid = nbt.getString("fifthquestid");
			languagesetted = nbt.getString("languagesetted");
			questsalreadydone = nbt.getString("questsalreadydone");
			showupperblock = nbt.getBoolean("showupperblock");
			showlowerblock = nbt.getBoolean("showlowerblock");
			previousquestgiver1 = nbt.getString("previousquestgiver1");
			previousquestgiver2 = nbt.getString("previousquestgiver2");
			previousquestgiver3 = nbt.getString("previousquestgiver3");
			previousquestgiver4 = nbt.getString("previousquestgiver4");
			previousquestgiver5 = nbt.getString("previousquestgiver5");
			originalquestgiver1 = nbt.getString("originalquestgiver1");
			originalquestgiver2 = nbt.getString("originalquestgiver2");
			originalquestgiver3 = nbt.getString("originalquestgiver3");
			originalquestgiver4 = nbt.getString("originalquestgiver4");
			originalquestgiver5 = nbt.getString("originalquestgiver5");
			killcountingquest1 = nbt.getDouble("killcountingquest1");
			killcountingquest2 = nbt.getDouble("killcountingquest2");
			killcountingquest3 = nbt.getDouble("killcountingquest3");
			killcountingquest4 = nbt.getDouble("killcountingquest4");
			killcountingquest5 = nbt.getDouble("killcountingquest5");
			whokillquest1 = nbt.getString("whokillquest1");
			whokillquest2 = nbt.getString("whokillquest2");
			whokillquest3 = nbt.getString("whokillquest3");
			whokillquest4 = nbt.getString("whokillquest4");
			whokillquest5 = nbt.getString("whokillquest5");
			killcountleft1 = nbt.getDouble("killcountleft1");
			killstoshow = nbt.getDouble("killstoshow");
			ritualsseen = nbt.getString("ritualsseen");
			alchemyscrollsseen = nbt.getString("alchemyscrollsseen");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.RitualChecks = message.data.RitualChecks;
					variables.entitycheckinginscroll = message.data.entitycheckinginscroll;
					variables.sacrificesmadetoshow = message.data.sacrificesmadetoshow;
					variables.entity_checkup = message.data.entity_checkup;
					variables.talking_to = message.data.talking_to;
					variables.talking_to_id = message.data.talking_to_id;
					variables.FirstLineText = message.data.FirstLineText;
					variables.SecondLineText = message.data.SecondLineText;
					variables.ThirdLineText = message.data.ThirdLineText;
					variables.FourthLineText = message.data.FourthLineText;
					variables.FifthLineText = message.data.FifthLineText;
					variables.SixthLineText = message.data.SixthLineText;
					variables.SeventhLineText = message.data.SeventhLineText;
					variables.EightLineText = message.data.EightLineText;
					variables.NineLineText = message.data.NineLineText;
					variables.TenthLineText = message.data.TenthLineText;
					variables.FirstAnswear = message.data.FirstAnswear;
					variables.SecondAnswear = message.data.SecondAnswear;
					variables.ThirdAnswear = message.data.ThirdAnswear;
					variables.FourthAnswear = message.data.FourthAnswear;
					variables.filename = message.data.filename;
					variables.showquests = message.data.showquests;
					variables.quest_name = message.data.quest_name;
					variables.questshowing = message.data.questshowing;
					variables.firstquesttextline = message.data.firstquesttextline;
					variables.secondquesttextline = message.data.secondquesttextline;
					variables.thirdquesttextline = message.data.thirdquesttextline;
					variables.fourthquesttextline = message.data.fourthquesttextline;
					variables.fifthquesttextline = message.data.fifthquesttextline;
					variables.firstquestgivenby = message.data.firstquestgivenby;
					variables.secondquestgivenby = message.data.secondquestgivenby;
					variables.thirdquestgivenby = message.data.thirdquestgivenby;
					variables.fourthquestgivenby = message.data.fourthquestgivenby;
					variables.fifthquestgivenby = message.data.fifthquestgivenby;
					variables.talking_to_uuid = message.data.talking_to_uuid;
					variables.firstquestid = message.data.firstquestid;
					variables.secondquestid = message.data.secondquestid;
					variables.thirdquestid = message.data.thirdquestid;
					variables.fourthquestid = message.data.fourthquestid;
					variables.fifthquestid = message.data.fifthquestid;
					variables.languagesetted = message.data.languagesetted;
					variables.questsalreadydone = message.data.questsalreadydone;
					variables.showupperblock = message.data.showupperblock;
					variables.showlowerblock = message.data.showlowerblock;
					variables.previousquestgiver1 = message.data.previousquestgiver1;
					variables.previousquestgiver2 = message.data.previousquestgiver2;
					variables.previousquestgiver3 = message.data.previousquestgiver3;
					variables.previousquestgiver4 = message.data.previousquestgiver4;
					variables.previousquestgiver5 = message.data.previousquestgiver5;
					variables.originalquestgiver1 = message.data.originalquestgiver1;
					variables.originalquestgiver2 = message.data.originalquestgiver2;
					variables.originalquestgiver3 = message.data.originalquestgiver3;
					variables.originalquestgiver4 = message.data.originalquestgiver4;
					variables.originalquestgiver5 = message.data.originalquestgiver5;
					variables.killcountingquest1 = message.data.killcountingquest1;
					variables.killcountingquest2 = message.data.killcountingquest2;
					variables.killcountingquest3 = message.data.killcountingquest3;
					variables.killcountingquest4 = message.data.killcountingquest4;
					variables.killcountingquest5 = message.data.killcountingquest5;
					variables.whokillquest1 = message.data.whokillquest1;
					variables.whokillquest2 = message.data.whokillquest2;
					variables.whokillquest3 = message.data.whokillquest3;
					variables.whokillquest4 = message.data.whokillquest4;
					variables.whokillquest5 = message.data.whokillquest5;
					variables.killcountleft1 = message.data.killcountleft1;
					variables.killstoshow = message.data.killstoshow;
					variables.ritualsseen = message.data.ritualsseen;
					variables.alchemyscrollsseen = message.data.alchemyscrollsseen;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
