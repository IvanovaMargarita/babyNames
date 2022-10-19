package beltExam2.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import beltExam2.models.LoginUser;
import beltExam2.models.User;
import beltExam2.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User register (User newUser, BindingResult result) {
		
		Optional<User>possibleUser = userRepo.findByEmail(newUser.getEmail());
		
		if(possibleUser.isPresent()) {
			result.rejectValue("email", "Matches", "That email is already taken");
			
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "Missmatch", "Your passwords must match");
		}
		if(result.hasErrors()) {
			return null;
		}
		String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPW);	 
		return this.userRepo.save(newUser);
	}
	
	
	public User login(LoginUser newLogin, BindingResult result) {
		
		Optional<User> possibleUser = userRepo.findByEmail(newLogin.getEmail());
		if(!possibleUser.isPresent()) {
			result.rejectValue("email", "Missmatch", "Please enter a correct email and password");
	
		}else {
		
			User user = possibleUser.get();
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				result.rejectValue("password", "Match", "Please enter a correct email and password");
	
			} else {
				return user;
			}
		}
		
		return null;
	}
	public User findById(Long id) {
		Optional<User> possibleUser = userRepo.findById(id);
		if(possibleUser.isPresent()) {
			return possibleUser.get();
		}
		return null;
	}
	
	public void delete(Long id) {
		this.userRepo.deleteById(id);
	}
	
	public User retrieve(Long id) {
		return this.userRepo.findById(id).get();
		
	}
	
	public User update(User User) {
		return this.userRepo.save(User);
	}
}
