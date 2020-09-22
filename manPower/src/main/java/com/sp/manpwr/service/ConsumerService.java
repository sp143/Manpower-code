package com.sp.manpwr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.manpwr.dao.ConsumerRepository;
import com.sp.manpwr.error.RecordNotFoundException;
import com.sp.manpwr.model.Consumer;

@Service
public class ConsumerService {
	@Autowired
	ConsumerRepository consumerRepository;

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

	public Consumer createOrUpdateConsumer(Consumer entity) throws RecordNotFoundException {
		Optional<Consumer> consumer = consumerRepository.findById(entity.getId());

		if (consumer.isPresent()) {
			Consumer newEntity = consumer.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setfName(entity.getfName());
			newEntity.setlName(entity.getlName());

			newEntity = consumerRepository.save(newEntity);

			return newEntity;
		} else {
			entity = consumerRepository.save(entity);

			return entity;
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

	public Consumer findUserByEmail(String email) {
		// TODO Auto-generated method stub
		Consumer consumer=consumerRepository.findUserByEmail(email);
		return null;
	}
}
