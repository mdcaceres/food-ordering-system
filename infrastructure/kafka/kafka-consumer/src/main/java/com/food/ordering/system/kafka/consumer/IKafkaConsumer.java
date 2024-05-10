package com.food.ordering.system.kafka.consumer;

import org.apache.avro.specific.SpecificRecordBase;

import java.util.List;

public interface IKafkaConsumer<T extends SpecificRecordBase>{
    void receive(List<T> messages, List<String> keys, List<Integer> partitions, List<Long> offsets);
}
