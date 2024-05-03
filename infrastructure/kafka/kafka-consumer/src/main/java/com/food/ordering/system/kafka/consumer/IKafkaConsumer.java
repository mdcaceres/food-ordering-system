package com.food.ordering.system.kafka.consumer;

import org.apache.avro.specific.SpecificRecordBase;

import java.util.List;

public interface IKafkaConsumer<T extends SpecificRecordBase>{
    void recieve(List<T> messages, List<Long> keys, List<Integer> partitions, List<Long> offsets);
}
