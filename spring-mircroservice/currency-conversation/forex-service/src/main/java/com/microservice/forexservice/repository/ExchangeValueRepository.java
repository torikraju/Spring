package com.microservice.forexservice.repository;

import com.microservice.forexservice.domain.ExchangeValue;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeValueRepository extends CrudRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
