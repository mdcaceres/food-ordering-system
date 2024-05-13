package com.food.ordering.system.saga;

import com.food.ordering.system.domain.event.DomainEvent;

public interface ISagaStep <T, S extends DomainEvent, U extends DomainEvent> {
    S process(T data);
    U rollback(T data);
}
