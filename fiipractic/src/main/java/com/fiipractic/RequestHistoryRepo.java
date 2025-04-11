package com.fiipractic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class RequestHistoryRepo {

@Repository
    public interface RequestHistoryRepository extends JpaRepository < RequestHistoryEntity, Long> {
    }

}
