package com.sp.manpwr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sp.manpwr.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	
}
