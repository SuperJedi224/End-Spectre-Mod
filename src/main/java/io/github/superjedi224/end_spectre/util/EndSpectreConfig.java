package io.github.superjedi224.end_spectre.util;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import io.github.superjedi224.end_spectre.EnderMod;
import io.github.superjedi224.end_spectre.entity.EntitySpectre;

import static net.minecraftforge.common.config.Config.*;

@Config(modid = EnderMod.MODID, name = EnderMod.MODID, category = "")
public final class EndSpectreConfig {

    public static Spawn spawn = new Spawn();
    public static Stats stats = new Stats();

    public static class Spawn {
        @Name("spawnWeight")
        @LangKey("end_spectre.config.spawn.spawnWeight")
        @RangeInt(min = 0)
        public int spawnWeight = 2;
        
        @Name("minSpawnCount")
        @LangKey("end_spectre.config.spawn.minSpawnCount")
        @RangeInt(min = 0)
        public int minSpawnCount = 1;

        @Name("maxSpawnCount")
        @LangKey("end_spectre.config.spawn.maxSpawnCount")
        @RangeInt(min = 0)
        public int maxSpawnCount = 3;
    }
    
    public static class Stats {
        @Name("isImmuneToFire")
        @LangKey("end_spectre.config.stats.isImmuneToFire")
        public boolean isImmuneToFire = true;

        @Name("experienceValue")
        @LangKey("end_spectre.config.stats.experienceValue")
        @RangeInt(min = 0)
        public int experienceValue = 10;

        @Name("attackDamage")
        @LangKey("end_spectre.config.stats.attackDamage")
        @RangeDouble(min = 0)
        public double attackDamage = 6.0;

        @Name("movementSpeed")
        @LangKey("end_spectre.config.stats.movementSpeed")
        @RangeDouble(min = 0)
        public double movementSpeed = 0.24;

        @Name("followRange")
        @LangKey("end_spectre.config.stats.followRange")
        @RangeDouble(min = 0)
        public double followRange = 48.0;
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(EnderMod.MODID)) {
            ConfigManager.sync(event.getModID(), Type.INSTANCE); // Sync config values
        }
    }
}