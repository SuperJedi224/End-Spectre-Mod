package io.github.superjedi224.end_spectre.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntitySpectreFireball extends EntityFireballBase
{
    public EntitySpectreFireball(World worldIn)
    {
        super(worldIn);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntitySpectreFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ)
    {
        super(worldIn, shooter, accelX, accelY, accelZ);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntitySpectreFireball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ)
    {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
        this.setSize(0.3125F, 0.3125F);
    }

    public static void registerFixesSmallFireball(DataFixer fixer)
    {
        EntityFireball.registerFixesFireball(fixer, "SmallFireball");
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {
            if (result.entityHit != null && (result.entityHit instanceof EntityLivingBase) &&! (result.entityHit instanceof EntitySpectre))
            {
                EntityLivingBase hit=(EntityLivingBase) result.entityHit; 
            	hit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this,this.shootingEntity), 7.0F);
                Vec3d pos=hit.getPositionVector();
                if(hit.attemptTeleport(shootingEntity.posX, shootingEntity.posY+1+this.rand.nextInt(4), shootingEntity.posZ)&&shootingEntity.attemptTeleport(pos.x,pos.y,pos.z)){
                	shootingEntity.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT,1.0f,1.0f);
                    hit.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT,1.0f,1.0f);
                }                
            }
            this.setDead();
        }
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return false;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return false;
    }
}
