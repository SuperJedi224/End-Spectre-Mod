package io.github.superjedi224.end_spectre.util;

import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import io.github.superjedi224.end_spectre.EnderMod;
import io.github.superjedi224.end_spectre.entity.EntitySpectre;

public class EndSpectreSounds
{
    public static SoundEvent ENTITY_SPECTRE_AMBIENT;
    public static SoundEvent ENTITY_SPECTRE_HURT;
    public static SoundEvent ENTITY_SPECTRE_DEATH;
    public static SoundEvent ENTITY_SPECTRE_BURN;
    public static SoundEvent ENTITY_SPECTRE_SHOOT;
    
    public static void registerSounds() {
        EndSpectreSounds.ENTITY_SPECTRE_AMBIENT = create("entity.spectre.ambient");
        EndSpectreSounds.ENTITY_SPECTRE_HURT = create("entity.spectre.hurt");
        EndSpectreSounds.ENTITY_SPECTRE_DEATH = create("entity.spectre.death");
        EndSpectreSounds.ENTITY_SPECTRE_BURN = create("entity.spectre.burn");
        EndSpectreSounds.ENTITY_SPECTRE_SHOOT = create("entity.spectre.shoot");
    }
    
    private static SoundEvent create(final String s) {
        final ResourceLocation name = new ResourceLocation(EnderMod.MODID, s);
        final SoundEvent sound = (SoundEvent)new SoundEvent(name).setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register((SoundEvent)sound);
        return sound;
    }
}