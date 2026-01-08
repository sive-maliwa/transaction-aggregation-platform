package com.sive.ingestion.core.service;

import com.sive.common.dto.CanonicalTransaction;
import com.sive.ingestion.core.categorizer.RuleCategorizer;
import com.sive.persistence.entity.TxnEntity;
import com.sive.persistence.repo.TxnRepository;
import org.springframework.stereotype.Service;

@Service
public class IngestionService {

    private final TxnRepository txnRepository;
    private final RuleCategorizer ruleCategorizer;

    public IngestionService(TxnRepository txnRepository,
                            RuleCategorizer ruleCategorizer) {
        this.txnRepository = txnRepository;
        this.ruleCategorizer = ruleCategorizer;
    }

    public void ingest(CanonicalTransaction tx) {

        String category = ruleCategorizer.categorize(tx.getDescription());

        TxnEntity entity = new TxnEntity();
        entity.setExternalId(tx.getExternalId());
        entity.setAmount(tx.getAmount());
        entity.setDescription(tx.getDescription());
        entity.setTxnDate(tx.getTxnDate());
        entity.setCategory(category);

        txnRepository.save(entity);
    }
}
