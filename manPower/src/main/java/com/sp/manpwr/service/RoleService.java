package com.sp.manpwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.manpwr.beans.RoleM;
import com.sp.manpwr.dao.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	public List<RoleM> getAllRoles() {
		List<RoleM> listRoleM=roleRepository.findAll();//    getAllRoles();
		return listRoleM;

	}
}
