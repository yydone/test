package com.yydone.common;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TransDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> preciseShardingValue) {

        for (String each : availableTargetNames) {
            String db_prefix = preciseShardingValue.getValue().substring(preciseShardingValue.getValue().length()-4, preciseShardingValue.getValue().length()-2);
            if (each.endsWith(db_prefix)) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}

