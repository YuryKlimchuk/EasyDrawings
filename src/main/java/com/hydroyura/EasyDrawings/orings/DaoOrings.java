package com.hydroyura.EasyDrawings.orings;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.hydroyura.EasyDrawings.config.Constants;

@Component
public class DaoOrings {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DaoOrings(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Oring> getOringsList() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ORINGS + ";";
		return jdbcTemplate.query(query, new OringRowMap());
	} 
	
	public int addOring(Oring oring) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ORINGS + " (" 
				+ Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + ", " 
				+ Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + ", " 
				+ Constants.TABLE_COLOMN_ORINGS_NUMBER + ", " 
				+ Constants.TABLE_COLOMN_ORINGS_STANDART + ") VALUES (?, ?, ?, ?);";
				
		return jdbcTemplate.update(query, 
				oring.getCrossSection(), 
				oring.getInternalDiameter(),
				oring.getNumber(),
				oring.getStandart());
	}
	
	public List<Oring> getOringsListByFilter(FilterOrings filterOrings) {
		//String query = "SELECT * FROM " + Constants.TABLE_NAME_ORINGS + ";";
		
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ORINGS + " WHERE " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + " IN (";
		
		if((filterOrings.getCrossSectionsSelectedList().length == 1) && (filterOrings.getCrossSectionsSelectedList()[0] == -1f)) {
			
			for (Float diameter : filterOrings.getCrossSectionEnableList()) {
				query = query + "'" + diameter + "',";
			}
		} else {
			
			for (Float diameter : filterOrings.getCrossSectionsSelectedList()) {
				query = query + "'" + diameter + "',";
			}
		}

		query = query.substring(0, query.length()-1);
		
		float minDiameter = (filterOrings.getMinInternalDiameter() == -1f) ? filterOrings.getMinInternalDiameterDefault() : filterOrings.getMinInternalDiameter();
		float maxDiameter = (filterOrings.getMaxInternalDiameter() == -1f) ? filterOrings.getMaxInternalDiameterDefault() : filterOrings.getMaxInternalDiameter();
		
		query = query + ") AND " 
				+ Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + " BETWEEN " 
				+ "'" + minDiameter
				+ "' AND " + "'" + maxDiameter + "' ORDER BY " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + ";";
		
		System.out.println("query " + query);
		
		return jdbcTemplate.query(query, new OringRowMap());
	} 
	
	
	public float[] getOringCrossSections() {
		
		String query = "SELECT DISTINCT " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + " FROM " + Constants.TABLE_NAME_ORINGS 
				+ " ORDER BY " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + ";";
		
		List<Float> floatList = jdbcTemplate.queryForList(query, Float.class);
		float[] floatArr = new float[floatList.size()];
		
		for (int i = 0; i < floatList.size(); i++) floatArr[i] = floatList.get(i);
		
		return floatArr;
	}
	
	public Float getOringsMinInternalDiameter() {
		String query = "SELECT MIN(" + Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + ") FROM " + Constants.TABLE_NAME_ORINGS + ";";
		return jdbcTemplate.queryForObject(query, Float.class);
	}
	
	public Float getOringsMaxInternalDiameter() {
		String query = "SELECT MAX(" + Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + ") FROM " + Constants.TABLE_NAME_ORINGS + ";";
		return jdbcTemplate.queryForObject(query, Float.class);
	}
	
	public void deleteOring(int id) {
		String query = "DELETE FROM " + Constants.TABLE_NAME_ORINGS + " WHERE " + Constants.TABLE_COLOMN_ORINGS_ID + "=?;";
		jdbcTemplate.update(query, id);
	} 
	
}
