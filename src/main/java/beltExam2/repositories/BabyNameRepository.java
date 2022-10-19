package beltExam2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import beltExam2.models.BabyName;

public interface BabyNameRepository extends CrudRepository <BabyName, Long>{
	
	List<BabyName>findAll();
//	List<BabyName>findByUsersId(Long userId);

}
