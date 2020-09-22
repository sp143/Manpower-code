package com.sp.manpwr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String createUser(@ModelAttribute(name = "consumer") ConsumerDTO consumerdto, BindingResult bindingResult,
			Model model) {
		String retu = "registration";
		Consumer consExist = consumerService.findUserByEmail(consumerdto.getEmail());
		if (consExist != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exists!");
		}
		if (bindingResult.hasErrors()) {
			retu = "registration";
		} else {
			try {
				Consumer consumer = new Consumer();
				consumerService.createOrUpdateConsumer(consumer);
				model.addAttribute("message", "Consumer has been registered successfully!");
				model.addAttribute("consumer", consumer);
				retu = "successRegistration";
			} catch (Exception e) {
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
		Consumer consExist = null;
		try {
			consExist = consumerService.findUserByEmail(loginDTO.getUserName());
		} catch (Exception exe) {
			model.addAttribute("message", "Loging if u have account ?");
			retu = "loginPage";
		}
		if (consExist != null) {
			retu = "dashboard";
			model.addAttribute("fname", consExist.getfName());
			// model.addAttribute("message", "Loging if u have account ?");
		}
		System.out.println("Entered  in controller foe login =");
		System.out.println(" user name for login=" + loginDTO.getUserName());
		model.addAttribute("login", new LoginDTO());
		model.addAttribute("message", "Try again!");
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
	public ModelAndView errorPage() {
		System.out.println("Entered  in Error");
		ModelAndView model = new ModelAndView();

		model.setViewName("error");
		return model;
	}

}
