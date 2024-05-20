package com.ProjekatMVC.RedVoznje.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjekatMVC.RedVoznje.dao.VoznjaDAO;
import com.ProjekatMVC.RedVoznje.model.Voznja;
import com.ProjekatMVC.RedVoznje.service.VoznjaSevice;


@Service
public class DatabaseVoznjaService implements VoznjaSevice {

	@Autowired
	private VoznjaDAO voznjaDAO;
	
	@Override
	public Voznja findOne(Long id) {
		// TODO Auto-generated method stub
		return voznjaDAO.findOne(id);
	}

	@Override
	public Collection<Voznja> findAll() {
		Collection<Voznja> voznje = voznjaDAO.findAll();
		List<Voznja> rezultat = new ArrayList<>();
		for(Voznja v : voznje) {
			rezultat.add(v);
		}
		return rezultat;
	}

	@Override
	public Collection<Voznja> findByLinijaId(Long linijaId) {
		Collection<Voznja> voznje = voznjaDAO.findAll();
		List<Voznja> rezultat = new ArrayList<>();
		for(Voznja v : voznje) {
			if(v.getLinija().getId() == linijaId) {
				rezultat.add(v);
			}
		}
		return rezultat;
	}

	@Override
	public Collection<Voznja> findBySmer(String smer) {
		Collection<Voznja> voznje = voznjaDAO.findAll();
		List<Voznja> rezultat = new ArrayList<>();
		for(Voznja v : voznje) {
			if(v.getSmer().equals(smer)) {
				rezultat.add(v);
			}
		}
		return rezultat;
	}

	@Override
	public Voznja save(Voznja voznja) {
		voznjaDAO.save(voznja);
		return voznja;
	}

	@Override
	public Voznja update(Voznja voznja) {
		voznjaDAO.update(voznja);
		return voznja;
	}

	@Override
	public void delete(long id) {
		
	}

}
