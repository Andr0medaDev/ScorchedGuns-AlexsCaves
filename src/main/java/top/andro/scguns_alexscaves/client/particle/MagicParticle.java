package top.andro.scguns_alexscaves.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MagicParticle extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected MagicParticle(ClientLevel pLevel, double pX, double pY, double pZ,
                            SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pQuadSizeMultiplier) {
        super(pLevel, pX, pY, pZ, 0.0, 0.0, 0.0);
        this.lifetime = 25 + this.random.nextInt(35);
        this.quadSize = 0.1F;
        this.sprites = spriteSet;
        this.roll += 0.1;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
        this.oRoll = this.roll;
        this.roll += 0.15F;

        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if(this.age++ >= this.lifetime) {
            this.remove();
            return;
        }
        float progress = (float) this.age / this.lifetime;
        if (progress > 0.65F) {
            float fadeProgress = (progress - 0.7F) / 0.3F;
            this.alpha = 1.0F - fadeProgress * fadeProgress;
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
            return new MagicParticle(pLevel, pX, pY, pZ, this.spriteSet, pXSpeed, pYSpeed, pZSpeed);
        }
    }
}
