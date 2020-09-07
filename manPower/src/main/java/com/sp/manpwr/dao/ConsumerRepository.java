package com.sp.manpwr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.manpwr.model.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
	@Query(value = "FROM Consumer WHERE email=:email",nativeQuery = true)
	void findUserByEmail(@Param("email") String email);

}
