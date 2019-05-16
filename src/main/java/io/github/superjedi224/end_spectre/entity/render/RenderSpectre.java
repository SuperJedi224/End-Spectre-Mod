package io.github.superjedi224.end_spectre.entity.render;

import io.github.superjedi224.end_spectre.EnderMod;
import io.github.superjedi224.end_spectre.entity.EntitySpectre;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSpectre extends RenderLiving<EntitySpectre>
{
    private static final ResourceLocation BLAZE_TEXTURES = new ResourceLocation(EnderMod.MODID,"textures/entity/spectre.png");

    public RenderSpectre(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBlaze(), 0.5F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySpectre entity)
    {
        return BLAZE_TEXTURES;
    }
    
    public static final class Factory implements IRenderFactory<EntitySpectre>{

		@Override
		public Render<? super EntitySpectre> createRenderFor(RenderManager manager) {
			return new RenderSpectre(manager);
		}
    	
    }
}