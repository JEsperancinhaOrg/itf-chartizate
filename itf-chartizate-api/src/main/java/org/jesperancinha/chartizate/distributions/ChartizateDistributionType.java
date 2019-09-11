package org.jesperancinha.chartizate.distributions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author joao
 */
public enum ChartizateDistributionType {
    Linear, Gaussian, Poisson, Skellam;

    public static List<String> getAllDistributionTypes() {
        return Arrays.stream(ChartizateDistributionType.values()).map(ChartizateDistributionType::toString).collect(Collectors.toList());
    }
}