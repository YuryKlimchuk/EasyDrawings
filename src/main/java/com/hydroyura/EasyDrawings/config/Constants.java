package com.hydroyura.EasyDrawings.config;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Constants {
	
	public static boolean isThere(ResultSet rs, String column){
	    try{
	        rs.findColumn(column);
	        return true;
	    } catch (SQLException sqlex){
	        System.out.println("column doesn't exist {}");
	    }

	    return false;
	}
	
	// Имена таблиц
	public static final String TABLE_NAME_ORINGS = "orings";
	public static final String TABLE_NAME_OPP = "our_product_parts";
	public static final String TABLE_NAME_SCREW_BOLT = "screw_bolt";
	public static final String TABLE_NAME_ASM = "assemblies";
	public static final String TABLE_NAME_ASM_ORINGS = "assembly_composition_orings";
	public static final String TABLE_NAME_VZK = "vzk";
	public static final String TABLE_NAME_ASM_COMP_ORINGS = "assembly_composition_orings";
	public static final String TABLE_NAME_ASM_COMP_OPP = "assembly_composition_opp";
	public static final String TABLE_NAME_ASM_COMP_VZK = "assembly_composition_vzk";
	public static final String TABLE_NAME_ASM_COMP_ASM = "assembly_composition_asm";
	
	// Название столбцов таблицы assembly_composition_asm
	public static final String TABLE_COLOMN_ASM_COMP_ASM_ASM_FULL_ID = "asm_id_full";
	public static final String TABLE_COLOMN_ASM_COMP_ASM_ASM_ID = "asm_id";
	public static final String TABLE_COLOMN_ASM_COMP_ASM_COUNTS = "counts";
	public static final String TABLE_COLOMN_ASM_COMP_ASM_CHANGE = "change";
	
	
	// Название столбцов таблицы assembly_composition_vzk
	public static final String TABLE_COLOMN_ASM_COMP_VZK_ASM_FULL_ID = "asm_id_full";
	public static final String TABLE_COLOMN_ASM_COMP_VZK_VZK_ID = "vzk_id";
	public static final String TABLE_COLOMN_ASM_COMP_VZK_COUNTS = "counts";
	public static final String TABLE_COLOMN_ASM_COMP_VZK_CHANGE = "change";
	
	// Название столбцов таблицы assembly_composition_orings
	public static final String TABLE_COLOMN_ASM_COMP_OPP_ASM_FULL_ID = "asm_id_full";
	public static final String TABLE_COLOMN_ASM_COMP_OPP_OPP_ID = "opp_id";
	public static final String TABLE_COLOMN_ASM_COMP_OPP_COUNTS = "counts";
	public static final String TABLE_COLOMN_ASM_COMP_OPP_CHANGE = "change";
	
	// Название столбцов таблицы assembly_composition_orings
	public static final String TABLE_COLOMN_ASM_COMP_ORINGS_ASM_FULL_ID = "asm_id_full";
	public static final String TABLE_COLOMN_ASM_COMP_ORINGS_ORING_ID = "orings_id";
	public static final String TABLE_COLOMN_ASM_COMP_ORINGS_COUNTS = "counts";
	public static final String TABLE_COLOMN_ASM_COMP_ORINGS_CHANGE = "change";

	
	// Название столбцов таблицы vzks
	public static final String TABLE_COLOMN_VZK_ID = "vzk_id";
	public static final String TABLE_COLOMN_VZK_NUMBER = "vzk_number";
	public static final String TABLE_COLOMN_VZK_NAME = "vzk_name";
	
	// Название столбцов таблицы screw_bolt
	public static final String TABLE_COLOMN_SCREW_ID = "screw_bolt_id";
	public static final String TABLE_COLOMN_SCREW_NUMBER = "screw_bolt_number";
	public static final String TABLE_COLOMN_SCREW_NAME = "screw_bolt_name";
	public static final String TABLE_COLOMN_SCREW_STANDART = "standart";
	
	// Название столбцов таблицы assemblies
	public static final String TABLE_COLOMN_ASM_ID = "asm_id";
	public static final String TABLE_COLOMN_ASM_NUMBER = "asm_number";
	public static final String TABLE_COLOMN_ASM_NAME = "asm_name";
	public static final String TABLE_COLOMN_ASM_STATUS = "asm_status";
	public static final String TABLE_COLOMN_ASM_VERSION = "asm_version";
	public static final String TABLE_COLOMN_ASM_UPDATE = "asm_update";
	
	// Название столбцов таблицы our_product_parts
	public static final String TABLE_COLOMN_OPP_ID = "opp_id";
	public static final String TABLE_COLOMN_OPP_NUMBER = "opp_number";
	public static final String TABLE_COLOMN_OPP_NAME = "opp_name";
	public static final String TABLE_COLOMN_OPP_STATUS = "opp_status";
	public static final String TABLE_COLOMN_OPP_VERSION = "opp_version";
	public static final String TABLE_COLOMN_OPP_UPDATE = "opp_update";
	
	// Название столбцов таблицы orings
	public static final String TABLE_COLOMN_ORINGS_ID = "oring_id";
	public static final String TABLE_COLOMN_ORINGS_CROSS_SECTION = "cross_section";
	public static final String TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER = "internal_diameter";
	public static final String TABLE_COLOMN_ORINGS_NUMBER = "oring_number";
	public static final String TABLE_COLOMN_ORINGS_STANDART = "standart";
	
	// Доступ к БД
	public static final String DB_URL = "jdbc:postgresql://rogue.db.elephantsql.com:5432/ebimnubj";
	public static final String DB_USERNAME = "ebimnubj";
	public static final String DB_PASSWORD = "T4Kzw5kQlRg6jgQTc6ca8N04Bf4bfc_V";
	public static final String DB_DRIVER = "org.postgresql.Driver";
	
	// Типы OPP элементов
	public static final String OPP_ENTITY_TYPE_TASK = "TASK";
	public static final String OPP_ENTITY_TYPE_NOTE = "NOTE";
	public static final String OPP_ENTITY_TYPE_DESIGN = "DESIGN";

}
