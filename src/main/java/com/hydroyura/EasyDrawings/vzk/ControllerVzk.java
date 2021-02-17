package com.hydroyura.EasyDrawings.vzk;

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
@RequestMapping("/vzk")
public class ControllerVzk {
	
	private DaoVzk daoVzk;

	@Autowired
	public ControllerVzk(DaoVzk daoVzk) {
		this.daoVzk = daoVzk;
	}
	
	
	@GetMapping("/index")
	public String showVzkIndex(Model model) {
		return "/vzk/vzk_index";
	}
	
	
	@GetMapping("/edit")
	public String showVzkEdit(Model model) {
		model.addAttribute("vzks", daoVzk.getVzkList());
		return "/vzk/vzk_edit";
	}
	
	@GetMapping("/item-delete/{id}")
	public String deleteVzk(@PathVariable("id") int id) {
		System.out.println(id);
		daoVzk.deleteVzk(id);
		return "redirect:/vzk/edit";
	}
	
	@GetMapping("/list")
	public String showvzkListByFilter(Model model) {
		
		model.addAttribute("vzks", daoVzk.getVzkList());
		
		return "/vzk/vzk_list";
	}
	
	
	@GetMapping("/add")
	public String addVzk(Model model) {
		System.out.println("GET - add");
		return "/vzk/vzk_add";
	}
	
	@PostMapping("/add")
	public String addVzkPost(
			@RequestParam(value = "number", required = true, defaultValue = "-1f") String number,
			@RequestParam(value = "name", required = true, defaultValue = "-1f") String name,
			RedirectAttributes redirectAttributes) {
		System.out.println("POST - add");

		String msg;
		boolean flag = true;
	
		if(number.equals("-1f")) flag = false;
		if(name.equals("-1f")) flag = false;

		if(flag) {
			Vzk vzk = new Vzk();
			vzk.setNumber(number);
			vzk.setName(name);
			msg = "Кольцо успешно добавлено в базу";
			daoVzk.addVzk(vzk);
		} else {
			msg = "Ошибка добавления кольца, попробуйте еще раз";
		}
		
		redirectAttributes.addFlashAttribute("msg", msg);
		
		return "redirect:/vzk/add";
	}
	
	
	
	

}
