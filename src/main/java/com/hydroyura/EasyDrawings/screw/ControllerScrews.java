package com.hydroyura.EasyDrawings.screw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/screw")
public class ControllerScrews {
	
	private DaoScrew daoScrew;
	
	@Autowired
	public ControllerScrews(DaoScrew daoScrew) {
		this.daoScrew = daoScrew;
	}

	@GetMapping("/index")
	public String showScrewIndex(Model model) {
		return "/screw/screw_index";
	}
	
	@GetMapping("/edit")
	public String showScrewEdit(Model model) {
		model.addAttribute("screws", daoScrew.getScrewsList());
		return "/screw/screw_edit";
	}
	
	@GetMapping("/item-delete/{id}")
	public String deleteScrew(@PathVariable("id") int id) {
		daoScrew.deleteScrew(id);
		return "redirect:/screw/edit";
	}
	
	@GetMapping("/add") 
	public String addScrew(Model model) {
		
		return "/screw/screw_add";
	}
	
	
	@PostMapping("/add")
	public String addScrewPost(
			@RequestParam(value = "number", required = true, defaultValue = "-1f") String number,
			@RequestParam(value = "name", required = true, defaultValue = "-1f") String name,
			@RequestParam(value = "standart", required = true, defaultValue = "-1f") String standart,
			RedirectAttributes redirectAttributes) {
		
		String msg;
		boolean flag = true;
		
		if(number.equals("-1f")) flag = false;
		if(name.equals("-1f")) flag = false;
		if(standart.equals("-1f")) flag = false;
		
		if(flag) {
			Screw screw = new Screw();
			screw.setNumber(number);
			screw.setName(name);
			screw.setStandart(standart);
			msg = "Кольцо успешно добавлено в базу";
			daoScrew.addScrew(screw);
		} else {
			msg = "Ошибка добавления кольца, попробуйте еще раз";
		}
		
		redirectAttributes.addFlashAttribute("msg", msg);
		
		return "redirect:/screw/add";
	}
	
	

}
