package com.ProjekatMVC.RedVoznje.listeners;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import com.ProjekatMVC.RedVoznje.controller.LinijaController;
import com.ProjekatMVC.RedVoznje.controller.VoznjaController;
import com.ProjekatMVC.RedVoznje.model.Linija;
import com.ProjekatMVC.RedVoznje.model.Voznja;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

@Component
public class InitServletContextInitializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Map<Long, Linija> linije = new LinkedHashMap<>();
		Linija l1 = new Linija(1L,1,"Klisa","Liman 1",true);
		Linija l2 = new Linija(2L,2,"Centar","Novo Naselje",false);
		Linija l3 = new Linija(3L,21,"Centar","Šangaj",false);
		linije.put(1L,l1);
		linije.put(2L,l2);
		linije.put(3L, l3);
		servletContext.setAttribute(LinijaController.LINIJA_KEY, linije);
		
		Map<Long, Voznja> voznje = new LinkedHashMap<>();
		voznje.put(1L, new Voznja(1L,l1,"A (Klisa - Liman 1)",LocalTime.of(8, 0)));
		voznje.put(2L, new Voznja(2L,l1,"A (Klisa - Liman 1)",LocalTime.of(9, 0)));
		voznje.put(3L, new Voznja(3L,l1,"B (Liman 1 - Klisa)",LocalTime.of(8, 10)));
		voznje.put(4L, new Voznja(4L,l1,"B (Liman 1 - Klisa)",LocalTime.of(9, 10)));
		voznje.put(5L, new Voznja(5L,l2,"A (Centar - Novo naselje)",LocalTime.of(8, 05)));
		voznje.put(6L, new Voznja(6L,l2,"A (Centar - Novo naselje)", LocalTime.of(9, 05)));
		voznje.put(7L, new Voznja(7L,l2,"B (Novo naselje - Centar)",LocalTime.of(8, 15)));
		voznje.put(8L, new Voznja(8L,l2,"B (Novo naselje - Centar)",LocalTime.of(9, 15)));
		voznje.put(9L, new Voznja(9L,l3,"A (Centar - Šangaj)",LocalTime.of(8, 15)));
		voznje.put(10L, new Voznja(10L,l3,"A (Centar - Šangaj)",LocalTime.of(9, 15)));
		voznje.put(11L, new Voznja(11L,l3,"B (Šangaj - Centar)",LocalTime.of(8, 15)));
		voznje.put(12L, new Voznja(12L,l3,"B (Šangaj - Centar)", LocalTime.of(9, 15)));
		servletContext.setAttribute(VoznjaController.VOZNJA_KEY, voznje);
		System.out.println("Uspeh ServletContextInitializer!");
	}

}






