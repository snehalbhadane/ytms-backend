package com.yash.ytms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.TrainingSummary;
@Repository
public interface TrainingSummaryRepository extends JpaRepository<TrainingSummary, Long> {
	
	@Query("SELECT t FROM TrainingSummary t WHERE t.trainer.firstName=?1")
	public List<TrainingSummary> findByName(String firstName); 
	

}
