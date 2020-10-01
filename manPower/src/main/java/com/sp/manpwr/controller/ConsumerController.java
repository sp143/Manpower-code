package com.sp.manpwr.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sp.manpwr.dto.ConsumerDTO;
import com.sp.manpwr.dto.LoginDTO;
import com.sp.manpwr.model.Consumer;
import com.sp.manpwr.model.Login;
import com.sp.manpwr.service.ConsumerService;

@Controller
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String createUser(@Validated @ModelAttribute(name = "consumer") ConsumerDTO consumerdto,
			BindingResult bindingResult, Model model) {
		String retu = "registration";
		Optional<Consumer> consExist = consumerService.findUserByEmail(consumerdto.getEmail());
		if (consExist.isPresent()) {
			System.out.println("hello binding");
		//	bindingResult.rejectValue("email", "error.consumer", "This email already exists!");
			 bindingResult.rejectValue("email", "message", "This email already exists!");
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "This email already exists!!");
			retu = "registration";
		} else {
			try {
				
				Consumer newDto=consumerService.createOrUpdateConsumer(consumerdto);
				model.addAttribute("message", "Consumer has been registered successfully!");
				model.addAttribute("consumer", newDto);
				retu = "successRegistration";
			} catch (Exception e) {
				model.addAttribute("message", "Problem in registration");
				retu = "error";
			}
		}

		return retu;
	}

	@RequestMapping(value = { "/loginPage" }, method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("Entered  in controller");
		model.addAttribute("login", new LoginDTO());
		model.addAttribute("message", "Loging if u have account ?");
		return "loginPage";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(@ModelAttribute(name = "login") LoginDTO loginDTO, BindingResult bindingResult, Model model) {

		String retu = "login";
		Optional<Consumer> consExist = null;
		Consumer consumer=null;
		try {
			consExist = consumerService.loginValidation(loginDTO.getUserName(),loginDTO.getPassWord());
			consumer=consExist.get();
		} catch (Exception exe) {
			model.addAttribute("message", "Loging if u have account ?");
			retu = "loginPage";
		}
		if (consumer != null) {
			retu = "dashboard";
			model.addAttribute("fname", consumer.getfName());
		    model.addAttribute("message", "welcome to Manpower Official");
		} else {
			System.out.println("Entered  in controller foe login =");
			System.out.println(" user name for login=" + loginDTO.getUserName());
			// model.addAttribute("login", new LoginDTO());
			model.addAttribute("message", "Invalid credentials, Try again!");
			retu = "loginPage";
		}
		return retu;
	}

	@GetMapping({ "/", "welcome" })
	public String welcome(Model model) {
		return "welcome";
	}

	@GetMapping({ "/register" })
	public String registrationPage(Model model) {
		model.addAttribute("consumer", new ConsumerDTO());
		return "registration";
	}

	@RequestMapping(value = { "/error" }, method = RequestMethod.GET)
	public String errorPage(Model model) {
		System.out.println("Entered  in Error");
		model.addAttribute("message", "Problem in registration");
		return "error";
	}

}
