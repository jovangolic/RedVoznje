package com.ProjekatMVC.RedVoznje.model;

import java.util.Objects;

public class Linija {

	private long id;
	private int redni_broj;
	private String polaziste;
	private String odrediste;
	private Boolean gradski;
	
	public Linija() {
		super();
	}

	public Linija(int redni_broj, String polaziste, String odrediste, Boolean gradski) {
		super();
		this.redni_broj = redni_broj;
		this.polaziste = polaziste;
		this.odrediste = odrediste;
		this.gradski = gradski;
	}

	public Linija(long id, int redni_broj, String polaziste, String odrediste, Boolean gradski) {
		super();
		this.id = id;
		this.redni_broj = redni_broj;
		this.polaziste = polaziste;
		this.odrediste = odrediste;
		this.gradski = gradski;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRedni_broj() {
		return redni_broj;
	}

	public void setRedni_broj(int redni_broj) {
		this.redni_broj = redni_broj;
	}

	public String getPolaziste() {
		return polaziste;
	}

	public void setPolaziste(String polaziste) {
		this.polaziste = polaziste;
	}

	public String getOdrediste() {
		return odrediste;
	}

	public void setOdrediste(String odrediste) {
		this.odrediste = odrediste;
	}

	public Boolean getGradski() {
		return gradski;
	}

	public void setGradski(Boolean gradski) {
		this.gradski = gradski;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linija other = (Linija) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Linija [id=" + id + ", redni_broj=" + redni_broj + ", polaziste=" + polaziste + ", odrediste="
				+ odrediste + ", gradski=" + gradski + "]";
	}
	
}
