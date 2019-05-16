package io.github.superjedi224.end_spectre;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import io.github.superjedi224.end_spectre.proxy.CommonProxy;

@Mod(modid = EnderMod.MODID, name = EnderMod.NAME, version = EnderMod.VERSION, acceptedMinecraftVersions = "[1.12,1.13)")
public class EnderMod
{
    public static final String MODID = "end_spectre";
    public static final String NAME = "Ender Spectres";
    public static final String VERSION = "1.0";
    
    public static EnderMod instance;

    @SidedProxy(clientSide = "io.github.superjedi224.end_spectre.proxy.ClientProxy", serverSide = "io.github.superjedi224.end_spectre.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	instance=this;
        LootTableList.register(new ResourceLocation(MODID,"entities/ender_spectre"));
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit();
    }
}
