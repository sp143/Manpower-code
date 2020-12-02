package com.sp.manpwr.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.manpwr.beans.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
	@Query(value = "FROM LoginEntity A WHERE A.email=:user_name")
	LoginEntity findUserByLoginName(@Param("user_name") String user_name);

	@Query(value = "FROM LoginEntity A WHERE A.email=:user_name")
	Optional<LoginEntity> findUserByEmailSS(@Param("user_name") String email);

}
