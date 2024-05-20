package com.ProjekatMVC.RedVoznje.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import com.ProjekatMVC.RedVoznje.dao.LinijaDAO;
import com.ProjekatMVC.RedVoznje.dao.VoznjaDAO;
import com.ProjekatMVC.RedVoznje.model.Linija;
import com.ProjekatMVC.RedVoznje.model.Voznja;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/Voznje")
public class VoznjaController  implements ServletContextAware{
	
	
	public static final String VOZNJA_KEY = "voznje";
	public static final String LINIJA_KEY = "linije";
	public static final String PRIGRADSKI_KEY = "prigradski";
	public static final String GRADSKI_KEY = "gradski";
	
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private LinijaDAO linijaDAO;
	
	@Autowired
	private VoznjaDAO voznjaDAO;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	
	@PostMapping(value="/Create")
	public String zadatak2(@RequestParam Long linijaId, @RequestParam String smer, @RequestParam String polazakStr ,HttpSession session) throws IOException{
		if(linijaId == null) {
			return "zadatak3";
		}
		LocalTime polazak = LocalTime.parse(polazakStr);
		//pristupanje servelt context-u
		Map<Long, Linija> linije = (Map<Long, Linija>)servletContext.getAttribute(VoznjaController.LINIJA_KEY);
		Map<Long, Voznja> voznje = (Map<Long, Voznja>)servletContext.getAttribute(VoznjaController.VOZNJA_KEY);
		//trazenje linije
		Linija linija = linije.get(linijaId);
		//inkrementacija id
		long id = voznje.values().size() + 1;
		//kreiranje nove voznje
		Voznja voznja = new Voznja(id, linija, smer, polazak);
		voznje.put(voznja.getId(), voznja);
		//iteracija i ispis svih voznji
		for(Voznja v : voznje.values()) {
			System.out.println(v);
		}
		
		LocalTime v1 = LocalTime.of(0, 0);
		LocalTime v2 = LocalTime.of(4, 0);
		if(!linija.getGradski() && (polazak.isAfter(v1) || polazak.isBefore(v2))) {
			return "redirect:/zadatak2";
		}
		
		int brojGradskihVoznji = (int)servletContext.getAttribute(VoznjaController.GRADSKI_KEY);
		int brojPrigradskihVoznji = (int)servletContext.getAttribute(VoznjaController.PRIGRADSKI_KEY);
		if(linija.getGradski() == true) {
			brojGradskihVoznji++;
			servletContext.setAttribute(VoznjaController.GRADSKI_KEY, brojGradskihVoznji);
		}
		else {
			brojPrigradskihVoznji++;
			servletContext.setAttribute(VoznjaController.PRIGRADSKI_KEY, brojPrigradskihVoznji);
		}
		
		//zadatak 4
		Map<Long, Linija> lines = (Map<Long, Linija>)servletContext.getAttribute(VoznjaController.LINIJA_KEY);
		lines.put(linija.getId(), linija);
		return "redirect:/Voznje/Zadatak3";
	}
	
	@GetMapping(value="/Zadatak3")
	public String zadatak3(ModelMap model, HttpSession session) throws IOException{
		
		//Map<Long, Voznja> voznje = (Map<Long, Voznja>)servletContext.getAttribute(VoznjaController.VOZNJA_KEY);
		//model.addAttribute("voznje", voznje.values());
		Collection<Voznja> voznje = voznjaDAO.findAll();
		model.addAttribute("voznje", voznje);
		
		//dodatak zadatka 3 brojac za gradski i prigradski saobracaj
		int gradski = 0;
		int prigradski = 0;
		for(Voznja v : voznje) {
			if(v.getLinija().getGradski() == true) {
				gradski++;
			}
			else {
				prigradski++;
			}
		}
		model.addAttribute("gradski", gradski);
		model.addAttribute("prigradski", prigradski);
		
		//zadatak 4 ispis linija
		/*Map<Long, Linija> lines = (Map<Long, Linija>)servletContext.getAttribute(VoznjaController.LINIJA_KEY);
		for(Linija l : lines.values()) {
			System.out.println(l);
		}
		model.addAttribute("lines", lines);*/
		Collection<Linija> lines = linijaDAO.findAll();
		for(Linija l : lines) {
			System.out.println(l);
		}
		model.addAttribute("lines", lines);
		return "zadatak3";
	}
	
	
	@GetMapping(value="/Zadatak5")
	public String zadatak5(@RequestParam( required =  false) Long linijaId, ModelMap model, HttpSession session) throws IOException{
		
		Collection<Voznja> voznje = voznjaDAO.findByLinijaId(linijaId);
		for(Voznja v : voznje) {
			System.out.println(v);
		}
		System.out.println();
		model.addAttribute("voznje", voznje);
		return "zadatak5";
	}
}
