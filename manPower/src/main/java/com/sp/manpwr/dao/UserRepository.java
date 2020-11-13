package com.sp.manpwr.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.manpwr.beans.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long> {
	@Query(value = "FROM UserDetail A WHERE A.email=:user_name")
	Optional<UserDetail> findUserByEmail(@Param("user_name") String user_name);
}
