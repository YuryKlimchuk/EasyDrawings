package com.hydroyura.EasyDrawings.screw;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.EasyDrawings.config.Constants;

public class ScrewRowMap implements RowMapper<Screw> {

	@Override
	public Screw mapRow(ResultSet rs, int rowNum) throws SQLException {
		Screw screw = new Screw();
		screw.setId(rs.getInt(Constants.TABLE_COLOMN_SCREW_ID));
		screw.setNumber(rs.getString(Constants.TABLE_COLOMN_SCREW_NUMBER));
		screw.setName(rs.getString(Constants.TABLE_COLOMN_SCREW_NAME));
		screw.setStandart(rs.getString(Constants.TABLE_COLOMN_SCREW_STANDART));
		return screw;
	}

}
