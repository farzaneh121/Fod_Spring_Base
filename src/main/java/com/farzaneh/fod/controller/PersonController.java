package com.farzaneh.fod.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.farzaneh.fod.model.Person;
import com.farzaneh.fod.model.PersonDto;
import com.farzaneh.fod.repository.PersonRepository;
import com.farzaneh.fod.service.ProcessException;

@Controller
@RequestMapping("/person")
public class PersonController {

	private PersonRepository personRepository;
	private Person person;

	@Autowired
	public PersonController(PersonRepository personRepository, Person person) {
		this.personRepository = personRepository;
		this.person = person;
	}

	@GetMapping("/goRegisterPage")
	public String goRegisterPage() {
		return "person/register";
	}

	@GetMapping("/goLoginPage")
	public String goLoginPage() {
		return "person/login";
	}

	@PostMapping("/register")
	public String registerNewUser(@Valid PersonDto personDto, Errors error, ModelMap modelMap) throws ProcessException {
		if (error.hasErrors()) {
			modelMap.addAttribute("errors", error.getAllErrors());
			return "person/register";
		}
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setEmailAddress(personDto.getEmailAddress());
		person.setPrincipalName(personDto.getPrincipalName());
		person.setCreationDate(new Date(0));
		person.setPersonTypeCode("CUST");
		Person newPerson = new Person();
		try {
			newPerson = personRepository.save(person);
		} catch (Exception e) {
			throw new ProcessException("Error during insert new user", e);
		}
		modelMap.addAttribute("member", newPerson);
		return "home";
	}

	@GetMapping("/login")
	public String loginUser(PersonDto personDto, ModelMap modelMap, HttpSession session) throws ProcessException {
		String userName = personDto.getPrincipalName();
		String email = personDto.getEmailAddress();
		Person member = personRepository.findByPrincipalNameAndEmailAddress(userName, email)
				.orElseThrow(() -> new ProcessException("Error during finding user"));
		session.setAttribute("member", member);
		modelMap.addAttribute("member", member);
		return "home";
	}

	@GetMapping("/logOut")
	public String logOutUser(HttpSession session) {
		if (session.getAttribute("member") != null) {
			session.removeAttribute("member");
		}
		return "home";
	}

	@ExceptionHandler()
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ModelAndView exceptionController(HttpServletRequest req, Exception ex) {
		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("exception", ex);
		modelAndView.addObject("url", req.getRequestURL());
		return modelAndView;
	}

}
