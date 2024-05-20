package com.ProjekatMVC.RedVoznje.model;


import java.time.LocalTime;
import java.util.Objects;

public class Voznja {

	private long id;
	private Linija linija;
	private String smer;
	private LocalTime polazak;
	
	public Voznja() {
		super();
	}

	public Voznja(Linija linija, String smer, LocalTime polazak) {
		super();
		this.linija = linija;
		this.smer = smer;
		this.polazak = polazak;
	}

	public Voznja(long id, Linija linija, String smer, LocalTime polazak) {
		super();
		this.id = id;
		this.linija = linija;
		this.smer = smer;
		this.polazak = polazak;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Linija getLinija() {
		return linija;
	}

	public void setLinija(Linija linija) {
		this.linija = linija;
	}

	public String getSmer() {
		return smer;
	}

	public void setSmer(String smer) {
		this.smer = smer;
	}

	public LocalTime getPolazak() {
		return polazak;
	}

	public void setPolazak(LocalTime polazak) {
		this.polazak = polazak;
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
		Voznja other = (Voznja) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Voznja [id=" + id + ", linija=" + linija.getGradski() + ", smer=" + smer + ", polazak=" + polazak + "]";
	}
	
}
