package com.yash.ytms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.Location;
import com.yash.ytms.model.Role;

@Repository
public interface LocationRepository  extends JpaRepository<Location, Long>{

}
