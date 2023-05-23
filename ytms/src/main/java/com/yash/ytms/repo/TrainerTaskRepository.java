package com.yash.ytms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.TrainerTask;

@Repository
public interface TrainerTaskRepository extends JpaRepository<TrainerTask,Long> {

}