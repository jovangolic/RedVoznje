package com.ProjekatMVC.RedVoznje.dao;

import java.util.Collection;

import com.ProjekatMVC.RedVoznje.model.Linija;

public interface LinijaDAO {

	
	public Linija findOne(Long id);
	public Linija findByBrojLinije(int brojLinije);
	public Linija findByPolaziste(String polaziste);
	public Linija findByGradski(boolean gradski);
	public Collection<Linija> findAll();
	public void save(Linija linija);
	public void update(Linija linija);
	public void delete(long id);
	
}
