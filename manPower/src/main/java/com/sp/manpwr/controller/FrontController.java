package com.sp.manpwr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sp.manpwr.beans.LoginEntity;
import com.sp.manpwr.beans.RoleM;
import com.sp.manpwr.beans.UserDetail;
import com.sp.manpwr.dao.Login;
import com.sp.manpwr.dto.UserCredential;
import com.sp.manpwr.dto.UserDTO;
import com.sp.manpwr.service.LoginService;
import com.sp.manpwr.service.RoleService;
import com.sp.manpwr.service.UserService;
import com.sp.manpwr.util.CutomUtil;

@Controller
public class FrontController {

	@Autowired
	UserService userService;
	@Autowired
	LoginService loginService;
	@Autowired
	RoleService roleService;

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String createUser(@Validated @ModelAttribute(name = "user") UserDTO consumerdto, BindingResult bindingResult,
			Model model) {
		String retu = "registration";
		Optional<UserDetail> userExist = userService.findUserByEmail(consumerdto.getEmail());
		if (userExist.isPresent()) {
			System.out.println("hello binding");
			bindingResult.rejectValue("email", "message", "This email already exists!");
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "This email already exists!!");
			retu = "registration";
		} else {
			try {

				UserDetail newDto = userService.createOrUpdateConsumer(consumerdto);
				UserDTO consDTO = new UserDTO();
				consDTO.setfName(newDto.getfName());

				model.addAttribute("message", "Consumer has been registered successfully!");
				// model.addAttribute("consumer", consDTO);
				retu = "successRegistration";
			} catch (Exception e) {
				model.addAttribute("message", "Problem in registration try after some time !");
				retu = "error";
			}
		}

		return retu;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("Entered  in controller");
		model.addAttribute("login", new UserCredential());
		model.addAttribute("message", "Loging if u have account ?");
		return "loginPage";
	}

	@GetMapping({ "/", "welcome" })
	public String welcome(Model model) {
		return "welcome";
	}

	@ResponseBody
	@GetMapping("welcomeRest")
	public String welcomeRest(Model model) {
		return "welcome";
	}

	@GetMapping({ "/register" })
	public String registrationPage(Model model) {
		List<RoleM> roles = roleService.getAllRoles();
		List<String> listOfDates = new ArrayList<String>();
		for (RoleM rl : roles) {
			listOfDates.add(rl.getRoleName());
		}

		model.addAttribute("user", new UserDTO());
		model.addAttribute("listOfRoles", listOfDates);
		return "registration";
	}

	@RequestMapping("/login-success")
	public RedirectView getLogInSuccessPage(Model model) {
		String redirectPath = "unauthorized-access";
		LoginEntity login = getPrincipal();
		login.setLastLogin(CutomUtil.utilDateToSqlDate(new Date()));
		loginService.updateLoginDetails(login);
		if (login.getRoleM().getRoleName().equals("ADMIN")) {
			redirectPath = "admin_dash";
		} else if (login.getRoleM().getRoleName().equals("USER")) {
			redirectPath = "/user";
		} else {
			redirectPath = "unauthorized-access";
		}

		return new RedirectView(redirectPath);
	}

	@GetMapping("/admin_dash")
	public ModelAndView sentDashBordAdmin(Model model) {
		return new ModelAndView("dashboard");
	}

	@GetMapping("/login_failed")
	public String loginFailed(Model model) {
		model.addAttribute("message", "Invalid credentials..!");
		model.addAttribute("login", new Login());
		return "loginPage";
	}

	@GetMapping("/forgotPassword")
	public ModelAndView showForgotPWD(Model model) {
		return new ModelAndView("forgotPassword");
	}

	@GetMapping("/session-inactive")
	public ModelAndView getSessionErrorPage(Model model) {
		return new ModelAndView("session-inactive");
	}

	private LoginEntity getPrincipal() {
		LoginEntity login = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			login = loginService.findUserByLoginName(((UserDetails) principal).getUsername());
		} else {
			login = (LoginEntity) principal;
		}
		return login;
	}

	@RequestMapping(value = { "/error" }, method = RequestMethod.GET)
	public String errorPage(Model model) {
		System.out.println("Entered  in Error");
		model.addAttribute("message", "Problem in registration");
		return "error";
	}

}
