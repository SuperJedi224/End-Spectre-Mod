package io.github.superjedi224.end_spectre.proxy;

import io.github.superjedi224.end_spectre.EnderMod;
import io.github.superjedi224.end_spectre.entity.EntitySpectre;
import io.github.superjedi224.end_spectre.entity.EntitySpectreFireball;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {
	public void preInit(){
		int id=0;
		EntityRegistry.registerModEntity(new ResourceLocation(EnderMod.MODID,"end_spectre"), EntitySpectre.class,"end_spectre", id++,EnderMod.instance,64, 3,true,0xAAAABB,0x88BBBB);
		EntityRegistry.registerModEntity(new ResourceLocation(EnderMod.MODID,"end_spectre_fireball"), EntitySpectreFireball.class,"end_spectre_fireball", id++,EnderMod.instance,64,3,true);
		EntityRegistry.addSpawn(EntitySpectre.class,2,1,3,EnumCreatureType.MONSTER,new Biome[]{Biome.getBiome(9)});
	}
	public void init(){
		
	}
	public void postInit(){
	
	}

}
