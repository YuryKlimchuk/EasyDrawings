package com.hydroyura.EasyDrawings.asm;

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
@RequestMapping("/asm")
public class ControllerAsm {
	
	private DaoAsm daoAsm;

	@Autowired
	public ControllerAsm(DaoAsm daoAsm) {
		this.daoAsm = daoAsm;
	}
	
	
	@GetMapping("/index")
	public String showAsmIndex(Model model) {
		return "/asm/asm_index";
	}
	
	
	@GetMapping("/edit")
	public String showAsmEdit(Model model) {
		model.addAttribute("asms", daoAsm.getAsmList());
		return "/asm/asm_edit";
	}
	
	@GetMapping("/item-delete/{id}")
	public String deleteAsm(@PathVariable("id") int id) {
		System.out.println(id);
		daoAsm.deleteAsm(id);
		return "redirect:/asm/edit";
	}
	
	@GetMapping("/list")
	public String showAsmListByFilter(Model model) {
		
		model.addAttribute("asms", daoAsm.getAsmList());
		
		return "/asm/asm_list";
	}
	
	
	@GetMapping("/add")
	public String addAsm(Model model) {
		System.out.println("GET - add");
		return "/asm/asm_add";
	}
	
	@PostMapping("/add")
	public String addasmPost(
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
			Asm asm = new Asm();
			asm.setNumber(number);
			asm.setName(name);
			asm.setStatus(status);
			asm.setVersion(version);
			asm.setUpdate(update);
			msg = "Кольцо успешно добавлено в базу";
			daoAsm.addAsm(asm);
		} else {
			msg = "Ошибка добавления кольца, попробуйте еще раз";
		}
		
		redirectAttributes.addFlashAttribute("msg", msg);
		
		return "redirect:/asm/add";
	}
	
	
	// Состав сборки
	@GetMapping("/composition/{id}")
	public String showAsmComposition(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
		
		Asm asm = daoAsm.getAsmById(id);
		
		model.addAttribute("asm", asm);
		model.addAttribute("orings_in_asm", daoAsm.getOringsInAsm(id));
		model.addAttribute("opps_in_asm", daoAsm.getOppsInAsm(id));
		model.addAttribute("vzks_in_asm", daoAsm.getVzkInAsm(id));
		model.addAttribute("asms_in_asm", daoAsm.getAsmsInAsm(id));
		
		
		asm.setAsmList(daoAsm.getAsmsInAsm(id));
		asm.setOppList(daoAsm.getOppsInAsm(id));
		asm.setOringList(daoAsm.getOringsInAsm(id));
		asm.setVzkList(daoAsm.getVzkInAsm(id));
		
		

		
		redirectAttributes.addFlashAttribute("asm", asm);
		return "/asm/asm_composition";
	}
	
	
	@GetMapping("composition/full-composition/{id}")
	public String showAsmFullComposition(@PathVariable("id") int id, Model model) {
		
		Asm asm = (Asm) model.getAttribute("asm");
		System.out.println(asm.getName());
		
		return "asm/asm_composition-full";
	}
	
	

}
