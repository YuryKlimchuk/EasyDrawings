package com.hydroyura.EasyDrawings.asm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hydroyura.EasyDrawings.config.Constants;
import com.hydroyura.EasyDrawings.opp.Opp;
import com.hydroyura.EasyDrawings.opp.OppRowMap;
import com.hydroyura.EasyDrawings.orings.Oring;
import com.hydroyura.EasyDrawings.orings.OringRowMap;
import com.hydroyura.EasyDrawings.vzk.Vzk;
import com.hydroyura.EasyDrawings.vzk.VzkRowMap;

@Component
public class DaoAsm {

private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DaoAsm(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Asm> getAsmList() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ASM + ";";
		return jdbcTemplate.query(query, new AsmRowMap());
	} 
	
	@SuppressWarnings("deprecation")
	public Asm getAsmById(int id) {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ASM + " WHERE " + Constants.TABLE_COLOMN_ASM_ID + "= ?;";
		return jdbcTemplate.queryForObject(query, new Object[]{id}, new AsmRowMap());	
	} 
	
	public void deleteAsm(int id) {
		String query = "DELETE FROM " + Constants.TABLE_NAME_ASM + " WHERE " + Constants.TABLE_COLOMN_ASM_ID + "=?;";
		jdbcTemplate.update(query, id);
	} 
	
	public int addAsm(Asm asm) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM + " (" 
				+ Constants.TABLE_COLOMN_ASM_NUMBER+ ", " 
				+ Constants.TABLE_COLOMN_ASM_NAME + ", " 
				+ Constants.TABLE_COLOMN_ASM_STATUS + ", " 
				+ Constants.TABLE_COLOMN_ASM_VERSION + ", " 
				+ Constants.TABLE_COLOMN_ASM_UPDATE + ") VALUES (?, ?, ?, ?, ?);";
		return jdbcTemplate.update(query, asm.getNumber(), asm.getName(), asm.getStatus(), asm.getVersion(), asm.getUpdate());
	}
	
	public List<Oring> getOringsInAsm(int asmId) {
		String query = "SELECT " + Constants.TABLE_COLOMN_ORINGS_NUMBER + ", " + Constants.TABLE_COLOMN_ASM_COMP_ORINGS_COUNTS
				+ " FROM " + Constants.TABLE_NAME_ASM_COMP_ORINGS
				+ " AS T1 INNER JOIN " + Constants.TABLE_NAME_ORINGS + " AS T2 ON "
				+ "T1." + Constants.TABLE_COLOMN_ASM_COMP_ORINGS_ORING_ID + "= T2." + Constants.TABLE_COLOMN_ORINGS_ID + " WHERE "
				+ Constants.TABLE_COLOMN_ASM_COMP_ORINGS_ASM_FULL_ID + "='" + asmId + "' " + "AND " + Constants.TABLE_COLOMN_ASM_COMP_ORINGS_CHANGE + "='-1'";
		
		return jdbcTemplate.query(query, new OringRowMap());
	}
	
	public List<Vzk> getVzkInAsm(int asmId) {
		String query = "SELECT * "
				+ " FROM " + Constants.TABLE_NAME_ASM_COMP_VZK
				+ " AS T1 INNER JOIN " + Constants.TABLE_NAME_VZK + " AS T2 ON "
				+ "T1." + Constants.TABLE_COLOMN_ASM_COMP_VZK_VZK_ID + "= T2." + Constants.TABLE_COLOMN_VZK_ID + " WHERE "
				+ Constants.TABLE_COLOMN_ASM_COMP_VZK_ASM_FULL_ID + "='" + asmId + "' " + "AND " + Constants.TABLE_COLOMN_ASM_COMP_VZK_CHANGE + "='-1'";
		
		return jdbcTemplate.query(query, new VzkRowMap());
	}
	
	public List<Opp> getOppsInAsm(int asmId) {
		String query = "SELECT * "
				+ " FROM " + Constants.TABLE_NAME_ASM_COMP_OPP
				+ " AS T1 INNER JOIN " + Constants.TABLE_NAME_OPP + " AS T2 ON "
				+ "T1." + Constants.TABLE_COLOMN_ASM_COMP_OPP_OPP_ID + "= T2." + Constants.TABLE_COLOMN_OPP_ID + " WHERE "
				+ Constants.TABLE_COLOMN_ASM_COMP_OPP_ASM_FULL_ID + "='" + asmId + "' " + "AND " + Constants.TABLE_COLOMN_ASM_COMP_OPP_CHANGE + "='-1'";
		System.out.println(query);
		return jdbcTemplate.query(query, new OppRowMap());
	}
	
	public List<Asm> getAsmsInAsm(int asmId) {
		String query = "SELECT * "
				+ " FROM " + Constants.TABLE_NAME_ASM_COMP_ASM
				+ " AS T1 INNER JOIN " + Constants.TABLE_NAME_ASM + " AS T2 ON "
				+ "T1." + Constants.TABLE_COLOMN_ASM_COMP_ASM_ASM_ID + "= T2." + Constants.TABLE_COLOMN_ASM_ID + " WHERE "
				+ Constants.TABLE_COLOMN_ASM_COMP_ASM_ASM_FULL_ID + "='" + asmId + "' " + "AND " + Constants.TABLE_COLOMN_ASM_COMP_ASM_CHANGE + "='-1'";
		System.out.println(query);
		return jdbcTemplate.query(query, new AsmRowMap());
	}
	
	
}
