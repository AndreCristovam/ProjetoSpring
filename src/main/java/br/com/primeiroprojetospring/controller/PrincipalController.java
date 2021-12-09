package br.com.primeiroprojetospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("principal")
public class PrincipalController {
	
	@GetMapping
	public ModelAndView chamaPaginaPrincipal() {
		ModelAndView mView = new ModelAndView("index");
		return mView;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mView = new ModelAndView("login");
		return mView;
	}
}
