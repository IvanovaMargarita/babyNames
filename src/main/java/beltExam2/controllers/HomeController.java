package beltExam2.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import beltExam2.models.BabyName;
import beltExam2.models.Comment;
import beltExam2.models.LoginUser;
import beltExam2.models.User;
import beltExam2.services.BabyNameService;
import beltExam2.services.CommentService;
import beltExam2.services.UserService;
@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired 
	BabyNameService nameService;
	
	@Autowired
	CommentService commentService;
	
	
	@GetMapping("/")
    public String getRegistration(Model model) {
    model.addAttribute("newUser", new User());
    model.addAttribute("newLogin", new LoginUser());
    return "index.jsp";
    }
	

	
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		 
		 User user = userService.register(newUser, result);
		 
		 if(result.hasErrors()) {
			 model.addAttribute("newLogin" ,new LoginUser());
			 return "index.jsp";
		 }
		 session.setAttribute("userId", user.getId());
		 
		 return "redirect:/home";
	 }

	 
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin, BindingResult result,Model model, HttpSession session) {
		 
		 User user = userService.login(newLogin, result);
		 
		 if(result.hasErrors()) {
			 model.addAttribute("newUser", new User());
			 return "index.jsp";
		 }
		 
		 session.setAttribute("userId", user.getId());
		 return "redirect:/home";
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 }
	 
	 @GetMapping("/home")
	 public String home(Model model, HttpSession session, User user, BabyName babyName) {
		 Long userId = (Long) session.getAttribute("userId");
		 if(userId==null) {
			 return "redirect:/"; 
		 }
		 model.addAttribute("babyName", babyName);

		 model.addAttribute("user",userService.findById(userId));

		 model.addAttribute("babyName", nameService.findAll());
		 
		 return "home.jsp";
	 }
	 
	 @GetMapping("/names/new")
	 public String names(@ModelAttribute("babyName") BabyName item, Model model, HttpSession session) {
		 User user = userService.findById((Long)session.getAttribute("userId"));
		 model.addAttribute("user", user);
		 return "addName.jsp";
	 }
	 
	 @PostMapping("/names/new/create")
	 public String createName(@Valid @ModelAttribute("babyName")BabyName item, BindingResult result) {
		 if(result.hasErrors()) {
		 return "addName.jsp";
		 }
		 this.nameService.create(item);
		 return "redirect:/home";
	 }
	 
	 @GetMapping("/names/{id}")
	 public String showName(Model model, @PathVariable("id") Long id, HttpSession session) {
		 if(session.getAttribute("userId")==null) {
			 return "home.jsp";
		 }
		 BabyName babyName = nameService.findById(id);
		 model.addAttribute("babyName", babyName);
		 model.addAttribute("allComments", commentService.findAll());
		 model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		 return "showName.jsp";
	 }
	 
	 @GetMapping("/names/{id}/edit")
	 public String editPage(Model model,@PathVariable("id")Long id, HttpSession session) {
		 if(session.getAttribute("userId")==null) {
			 return "redirect:/home";
		 }
		 model.addAttribute("babyName", this.nameService.retrieve(id));

		 return "edit.jsp";
	 }
	 
	 @PostMapping("/names/update")
	 public String editName(@Valid @ModelAttribute("babyName") BabyName babyName,BindingResult result,Model model) {
		
		 if(result.hasErrors()) {
			 model.addAttribute(babyName);
			 return "edit.jsp";
		 }
	    	nameService.update(babyName);
			return "redirect:/home";
		 }
	 
	 @RequestMapping("/names/{id}/delete")
	 public String deleteName(@PathVariable("id")Long id, HttpSession session) {
		 if(session.getAttribute("userId")==null) {
			 return "redirect:/logout";
		 }
		 nameService.delete(id);
		 return "redirect:/home";
	 }
	 
	 //add like
	 @GetMapping("/like/{id}")
	 public String like(@PathVariable("id")Long id, HttpSession session) {
		 Long UserId = (Long)session.getAttribute("userId");
		 Long BabyNameId = id;
		 User liker = this.userService.findById(UserId);
		 BabyName likedName = this.nameService.findById(BabyNameId);
		 this.nameService.addLiker(likedName, liker);
		 return "redirect:/home";
	 }
	 
	 //unlike
	 @GetMapping("/unlike/{id}")
	 public String unlike(@PathVariable("id")Long id, HttpSession session) {
		 Long UserId = (Long)session.getAttribute("userId");
		 Long BabyNameId = id;
		 User liker = this.userService.findById(UserId);
		 BabyName likedName = this.nameService.findById(BabyNameId);
		 this.nameService.removeLiker(likedName, liker);
		 return "redirect:/home";
	 }
	 
	 @GetMapping("/names/{id}/comment")
	 public String commentPage(@ModelAttribute("newComment")Comment comment,Model model, HttpSession session, @PathVariable("id")Long id) {
		 Long userId = (Long) session.getAttribute("userId");
		 if(userId==null) {
			 return "redirect:/"; 
		 }
		 model.addAttribute("babyName", nameService.findById(id));

		 model.addAttribute("user",userService.findById(userId));

		 model.addAttribute("allComments", commentService.findAll());
		 
		 return "addComment.jsp";
	 }
	 
	 @PostMapping("/{id}/comment/add")
	 public String createComment(@Valid @ModelAttribute("newComment")Comment comment, BindingResult result,@PathVariable("id")Long id) {
		 if(result.hasErrors()) {
		 return "addComment.jsp";
		 }
		 this.commentService.create(comment);
		 return "redirect:/names/{id}";
	 }

}

