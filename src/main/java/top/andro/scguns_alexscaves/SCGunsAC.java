package top.andro.scguns_alexscaves;

import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.andro.scguns_alexscaves.client.SCACClientHandler;
//import top.andro.scguns_alexscaves.client.particle.GuanoParticle;
import top.andro.scguns_alexscaves.client.particle.MagicImpactParticle;
import top.andro.scguns_alexscaves.client.particle.MagicParticle;
import top.andro.scguns_alexscaves.common.entity.projectile.*;
import top.andro.scguns_alexscaves.init.*;
//import top.andro.scguns_alexscaves.init.ModSounds;
import top.ribs.scguns.client.screen.BlueprintScreen;
import top.ribs.scguns.common.ProjectileManager;
import top.ribs.scguns.entity.player.GunTierRegistry;

import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SCGunsAC.MOD_ID)
public class SCGunsAC
{
    public static final String MOD_ID = "scguns_alexscaves";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SCGunsAC() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModParticleTypes.REGISTER.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            SCACClientHandler.registerClientHandlers(modEventBus);
            BlueprintScreen.registerLoreOnlyItem(new ResourceLocation(MOD_ID, "abyssal_blueprint"), "halibut_cannon");
            BlueprintScreen.registerGunOrder(List.of(
                    "atomic_carabine", "fission_fever", "genesis", "foul_emesis", "corroder", "acid_sprayer",

                    "halibut_cannon", "sea_serpent", "elver_tide", "moray_tide", "mahi", "neptunes_bounty",

                    "ebony_ivory", "dragonfly", "eclipse", "redstone_repeater", "sauron", "guano_cannon"
            ));
        });
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        GunTierRegistry.register("irradiated", 6, "atomic_gun_tier", 4);
        GunTierRegistry.register("brined_legion", 4, "abyssal_gun_tier", 3);
        GunTierRegistry.register("whisperers", 4, "forlorn_gun_tier", 5);

        ProjectileManager.getInstance().registerFactory(ModItems.URANIUM_CELL.get(), (worldIn, entity, weapon, item, modifiedGun) ->
                new UraniumCellProjectileEntity(ModEntities.URANIUM_CELL_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ModItems.ACID_TANK.get(), (worldIn, entity, weapon, item, modifiedGun) ->
                new AcidTankProjectileEntity(ModEntities.ACID_TANK_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(Items.WATER_BUCKET, (worldIn, entity, weapon, item, modifiedGun) ->
                new WaterBucketProjectileEntity(ModEntities.WATER_BUCKET_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ACItemRegistry.PURE_DARKNESS.get(), (worldIn, entity, weapon, item, modifiedGun) ->
                new MagicProjectileEntity(ModEntities.MAGIC_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ACItemRegistry.GUANO.get(), (worldIn, entity, weapon, item, modifiedGun) ->
                new GuanoProjectileEntity(ModEntities.GUANO_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            List<Block> translucentBlocks = List.of(
                    ModBlocks.POLYMER_PLATE_BARS.get()
            );

            for (Block block : translucentBlocks) {
                ItemBlockRenderTypes.setRenderLayer(block, RenderType.translucent());
            }

        }

        @SubscribeEvent
        public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticleTypes.MAGIC_SMALL.get(), MagicParticle.Provider::new);
            event.registerSpriteSet(ModParticleTypes.MAGIC_IMPACT.get(), MagicImpactParticle.Provider::new);
        }
    }
}
