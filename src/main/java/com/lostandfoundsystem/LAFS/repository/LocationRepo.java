package com.lostandfoundsystem.LAFS.repository;

import com.lostandfoundsystem.LAFS.entity.LocationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@EnableJpaRepositories
public interface LocationRepo extends JpaRepository<LocationDetails, Long> {
}
