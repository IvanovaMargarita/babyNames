package beltExam2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beltExam2.models.BabyName;
import beltExam2.models.User;
import beltExam2.repositories.BabyNameRepository;

@Service
public class BabyNameService {
	
	@Autowired BabyNameRepository nameRepo;
	
public BabyName findById(Long id) {
		
		Optional<BabyName> result = nameRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

//Add liker to babyName

public void addLiker(BabyName babyName, User user) {
	//create a list of likes and get likes
	List<User> currentLikes = babyName.getLikers();
	//add user to the current likes
	currentLikes.add(user);
	//save the name after updating the likes
	this.nameRepo.save(babyName);
}
///UNLIKE
public void removeLiker(BabyName babyName, User user) {
	//create a list of likes and get likes
	List<User> currentLikes = babyName.getLikers();
	//add user to the current likes
	currentLikes.remove(user);
	//save the name after updating the likes
	this.nameRepo.save(babyName);
}

public List <BabyName> findAll(){
	return nameRepo.findAll();
}

public BabyName create(BabyName item) {
	return nameRepo.save(item);
}

public BabyName update(BabyName babyName) {
	return nameRepo.save(babyName);
}
	
public void delete(Long id) {
	this.nameRepo.deleteById(id);
}

public BabyName retrieve(Long id) {
	return this.nameRepo.findById(id).get();
}
}
