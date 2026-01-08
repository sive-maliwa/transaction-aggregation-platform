package com.sive.aggregator.core.service;

import com.sive.persistence.repo.TxnRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AggregationService {

    private final TxnRepository txnRepository;

    public AggregationService(TxnRepository txnRepository) {
        this.txnRepository = txnRepository;
    }

    public Map<String, BigDecimal> totalByCategory() {
        return txnRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        txn -> txn.getCategory(),
                        Collectors.mapping(
                                txn -> txn.getAmount(),
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));
    }
}
