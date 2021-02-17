package com.hydroyura.EasyDrawings.opp;

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
@RequestMapping("/opp")
public class ControllerOpp {
	
	private DaoOpp daoOpp;

	@Autowired
	public ControllerOpp(DaoOpp daoOpp) {
		this.daoOpp = daoOpp;
	}
	
	
	@GetMapping("/index")
	public String showOppIndex(Model model) {
		return "/opp/opp_index";
	}
	
	
	@GetMapping("/edit")
	public String showOppEdit(Model model) {
		model.addAttribute("opps", daoOpp.getOppList());
		return "/opp/opp_edit";
	}
	
	@GetMapping("/item-delete/{id}")
	public String deleteOring(@PathVariable("id") int id) {
		System.out.println(id);
		daoOpp.deleteOpp(id);
		return "redirect:/opp/edit";
	}
	
	@GetMapping("/list")
	public String showOppListByFilter(Model model) {
		
		model.addAttribute("opps", daoOpp.getOppList());
		
		return "/opp/opp_list";
	}
	
	
	@GetMapping("/add")
	public String addOpp(Model model) {
		System.out.println("GET - add");
		return "/opp/opp_add";
	}
	
	@PostMapping("/add")
	public String addOppPost(
			@RequestParam(value = "number", required = true, defaultValue = "-1f") String number,
			@RequestParam(value = "name", required = true, defaultValue = "-1f") String name,
			@RequestParam(value = "status", required = true, defaultValue = "-1f") String status,
			@RequestParam(value = "version", required = true, defaultValue = "-1f") String version,
			@RequestParam(value = "update", required = true, defaultValue = "-1f") String update,
			RedirectAttributes redirectAttributes) {
		System.out.println("POST - add");

		String msg;
		boolean flag = true;
	
		if(number.equals("-1f")) flag = false;
		if(name.equals("-1f")) flag = false;
		if(status.equals("-1f")) flag = false;
		if(version.equals("-1f")) version = "";
		if(update.equals("-1f")) flag = false;

		
		if(flag) {
			Opp opp = new Opp();
			opp.setNumber(number);
			opp.setName(name);
			opp.setStatus(status);
			opp.setVersion(version);
			opp.setUpdate(update);
			msg = "Кольцо успешно добавлено в базу";
			daoOpp.addOpp(opp);
		} else {
			msg = "Ошибка добавления кольца, попробуйте еще раз";
		}
		
		redirectAttributes.addFlashAttribute("msg", msg);
		
		return "redirect:/opp/add";
	}
	
	
	
	

}
