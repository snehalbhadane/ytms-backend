package com.yash.ytms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {

}
