package com.hackatonbb.resource.energycalculation;

import com.hackatonbb.entity.Installation;
import com.hackatonbb.entity.Point;
import org.springframework.stereotype.Service;

@Service
public class EnergyCalculationServiceImpl implements EnergyCalculationService {

    public Double getCalculationOfGeneratedEnergyByYearFromPhotoVoltaics(Installation installation, Point point) {
        return (point.getYearlyInsolationLevelKwhM2() * installation.getSouthDeviationRoofSlopeCorrection()
                * installation.getInstallationPowerKWP() * installation.getYieldGuarantee());
    }

    public Double getCalculationOfGeneratedEnergyByYearFromWindTurbines(Installation installation, Point point) {
        double R = 1.255;
        return 0.5 * (installation.getWindSurfaceSizeM2() == null ? R : installation.getWindSurfaceSizeM2()) * point.getYearlyWindSpeedMph();
    }
}
