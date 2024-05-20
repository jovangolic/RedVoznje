package com.ProjekatMVC.RedVoznje.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ProjekatMVC.RedVoznje.dao.LinijaDAO;
import com.ProjekatMVC.RedVoznje.dao.VoznjaDAO;
import com.ProjekatMVC.RedVoznje.model.Linija;
import com.ProjekatMVC.RedVoznje.model.Voznja;


@Repository
public class JDBCVoznjaDAO implements VoznjaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private LinijaDAO linijaDAO;
	
	private class VoznjaRowMapper implements RowMapper<Voznja>{

		@Override
		public Voznja mapRow(ResultSet rs, int rowNum) throws SQLException {
			int kol = 0;
			Long id = rs.getLong(++kol);
			Long linijaId = rs.getLong(++kol);
			Linija linija = linijaDAO.findOne(linijaId);
			String smer = rs.getString(++kol);
			LocalTime polazak = rs.getTime(++kol).toLocalTime();
			Voznja voznja = new Voznja(id, linija, smer, polazak);
			return voznja;
		}
	}
	
	@Override
	public Voznja findOne(Long id) {
		String sql = "select id, linijaId, smer, polazak from voznje where id = ?";
		List<Voznja> rezultat = jdbcTemplate.query(sql, new VoznjaRowMapper(), id);
		return !rezultat.isEmpty() ? rezultat.get(0) : null;
	}

	@Override
	public Collection<Voznja> findAll() {
		String sql = "select id, linijaId, smer, polazak from voznje";
		return jdbcTemplate.query(sql, new VoznjaRowMapper());
	}

	@Override
	public Collection<Voznja> findByLinijaId(Long linijaId) {
		String sql = "select id, linijaId, smer, polazak from voznje where linijaId = ?";
		return jdbcTemplate.query(sql, new VoznjaRowMapper(), linijaId);
	}

	@Override
	public Collection<Voznja> findBySmer(String smer) {
		String sql = "select id, linijaId, smer, polazak from voznje where smer = ?";
		return jdbcTemplate.query(sql, new VoznjaRowMapper(), smer);
	}

	@Override
	public void save(Voznja voznja) {
		String sql = "insert into voznje (id, linijaId, smer, polazak) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql,voznja.getId(),voznja.getLinija().getId(), voznja.getSmer(), voznja.getPolazak());
	}

	@Override
	public void update(Voznja voznja) {
		String sql = "update voznje set linijaId = ?, smer = ?, polazak = ? where id = ?";
		jdbcTemplate.update(sql, voznja.getLinija().getId(), voznja.getSmer(), voznja.getPolazak(), voznja.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "delete from voznje where id = ?";
		jdbcTemplate.update(sql, id);
	}

}
