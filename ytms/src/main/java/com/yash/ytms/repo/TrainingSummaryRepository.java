package com.yash.ytms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.TrainingSummary;
@Repository
public interface TrainingSummaryRepository extends JpaRepository<TrainingSummary, Long> {

}
