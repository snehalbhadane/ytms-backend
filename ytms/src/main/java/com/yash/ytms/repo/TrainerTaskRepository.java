package com.yash.ytms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.TrainerTask;

@Repository
public interface TrainerTaskRepository extends JpaRepository<TrainerTask,Long> {

	@Query(value = "SELECT * FROM trainer_task WHERE created_by_id = ?1", nativeQuery = true)
	public List<TrainerTask> getTrainerTasksByCreatedById(Long createdById);
}