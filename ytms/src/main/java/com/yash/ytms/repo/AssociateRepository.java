package com.yash.ytms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.Associate;

/**
 * This will responsible to communicate with associate database table
 * @author dheerendra.kag
 * @version 1.0
 * @since 05/05/2023
 */
@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long>{
	
//	@Modifying
//	@Query("delete from Associate a where a.id in(:ids)")
//	void deleteByIdIn(List<Long> ids);
	
	@Modifying
	@Query(value = "delete from associate where asst_trf_id IS NULL", nativeQuery = true)
	void deleteByIdIn();
}
