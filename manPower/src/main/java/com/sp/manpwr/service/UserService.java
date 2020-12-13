package com.sp.manpwr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sp.manpwr.beans.LoginEntity;
import com.sp.manpwr.beans.RoleM;
import com.sp.manpwr.beans.UserDetail;
import com.sp.manpwr.dao.LoginRepository;
import com.sp.manpwr.dao.UserRepository;
import com.sp.manpwr.dto.UserDTO;
import com.sp.manpwr.error.RecordNotFoundException;
import com.sp.manpwr.util.CutomUtil;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	public List<UserDetail> getAllEmployees() {
		List<UserDetail> consumers = userRepository.findAll();
		if (consumers.size() > 0) {
			return consumers;
		} else {
			return new ArrayList<UserDetail>();
		}

	}

	public UserDetail getConsumerById(Long id) throws RecordNotFoundException {
		Optional<UserDetail> consumers = userRepository.findById(id);

		if (consumers.isPresent()) {
			return consumers.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Transactional(rollbackOn = Exception.class)
	public UserDetail createOrUpdateConsumer(UserDTO newEntity) throws RecordNotFoundException {
		Optional<UserDetail> user = userRepository.findUserByEmail(newEntity.getEmail());
		UserDetail newUser = null;
		if (user.isPresent()) {
			newUser = user.get();
			newUser.setEmail(newEntity.getEmail());
			newUser.setfName(newEntity.getfName());
			newUser.setlName(newEntity.getlName());
			newUser.setAddress(newEntity.getAddress());
			newUser.setAdhaarid(newEntity.getAdhaarid());
			newUser.setProfession(newEntity.getProfession());
			newUser.setDOB(CutomUtil.stringToSQLDate(newEntity.getDOB()));
			newUser.setRecord_status("ACTIVE");
			newUser.setPhNo(newEntity.getPhNo());
			newUser.setGender(newEntity.getGender());
			newUser.setUpdate_date(CutomUtil.utilDateToSqlDate(new Date()));

			UserDetail updatedConsumer = userRepository.save(newUser);

			return updatedConsumer;
		} else {
			newUser = new UserDetail();
			newUser.setEmail(newEntity.getEmail());
			newUser.setfName(newEntity.getfName());
			newUser.setlName(newEntity.getlName());
			newUser.setAddress(newEntity.getAddress());
			newUser.setAdhaarid(newEntity.getAdhaarid());
			newUser.setProfession(newEntity.getProfession());
			newUser.setDOB(CutomUtil.stringToSQLDate(newEntity.getDOB()));
			newUser.setRecord_status("ACTIVE");
			newUser.setPhNo(newEntity.getPhNo());
			newUser.setGender(newEntity.getGender());
			newUser.setCreate_date(CutomUtil.utilDateToSqlDate(new Date()));

			UserDetail createdUser = userRepository.save(newUser);
			if (createdUser != null) {

				LoginEntity login = new LoginEntity();
				login.setRoleM(newEntity.getRole());
				login.setEmail(newEntity.getEmail());
				login.setPass_word(passwordEncoder.encode(newEntity.getPassword()));
				login.setUser_master_id(createdUser.getId());
				login.setUser_name(newEntity.getuName());
				login.setRecord_status("ÄCTIVE");

				loginRepository.save(login);
			}
			return createdUser;
		}
	}

	public void deleteConsumerById(Long id) throws RecordNotFoundException {
		Optional<UserDetail> consumer = userRepository.findById(id);

		if (consumer.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public Optional<UserDetail> findUserByEmail(String email) {
		Optional<UserDetail> user = userRepository.findUserByEmail(email);
		return user;
	}

	public UserDetail findUserByLoginName(String email) {
		UserDetail userDetails = userRepository.findUserByEmail(email).get();
		return userDetails;
	}

	public void updateUserDetails(UserDetail user) {
		userRepository.save(user);
	}

	public UserDetail loginValidation(String userName, String passWord) {
		UserDetail user = userRepository.validateLogin(userName, passWord);
		return user;

	}
}
