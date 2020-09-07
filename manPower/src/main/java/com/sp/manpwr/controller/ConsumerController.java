package com.sp.manpwr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sp.manpwr.model.Consumer;
import com.sp.manpwr.service.ConsumerService;

@Controller
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute Consumer consumer, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		Consumer consExist = consumerService.findUserByEmail(consumer.getEmail());

		if (consExist != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exists!");
		}
		if (bindingResult.hasErrors()) {
			model.setViewName("signup");
		} else {
			try {
			consumerService.createOrUpdateConsumer(consumer);
			model.addObject("msg", "Consumer has been registered successfully!");
			model.addObject("consumer", new Consumer());
			model.setViewName("successRegistration");
			}catch (Exception e) {
				model.setViewName("error");
			}
		}

		return model;
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login() {
		System.out.println("Entered  in controller");
		return "login";
	}

	@RequestMapping(value = { "/error" }, method = RequestMethod.GET)
	public ModelAndView errorPage() {
		System.out.println("Entered  in Error");
		ModelAndView model = new ModelAndView();

		model.setViewName("error");
		return model;
	}

}
