package com.hydroyura.EasyDrawings.orings;

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
@RequestMapping("/orings")
public class ControllerOrings {
	
	private DaoOrings daoOrings;

	@Autowired
	public ControllerOrings(DaoOrings daoOrings) {
		this.daoOrings = daoOrings;
	}

	@GetMapping("/list")
	public String showOringsListGet(Model model) {
		System.out.println("GET");
		
		FilterOrings filterOrings = (FilterOrings) model.getAttribute("orings_filter");
		if(filterOrings == null) filterOrings = new FilterOrings();
	
		filterOrings.setCrossSectionEnableList(daoOrings.getOringCrossSections());
		filterOrings.setMinInternalDiameterDefault(daoOrings.getOringsMinInternalDiameter());
		filterOrings.setMaxInternalDiameterDefault(daoOrings.getOringsMaxInternalDiameter());
		filterOrings.generateCheckBoxList();
	
		model.addAttribute("orings", daoOrings.getOringsListByFilter(filterOrings));					// надо подумать, может перенести в список колец в filter
		model.addAttribute("crossSectionsEnableList", filterOrings.getCheckBoxList());
		model.addAttribute("crossSectionsEnableList", filterOrings.getCheckBoxList());
		model.addAttribute("minInternalDiameter", filterOrings.getMinInternalDiameter());
		model.addAttribute("maxInternalDiameter", filterOrings.getMaxInternalDiameter());
		model.addAttribute("minInternalDiameterDefault", filterOrings.getMinInternalDiameterDefault());
		model.addAttribute("maxInternalDiameterDefault", filterOrings.getMaxInternalDiameterDefault());
		
		return "/orings/orings_list";
	}
	
	@PostMapping("/list")
	public String showOringsListPostPost(
			@RequestParam(value = "crossSectionsSelectedList", required = true, defaultValue = "-1f") float[] crossSectionsSelectedList, 
			@RequestParam(value = "minInternalDiameter", required = true, defaultValue = "-1f") float minInternalDiameter,
			@RequestParam(value = "maxInternalDiameter", required = true, defaultValue = "-1f") float maxInternalDiameter,
			RedirectAttributes redirectAttributes) {
		System.out.println("POST");
		
		FilterOrings filterOrings = new FilterOrings();
		filterOrings.setCrossSectionsSelectedList(crossSectionsSelectedList);
		filterOrings.setMinInternalDiameter(minInternalDiameter);
		filterOrings.setMaxInternalDiameter(maxInternalDiameter);
		
		redirectAttributes.addFlashAttribute("orings_filter", filterOrings);
	
		return "redirect:/orings/list";
	}
	
	@GetMapping("/index")
	public String showOringsIndex(Model model) {
		return "/orings/orings_index";
	}
	
	@GetMapping("/edit")
	public String showOringsEdit(Model model) {
		model.addAttribute("orings", daoOrings.getOringsList());
		return "/orings/orings_edit";
	}
	
	@GetMapping("/item-delete/{id}")
	public String deleteOring(@PathVariable("id") int id) {
		System.out.println(id);
		daoOrings.deleteOring(id);
		return "redirect:/orings/edit";
	}
	
	@GetMapping("/add")
	public String addOring(Model model) {
		System.out.println("GET - add");
		//String msg = (String) model.getAttribute("msg");
		//model.addAttribute("msg", msg);
		return "/orings/orings_add";
	}
	
	
	@PostMapping("/add")
	public String addOringPost(
			@RequestParam(value = "crossSection", required = true, defaultValue = "-1f") float crossSection,
			@RequestParam(value = "internalDiameter", required = true, defaultValue = "-1f") float internalDiameter,
			@RequestParam(value = "number", required = true, defaultValue = "-1f") String number,
			@RequestParam(value = "standart", required = true, defaultValue = "-1f") String standart,
			RedirectAttributes redirectAttributes) {
		
		System.out.println("POST - add");
		
		String msg;
		boolean flag = true;
		
		if(crossSection ==  -1f) flag = false;
		if(internalDiameter ==  -1f) flag = false;
		if(number.equals("-1f")) flag = false;
		if(standart.equals("-1f")) flag = false;
		
		if(flag) {
			Oring oring = new Oring();
			oring.setCrossSection(crossSection);
			oring.setInternalDiameter(internalDiameter);
			oring.setNumber(number);
			oring.setStandart(standart);
			msg = "Кольцо успешно добавлено в базу";
			daoOrings.addOring(oring);
		} else {
			msg = "Ошибка добавления кольца, попробуйте еще раз";
		}
		
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:/orings/add";
	}
	
}
