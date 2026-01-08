package com.sive.ingestion.api.controller;

import com.sive.common.dto.CanonicalTransaction;
import com.sive.ingestion.core.service.IngestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingest")
public class IngestController {

    private final IngestionService ingestionService;

    public IngestController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping
    public void ingest(@RequestBody CanonicalTransaction txn) {
        ingestionService.ingest(txn);
    }
}
