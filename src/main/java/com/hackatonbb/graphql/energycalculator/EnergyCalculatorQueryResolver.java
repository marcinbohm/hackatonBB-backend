package com.hackatonbb.graphql.energycalculator;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hackatonbb.resource.energycalculation.EnergyCalculationService;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.transaction.Transactional;

public class EnergyCalculatorQueryResolver implements GraphQLQueryResolver {

    private final EnergyCalculationService energyCalculationService;

    public EnergyCalculatorQueryResolver(EnergyCalculationService energyCalculationService) {
        this.energyCalculationService = energyCalculationService;
    }

}
