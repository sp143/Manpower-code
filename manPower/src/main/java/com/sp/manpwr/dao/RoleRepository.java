package com.sp.manpwr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.manpwr.beans.RoleM;

@Repository
public interface RoleRepository extends JpaRepository<RoleM, Long> {

	@Query("from RoleM r where r.roleName=:roleName")
	RoleM getbyName(@Param("roleName") String roleName);

}
