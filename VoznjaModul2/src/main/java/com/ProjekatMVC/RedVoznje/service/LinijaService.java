package com.ProjekatMVC.RedVoznje.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.ProjekatMVC.RedVoznje.model.Linija;

@Service
public interface LinijaService {

	
	public Linija findOne(Long id);
	public Linija findByBrojLinije(int brojLinije);
	public Linija findByPolaziste(String polaziste);
	public Linija findByGradski(boolean gradski);
	public Collection<Linija> findAll();
	public Linija save(Linija linija);
	public Linija update(Linija linija);
	public void delete(long id);
}
