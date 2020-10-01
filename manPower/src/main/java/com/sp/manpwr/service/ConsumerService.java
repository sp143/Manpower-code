package com.sp.manpwr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.manpwr.dao.ConsumerRepository;
import com.sp.manpwr.dao.LoginRepository;
import com.sp.manpwr.dto.ConsumerDTO;
import com.sp.manpwr.error.RecordNotFoundException;
import com.sp.manpwr.model.Consumer;
import com.sp.manpwr.model.Login;
import com.sp.manpwr.util.Utility;

@Service
public class ConsumerService {
	@Autowired
	ConsumerRepository consumerRepository;
	@Autowired
	LoginRepository loginRepository;

	public List<Consumer> getAllEmployees() {
		List<Consumer> consumers = consumerRepository.findAll();
		if (consumers.size() > 0) {
			return consumers;
		} else {
			return new ArrayList<Consumer>();
		}

	}

	public Consumer getConsumerById(Long id) throws RecordNotFoundException {
		Optional<Consumer> consumers = consumerRepository.findById(id);

		if (consumers.isPresent()) {
			return consumers.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Transactional(rollbackOn = Exception.class)
	public Consumer createOrUpdateConsumer(ConsumerDTO newEntity) throws RecordNotFoundException {
		Optional<Consumer> consumer = consumerRepository.findUserByEmail(newEntity.getEmail());
		Consumer newConsumer=null;
		if (consumer.isPresent()) {
			newConsumer = consumer.get();
			newConsumer.setEmail(newEntity.getEmail());
			newConsumer.setfName(newEntity.getfName());
			newConsumer.setlName(newEntity.getlName());
			newConsumer.setUpdate_date(Utility.utilDateToSqlDate(new Date()));

			updatedConsumer = consumerRepository.save(newConsumer);

			return newConsumer;
		} else {
			newConsumer = new Consumer();
			newConsumer.setEmail(newEntity.getEmail());
			newConsumer.setfName(newEntity.getfName());
			newConsumer.setlName(newEntity.getlName());
			newConsumer.setAddress(newEntity.getAddress());
			newConsumer.setAdhaarid(newEntity.getAdhaarid());
			newConsumer.setProfession(newEntity.getProfession());
			newConsumer.setDOB(Utility.stringToSQLDate(newEntity.getDOB()));
			newConsumer.setRecord_status("ACTIVE");
			newConsumer.setPhNo(newEntity.getPhNo());
			newConsumer.setGender(newEntity.getGender());
			newConsumer.setCreate_date(Utility.utilDateToSqlDate(new Date()));

			Consumer createdConsumer = consumerRepository.save(newConsumer);
			if (createdConsumer != null) {
				Login login = new Login();
				login.setEmail(newEntity.getEmail() + "-");
				login.setPassWord(newEntity.getPassword());
				login.setUserMasterId(newConsumer.getId());
				login.setUserName(newEntity.getuName());
				login.setUserRole(newEntity.getRole());
				loginRepository.save(login);
			}
			return createdConsumer;
		}
	}

	public void deleteConsumerById(Long id) throws RecordNotFoundException {
		Optional<Consumer> consumer = consumerRepository.findById(id);

		if (consumer.isPresent()) {
			consumerRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public Optional<Consumer> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<Consumer> consumer = consumerRepository.findUserByEmail(email);
		return consumer;
	}

	public Optional<Consumer> loginValidation(String userName, String passWord) {
		Optional<Consumer> consumer = consumerRepository.validateLogin(userName, passWord);
		return consumer;

	}
}
