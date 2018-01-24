package com.yydone.common;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TransTableShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> preciseShardingValue) {

        for (String each : availableTargetNames) {
            String table_prefix = preciseShardingValue.getValue().substring(preciseShardingValue.getValue().length()-2, preciseShardingValue.getValue().length());
            if (each.endsWith(table_prefix)) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}

