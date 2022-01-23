package com.bambam01.Aroma1997DimensionFix;


import aroma1997.world.Config;
import aroma1997.world.dimension.WorldProviderMiner;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import com.bambam01.Aroma1997DimensionFix.world.provider.CustomWorldProviderMiner;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.DimensionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Aroma1997DimensionFix.MODID, version = Aroma1997DimensionFix.VERSION, acceptableRemoteVersions = "*", dependencies = "required-after:Aroma1997sDimension")
public class Aroma1997DimensionFix
{
    public static final String MODID = "Aroma1997DimensionFix";
    public static final String VERSION = "1.0";
    public static final boolean IS_DEOBFUSCATED =
            (boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");


    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @EventHandler
    public void postInit(FMLPostInitializationEvent evt) {
        Config.instance.load();
        if(DimensionManager.isDimensionRegistered(Config.instance.dimensionID)){
            LOGGER.info("Found Aroma1997 mining dimension with id:"+Config.instance.dimensionID+", switching provider type");
            int[] worldlist = DimensionManager.unregisterProviderType(Config.instance.dimensionID);
            DimensionManager.registerProviderType(Config.instance.dimensionID, CustomWorldProviderMiner.class, false);
            LOGGER.info("Provider type switched, let the night begin :)");

        }


    }
}
