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
	
	@Query(value = " FROM UserDetail A WHERE A.email=:email", nativeQuery = true)
	Optional<UserDetail> findUserByEmailUser(@Param("email") String email);

	@Query(value = "FROM UserDetail A WHERE A.id in (from login_m where USER_NAME=:USERNAME AND PASS_WORD=:PASSWORD) AND RECORD_STATUS='ACTIVE'", nativeQuery = true)
	UserDetail validateLogin(@Param("USERNAME") String userName, @Param("PASSWORD") String passWord);
}
