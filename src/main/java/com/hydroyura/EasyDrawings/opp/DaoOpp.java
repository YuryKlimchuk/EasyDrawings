package com.hydroyura.EasyDrawings.opp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hydroyura.EasyDrawings.config.Constants;

@Component
public class DaoOpp {

private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DaoOpp(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Opp> getOppList() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_OPP + ";";
		return jdbcTemplate.query(query, new OppRowMap());
	} 
	
	
	public void deleteOpp(int id) {
		String query = "DELETE FROM " + Constants.TABLE_NAME_OPP + " WHERE " + Constants.TABLE_COLOMN_OPP_ID + "=?;";
		jdbcTemplate.update(query, id);
	} 
	
	public int addOpp(Opp opp) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_OPP + " (" 
				+ Constants.TABLE_COLOMN_OPP_NUMBER+ ", " 
				+ Constants.TABLE_COLOMN_OPP_NAME + ", " 
				+ Constants.TABLE_COLOMN_OPP_STATUS + ", " 
				+ Constants.TABLE_COLOMN_OPP_VERSION + ", " 
				+ Constants.TABLE_COLOMN_OPP_UPDATE + ") VALUES (?, ?, ?, ?, ?);";
		return jdbcTemplate.update(query, opp.getNumber(), opp.getName(), opp.getStatus(), opp.getVersion(), opp.getUpdate());
	}
	
}
