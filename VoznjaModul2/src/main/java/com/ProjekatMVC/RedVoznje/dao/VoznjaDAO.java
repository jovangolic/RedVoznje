package com.ProjekatMVC.RedVoznje.dao;

import java.util.Collection;

import com.ProjekatMVC.RedVoznje.model.Voznja;



public interface VoznjaDAO {

	
	public Voznja findOne(Long id);
	public Collection<Voznja> findAll();
	public Collection<Voznja> findByLinijaId(Long linijaId);
	public Collection<Voznja> findBySmer(String smer);
	public void save(Voznja voznja);
	public void update(Voznja voznja);
	public void delete(long id);
}
