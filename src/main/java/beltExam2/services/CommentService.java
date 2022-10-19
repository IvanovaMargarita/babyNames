package beltExam2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beltExam2.models.Comment;
import beltExam2.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired CommentRepository commentRepo;
	
	public Comment findById(Long id) {
		
		Optional<Comment> result = commentRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	public List <Comment> findAll(){
		return commentRepo.findAll();
	}
	
	public Comment create(Comment item) {
		return commentRepo.save(item);
	}
	
	public Comment update(Comment comment) {
		return commentRepo.save(comment);
	}
		
	public void delete(Long id) {
		this.commentRepo.deleteById(id);
	}
	public Comment retrieve(Long id) {
		return this.commentRepo.findById(id).get();
	}
}

