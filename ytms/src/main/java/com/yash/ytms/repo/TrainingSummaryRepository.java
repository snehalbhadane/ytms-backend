package com.yash.ytms.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.TrainingSummary;
@Repository
public interface TrainingSummaryRepository extends JpaRepository<TrainingSummary, Long> {
	
	@Query("SELECT ts FROM TrainingSummary ts WHERE " + "(:createdOn IS NULL OR ts.createdOn = :createdOn) OR "
			+ "(:trainingName IS NULL OR ts.trainingPlan.trainingName = :trainingName)")
	List<TrainingSummary> findSummaryByCreatedDateOrName(@Param("createdOn") LocalDate createdOn,
			@Param("trainingName") String trainingName);
	 
	
	

}
