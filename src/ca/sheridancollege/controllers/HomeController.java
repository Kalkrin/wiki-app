package ca.sheridancollege.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.DAO.DAO;
import ca.sheridancollege.beans.User;
import ca.sheridancollege.beans.Wiki;

@Controller
public class HomeController {
	// for extra functionality I added a random article link at the bottom of the home page. 

	DAO dao = new DAO();
	Wiki wiki = new Wiki();
	String[] subjects = wiki.getSubjects();
	User curUser = null;
	List<Wiki>wikiList = dao.getWiki();
	Wiki wikiToSee = null;
	
	
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute(wikiList);
		model.addAttribute("subjects", subjects);
		return "home";
	}
	
	@RequestMapping("/createWiki")
	public String createWiki(Model model) {
		Wiki wiki = new Wiki();
		model.addAttribute(wiki);
		if(curUser == null){
			model.addAttribute("message", "Please login to create a new wiki article.");
			return "login";
		}
		else{
			model.addAttribute("message","Logged in as: " + curUser.getUsername());
			return "create";
		}
	}
	
	@RequestMapping("/saveWiki")
	public String saveWiki(Model model, @ModelAttribute Wiki wiki){
		Date date = new Date();
		wiki.setEdited(curUser.getUsername());
		wiki.setModified(date);
		if(wiki.getTitle() == null){
			wiki.setTitle(wikiToSee.getTitle());
		}
		dao.saveWiki(wiki);
		model.addAttribute("subjects", subjects);
		model.addAttribute("message","Logged in as: " + curUser.getUsername());
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(Model model){
		User user = new User();
		model.addAttribute(user);
		return "login";
	}
	
	@RequestMapping("/checkLogin")
	public String checkLogin(Model model, @RequestParam String userName, @RequestParam String password){
		List<User>userList = dao.getUsers();
		for(User user : userList){
			if(user.getUsername().toUpperCase().equals(userName.toUpperCase()) && user.getPassword().equals(password)){
				curUser = user;
				model.addAttribute("message","Logged in as: " + curUser.getUsername());
				model.addAttribute("subjects", subjects);
				return "home";
			}
		}
		model.addAttribute("message","Invalid credentials");
		return "login";
	}
	
	@RequestMapping("/createAccount")
	public String createAccount(Model model){
		User user = new User();
		model.addAttribute(user);
		return "createAccount";
	}
	
	@RequestMapping("/saveAccount")
	public String saveAccount(Model model, @ModelAttribute User newUser){
		List<User>userList = dao.getUsers();
		if(newUser.getEmail().equals("") || newUser.getfName().equals("") || newUser.getlName().equals("") || newUser.getUsername().equals("") || newUser.getPassword().equals("")){
			model.addAttribute("message","All fields must be filled");
			return "createAccount";
		}
		for(User user : userList){
			if(user.getUsername().toUpperCase().equals(newUser.getUsername().toUpperCase())){
				model.addAttribute("message","Username already taken");
				return "createAccount";
			}
			else if(user.getEmail().toUpperCase().equals(newUser.getEmail().toUpperCase())){
				model.addAttribute("message","You already have an account");
				return "createAccount";
			}
		}
		dao.saveUser(newUser);
		return "login";
	}
	
	@RequestMapping("/viewSubject/{subject}")
	public String viewSubject(Model model, @PathVariable String subject){
		List<Wiki>subjectList = new ArrayList<Wiki>();
		wikiList = dao.getWiki();
		for(Wiki wiki : wikiList){
			if(wiki.getSubject().equals(subject)){
				subjectList.add(wiki);
			}
		}
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("subject" , subject);
		if(curUser != null){
			model.addAttribute("message","Logged in as: " + curUser.getUsername());
		}
		return "viewSubject";
	}
	
	@RequestMapping("/view/{title}")
	public String view(Model model , @PathVariable String title){
		wikiList = dao.getWiki();
		for(Wiki wiki : wikiList){
			if(wiki.getTitle().equals(title)){
				wikiToSee = wiki;
			}
		}
		model.addAttribute(wikiToSee);
		if(curUser != null){
			model.addAttribute("message","Logged in as: " + curUser.getUsername());
		}
		return "view";
	}
	
	@RequestMapping("/editWiki/{title}")
	public String editWiki(Model model){
		model.addAttribute(wikiToSee);
		if(curUser == null){
			model.addAttribute("message", "Please login to edit wiki articles.");
			return "login";
		}
		else{
			model.addAttribute("message","Logged in as: " + curUser.getUsername());
			return "editWiki";
		}
	}
	
	@RequestMapping("/randomArticle")
	public String randomArticle(Model model){
		wikiList = dao.getWiki();
		int listLength = wikiList.size();
		int indexOfWiki = (int)(Math.random() * ((listLength - 0) + 0));
		wikiToSee = wikiList.get(indexOfWiki);
		
		model.addAttribute(wikiToSee);
		if(curUser != null){
			model.addAttribute("message","Logged in as: " + curUser.getUsername());
		}
		return "view";
	}
}
