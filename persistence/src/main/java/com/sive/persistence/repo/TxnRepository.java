package com.sive.persistence.repo;

import com.sive.persistence.entity.TxnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxnRepository extends JpaRepository<TxnEntity, Long> {
}
