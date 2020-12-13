package com.nursery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/api/index")
public class IndexController {

	@RequestMapping("/home")
	public ModelAndView toIndex() {
		ModelAndView modelAndView = new ModelAndView("/home");
		//
		return modelAndView;
	}

	@RequestMapping("/change")
	public ModelAndView chagePages(@RequestParam("name") String name) {
		ModelAndView modelAndView = new ModelAndView(name);
		//
		return modelAndView;
	}

}
