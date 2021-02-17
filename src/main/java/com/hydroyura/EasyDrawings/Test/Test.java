package com.hydroyura.EasyDrawings.Test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Test {


	
	@GetMapping("/test")
	public String showPage1(Model model) {
		System.out.println("GET");
		
		String str = (String) model.getAttribute("flag");
		System.out.println(str);
		
		return "/test/page1";
	}
	
	@PostMapping("/test")
	public String showPage1Post(RedirectAttributes redirectAttrs) {
		System.out.println("POSTT");
		redirectAttrs.addFlashAttribute("flag", "my msg");
		return "redirect:/test";
	}
	
	
}
