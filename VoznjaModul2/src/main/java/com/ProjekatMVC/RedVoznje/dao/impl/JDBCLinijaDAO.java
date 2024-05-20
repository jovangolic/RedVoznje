package com.ProjekatMVC.RedVoznje.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ProjekatMVC.RedVoznje.dao.LinijaDAO;
import com.ProjekatMVC.RedVoznje.model.Linija;



@Repository
public class JDBCLinijaDAO implements LinijaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private class LinijaRowMapper implements RowMapper<Linija>{

		@Override
		public Linija mapRow(ResultSet rs, int rowNum) throws SQLException {
			int kol = 0;
			Long id = rs.getLong(++kol);
			int redniBroj = rs.getInt(++kol);
			String polaziste = rs.getString(++kol);
			String odrediste = rs.getString(++kol);
			Boolean gradski = rs.getBoolean(++kol);
			Linija linija = new Linija(id, redniBroj, polaziste, odrediste, gradski);
			return linija;
		}
		
	}
	
	@Override
	public Linija findOne(Long id) {
		String sql = "select id, redni_broj, polaziste, odrediste, gradski from linije where id = ?";
		List<Linija> rezultat = jdbcTemplate.query(sql, new LinijaRowMapper(), id);
		return !rezultat.isEmpty() ? rezultat.get(0) : null;
	}

	@Override
	public Linija findByBrojLinije(int brojLinije) {
		String sql = "select id, redni_broj, polaziste, odrediste, gradski from linije where redni_broj = ?";
		List<Linija> rezultat = jdbcTemplate.query(sql, new LinijaRowMapper(), brojLinije);
		return !rezultat.isEmpty() ? rezultat.get(0) : null;
	}

	@Override
	public Linija findByPolaziste(String polaziste) {
		String sql = "select id, redni_broj, polaziste, odrediste,gradski from linije where polaziste = ?";
		List<Linija> rezultat = jdbcTemplate.query(sql, new LinijaRowMapper(), polaziste);
		return !rezultat.isEmpty() ? rezultat.get(0) : null;
	}

	@Override
	public Linija findByGradski(boolean gradski) {
		String sql = "select id, redni_broj, polaziste, odrediste, gradski from linije where gradski = ?";
		List<Linija> rezultat = jdbcTemplate.query(sql,  new LinijaRowMapper(), gradski);
		return !rezultat.isEmpty() ? rezultat.get(0) : null;
	}

	@Override
	public Collection<Linija> findAll() {
		String sql = "select id, redni_broj, polaziste, odrediste, gradski from linije";
		return jdbcTemplate.query(sql, new LinijaRowMapper());
	}

	@Override
	public void save(Linija linija) {
		String sql = "insert into linije (id, redni_broj, polaziste, odrediste, gradski) values(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, linija.getId(),linija.getRedni_broj(), linija.getPolaziste(), linija.getOdrediste(), linija.getGradski());
	}

	@Override
	public void update(Linija linija) {
		String sql = "update linije set redni_broj = ?, polaziste = ?, odrediste = ?, gradski = ? where id = ?";
		jdbcTemplate.update(sql, linija.getRedni_broj(), linija.getPolaziste(), linija.getOdrediste(), linija.getGradski(), linija.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "delete from linije where id = ?";
		jdbcTemplate.update(sql, id);
	}

}
