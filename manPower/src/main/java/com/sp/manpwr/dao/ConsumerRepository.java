package com.sp.manpwr.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.manpwr.model.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
	@Query(value = "SELECT * FROM consumer_m A WHERE A.email=:email", nativeQuery = true)
	Optional<Consumer> findUserByEmail(@Param("email") String email);

	@Query(value = "SELECT * FROM consumer_m A WHERE A.id in (select user_master_id from login_m where USER_NAME=:USERNAME AND PASS_WORD=:PASSWORD) AND RECORD_STATUS='ACTIVE'", nativeQuery = true)
	Optional<Consumer> validateLogin(@Param("USERNAME") String userName, @Param("PASSWORD") String passWord);

}
