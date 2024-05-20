package com.ProjekatMVC.RedVoznje.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.ProjekatMVC.RedVoznje.model.Voznja;

@Service
public interface VoznjaSevice {

	
	public Voznja findOne(Long id);
	public Collection<Voznja> findAll();
	public Collection<Voznja> findByLinijaId(Long linijaId);
	public Collection<Voznja> findBySmer(String smer);
	public Voznja save(Voznja voznja);
	public Voznja update(Voznja voznja);
	public void delete(long id);
}
