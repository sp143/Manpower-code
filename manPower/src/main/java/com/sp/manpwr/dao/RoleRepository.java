package com.sp.manpwr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sp.manpwr.beans.RoleM;

@Repository
public interface RoleRepository extends JpaRepository<RoleM, Long> {
	

}
