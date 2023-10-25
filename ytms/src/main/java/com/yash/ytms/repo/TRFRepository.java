package com.yash.ytms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.TrainingRequestForm;

/**
 * This will responsible to communicate with training_request_form database table
 * @author dheerendra.kag
 * @version 1.0
 * @since 05/05/2023
 */
@Repository
public interface TRFRepository extends JpaRepository<TrainingRequestForm, Long>{
	
	@EntityGraph(attributePaths = {"associates"})
	List<TrainingRequestForm> findAll();
	List<TrainingRequestForm> findAllTrainingRequestFormsByStatus(String status);

	@Modifying(clearAutomatically = true)
	@Query("update TrainingRequestForm f set f.status =:status where f.trfId =:trfId")
	int updateTrainingRequestFormStatus(@Param("trfId") Long trfId, @Param("status") String status);
}
