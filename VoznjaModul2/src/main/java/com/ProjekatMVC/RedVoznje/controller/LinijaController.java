package com.ProjekatMVC.RedVoznje.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import com.ProjekatMVC.RedVoznje.dao.LinijaDAO;
import com.ProjekatMVC.RedVoznje.model.Linija;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/Linije")
public class LinijaController implements ServletContextAware {

	
	public static final String LINIJA_KEY = "linije";
	
	@Autowired
	private LinijaDAO linijaDAO;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	
	/*//metoda za kreiranje nove linije
	@PostMapping(value="/Create")
	public String zadatak7(@RequestParam int redni_broj, @RequestParam String polaziste, @RequestParam String odrediste, @RequestParam boolean gradski,
			HttpSession session) throws IOException{
		Map<Long, Linija> linije = (Map<Long, Linija>)servletContext.getAttribute(LinijaController.LINIJA_KEY);
		//povecavanje id
		long id = linije.values().size() + 1;
		//kreiranje nove linije
		Linija linija = new Linija(id, redni_broj, polaziste, odrediste, gradski);
		linije.put(linija.getId(), linija);
		//iteracija
		for(Linija l : linije.values()) {
			System.out.println(l);
		}
		System.out.println();
		
		return "redirect:/Linije/Zadatak7";
	}*/
	
	
	@PostMapping(value="/Create")
	public String zadatak7(@Validated @ModelAttribute Linija linija, BindingResult result, HttpSession session, ModelMap model) throws IOException {
		
		Map<Long, Linija> linije = (Map<Long, Linija>)servletContext.getAttribute(LinijaController.LINIJA_KEY);
		if(result.hasErrors()) {
			model.addAttribute("linije", linije);
			return "zadatak6";
		}
		long id = linije.size() + 1;
		linija.setId(id);
		linije.put(linija.getId(), linija);
		servletContext.setAttribute(LinijaController.LINIJA_KEY, linije);
		linijaDAO.save(linija);
		return "redirect:/Linije/Zadatak7";
	}
	
	//metoda za ispis
	@GetMapping(value="/Zadatak7")
	public String ispis(ModelMap model, HttpSession session) {
		
		//Collection<Linija> linije = linijaDAO.findAll();
		Map<Long, Linija> linije = (Map<Long, Linija>)servletContext.getAttribute(LinijaController.LINIJA_KEY);
		for(Linija l : linije.values()) {
			System.out.println(l);
		}
		model.addAttribute("liinje", linije.values());
		model.addAttribute("linijaDAO", linijaDAO.findAll());
		return "zadatak7";
	}
	
}
