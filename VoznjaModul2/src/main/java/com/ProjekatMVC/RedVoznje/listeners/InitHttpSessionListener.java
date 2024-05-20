package com.ProjekatMVC.RedVoznje.listeners;



import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Component
public class InitHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("Inicijalizacija sesisje HttpSessionListener...");

		// zadatak 4
		//event.getSession().setAttribute(ParkingKarteController.PARKING_KARTE_KORISNIKA_KEY, new ArrayList<>());
		
		System.out.println("Uspeh HttpSessionListener!");
	}
	
	
	
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Brisanje sesisje HttpSessionListener...");
		
		System.out.println("Uspeh HttpSessionListener!");
	}
}
