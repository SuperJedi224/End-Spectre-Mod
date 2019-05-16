package io.github.superjedi224.end_spectre.proxy;

import io.github.superjedi224.end_spectre.entity.EntitySpectre;
import io.github.superjedi224.end_spectre.entity.EntitySpectreFireball;
import io.github.superjedi224.end_spectre.entity.render.RenderSpectre;
import io.github.superjedi224.end_spectre.entity.render.RenderSpectreFireball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	public void preInit(){
		super.preInit();
		RenderingRegistry.registerEntityRenderingHandler(EntitySpectre.class,new RenderSpectre.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntitySpectreFireball.class,new RenderSpectreFireball.Factory());
	}
}
