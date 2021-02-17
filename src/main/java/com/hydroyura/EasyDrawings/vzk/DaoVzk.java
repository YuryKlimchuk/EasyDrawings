package com.hydroyura.EasyDrawings.vzk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hydroyura.EasyDrawings.config.Constants;

@Component
public class DaoVzk {

private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DaoVzk(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Vzk> getVzkList() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_VZK + ";";
		return jdbcTemplate.query(query, new VzkRowMap());
	} 
		
	public void deleteVzk(int id) {
		String query = "DELETE FROM " + Constants.TABLE_NAME_VZK + " WHERE " + Constants.TABLE_COLOMN_VZK_ID + "=?;";
		jdbcTemplate.update(query, id);
	} 
	
	public int addVzk(Vzk vzk) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_VZK + " (" 
				+ Constants.TABLE_COLOMN_VZK_NUMBER+ ", " 
				+ Constants.TABLE_COLOMN_VZK_NAME + ") VALUES (?, ?);";
		return jdbcTemplate.update(query, vzk.getNumber(), vzk.getName());
	}
	
}
