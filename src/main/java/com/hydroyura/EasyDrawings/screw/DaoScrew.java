package com.hydroyura.EasyDrawings.screw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hydroyura.EasyDrawings.config.Constants;

@Component
public class DaoScrew {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DaoScrew(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public List<Screw> getScrewsList() {
		
		String query = "SELECT * FROM " + Constants.TABLE_NAME_SCREW_BOLT + ";"; 
		return jdbcTemplate.query(query, new ScrewRowMap());
	}
	
	
	public void deleteScrew(int id) {
		String query = "DELETE FROM " + Constants.TABLE_NAME_SCREW_BOLT + " WHERE " + Constants.TABLE_COLOMN_SCREW_ID + "=?;";
		jdbcTemplate.update(query, id);
	}


	public void addScrew(Screw screw) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_SCREW_BOLT + "( " + 
				Constants.TABLE_COLOMN_SCREW_NUMBER + ", " +
				Constants.TABLE_COLOMN_SCREW_NAME + ", " + 
				Constants.TABLE_COLOMN_SCREW_STANDART + ") VALUES (?, ?, ?);";
		jdbcTemplate.update(query, screw.getNumber(), screw.getName(), screw.getStandart());
	}
	
}
