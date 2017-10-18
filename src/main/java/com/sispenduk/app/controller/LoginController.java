package com.sispenduk.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sispenduk.app.dao.UserDao;
import com.sispenduk.app.dao.UserDao;
import com.sispenduk.app.model.User;
import com.sispenduk.app.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(name = "/login", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		model.setViewName("login");
		return model;
	}

	@RequestMapping(name = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute("user") User user) {
//	public ModelAndView loginProcess(@RequestParam("password") String password, @RequestParam("username") String username) {
		ModelAndView model = new ModelAndView();
		System.out.println(user.getPassword() + " - " + user.getUsername());
		model = loginService.loginProcess(user);

		return model;
	}

	// public ModelAndView welcomePage() {
	//
	// ModelAndView model = new ModelAndView();
	// model.addObject("title", "Spring Security Hello World");
	// model.addObject("message", "This is welcome page!");
	// model.setViewName("welcome");
	// return model;
	// }

	// @RequestMapping(name = "/admin", method = RequestMethod.GET)
	// public ModelAndView adminPage() {
	//
	// ModelAndView model = new ModelAndView();
	// model.addObject("title", "Spring Security Hello World");
	// model.addObject("message", "This is protected page!");
	// model.setViewName("admin");
	//
	// return model;
	// }

}
