package com.trysol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trysol.model.TrysolWebApp;
import com.trysol.service.TrysolService;

@Controller
public class TrysolController {

	@Autowired
	private TrysolService trysolService;

	@GetMapping("/contact")
	public String showform(Model m) {
		m.addAttribute("webApp", new TrysolWebApp());
		return "contactus";
	}
	@PostMapping("/contactus-submit")
	public String storeEntity(@Validated @ModelAttribute("webApp") TrysolWebApp webApp) {
		trysolService.saveResponse(webApp);
		return "saved-success";
	}

	@PostMapping("/view")
	public String removeResponse(@PathVariable Integer id) {
		trysolService.removeResponse(id);
		return "removed successfully";

	}

	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}

	@GetMapping("/aboutus")
	public String getAboutUsPage() {
		return "aboutus";
	}


	@GetMapping("/services")
	public String servicesPage() {
		return "services";
	}

	@GetMapping("/clients")
	public String clientsPage() {
		return "clients";
	}

}
