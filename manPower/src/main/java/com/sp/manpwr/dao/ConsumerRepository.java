package com.sp.manpwr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.manpwr.model.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
	@Query(value = "SELECT * FROM consumer_m WHERE email=:email",nativeQuery = true)
	Consumer findUserByEmail(@Param("email") String email);

}
