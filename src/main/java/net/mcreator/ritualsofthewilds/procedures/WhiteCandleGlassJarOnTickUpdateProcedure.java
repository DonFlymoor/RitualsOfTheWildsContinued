package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class WhiteCandleGlassJarOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() <= 0.3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMALL_FLAME, (x + 0.5), (y + 0.75), (z + 0.5), 1, 0.01, 0.01, 0.01, 0);
		}
	}
}
