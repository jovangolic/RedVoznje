package com.ProjekatMVC.RedVoznje.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjekatMVC.RedVoznje.dao.LinijaDAO;
import com.ProjekatMVC.RedVoznje.model.Linija;
import com.ProjekatMVC.RedVoznje.service.LinijaService;


@Service
public class DatabaseLinijaService implements LinijaService {

	@Autowired
	private LinijaDAO linijaDAO;
	
	
	@Override
	public Linija findOne(Long id) {
		return linijaDAO.findOne(id);
	}

	@Override
	public Linija findByBrojLinije(int brojLinije) {
		// TODO Auto-generated method stub
		return linijaDAO.findByBrojLinije(brojLinije);
	}

	@Override
	public Linija findByPolaziste(String polaziste) {
		// TODO Auto-generated method stub
		return linijaDAO.findByPolaziste(polaziste);
	}

	@Override
	public Linija findByGradski(boolean gradski) {
		// TODO Auto-generated method stub
		return linijaDAO.findByGradski(gradski);
	}


	@Override
	public void delete(long id) {
		Linija linija = linijaDAO.findOne(id);
		if(linija != null) {
			linijaDAO.delete(id);
		}
	}

	@Override
	public Collection<Linija> findAll() {
		List<Linija> rezultat = new ArrayList<>();
		Collection<Linija> linije = linijaDAO.findAll();
		for(Linija l : linije) {
			rezultat.add(l);
		}
		return rezultat;
	}

	@Override
	public Linija save(Linija linija) {
		linijaDAO.save(linija);
		return linija;
	}

	@Override
	public Linija update(Linija linija) {
		linijaDAO.update(linija);
		return linija;
	}

}
