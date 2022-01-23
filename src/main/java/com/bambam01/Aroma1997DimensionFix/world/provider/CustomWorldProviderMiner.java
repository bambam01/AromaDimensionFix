


package com.bambam01.Aroma1997DimensionFix.world.provider;

import aroma1997.world.dimension.WorldProviderMiner;

public class CustomWorldProviderMiner extends WorldProviderMiner {



    @Override
    public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_) {
        int j = (int)(p_76563_1_ % 24000L);
        float f1 = ((float)j + p_76563_3_) / 24000.0F - 0.25F;

        if (f1 < 0.0F)
        {
            ++f1;
        }

        if (f1 > 1.0F)
        {
            --f1;
        }

        float f2 = f1;
        f1 = 1.0F - (float)((Math.cos((double)f1 * Math.PI) + 1.0D) / 2.0D);
        f1 = f2 + (f1 - f2) / 3.0F;
        return f1;
    }
}

