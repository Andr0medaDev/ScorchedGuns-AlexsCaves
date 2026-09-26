package top.andro.scguns_alexscaves.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MagicImpactParticle extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected MagicImpactParticle(ClientLevel pLevel, double pX, double pY, double pZ,
                                  SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pQuadSizeMultiplier) {
        super(pLevel, pX, pY, pZ, 0.0, 0.0, 0.0);
        this.lifetime = 5;
        this.quadSize = 0.2F * (0.1F - (float)pQuadSizeMultiplier * 0.5F);
        this.sprites = spriteSet;
        //this.roll += 0.1;
        this.setSpriteFromAge(spriteSet);
        this.xd = 0.0;
        this.yd = 0.0;
        this.zd = 0.0;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
        //this.oRoll = this.roll;
        //this.roll += 0.15F;

        this.xd = 0.0;
        this.yd = 0.0;
        this.zd = 0.0;

        float lifeRatio = (float)this.age / (float)this.lifetime;
        if (lifeRatio < 0.5) {
            this.quadSize = 0.5F + 0.5F * lifeRatio;
        } else {
            this.quadSize = 0.5F + 0.5F * (1.0F - lifeRatio);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            MagicImpactParticle particle = new MagicImpactParticle(pLevel, pX, pY, pZ, this.spriteSet, pXSpeed, pYSpeed, pZSpeed);
            particle.setLifetime(5);
            return particle;
        }
    }
}
