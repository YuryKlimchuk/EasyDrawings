package com.hydroyura.EasyDrawings.asm;

import java.util.List;

import com.hydroyura.EasyDrawings.opp.Opp;
import com.hydroyura.EasyDrawings.orings.Oring;
import com.hydroyura.EasyDrawings.vzk.Vzk;

public class Asm {
	
	private int id;
	private String number;
	private String name;
	private String status;
	private String version;
	private String update;
	private int countsInAsm;
	
	
	public List<Asm> asmList;
	public List<Opp> oppList;
	public List<Oring> oringList;
	public List<Vzk> vzkList;
	
	public List<Vzk> getVzkList() {
		return vzkList;
	}

	public void setVzkList(List<Vzk> vzkList) {
		this.vzkList = vzkList;
	}

	public Asm() {}
	
	public List<Asm> getAsmList() {
		return asmList;
	}

	public List<Opp> getOppList() {
		return oppList;
	}

	public List<Oring> getOringList() {
		return oringList;
	}

	public void setAsmList(List<Asm> asmList) {
		this.asmList = asmList;
	}

	public void setOppList(List<Opp> oppList) {
		this.oppList = oppList;
	}

	public void setOringList(List<Oring> oringList) {
		this.oringList = oringList;
	}

	public int getCountsInAsm() {
		return countsInAsm;
	}
	
	public void setCountsInAsm(int countsInAsm) {
		this.countsInAsm = countsInAsm;
	}
	
	public int getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public String getVersion() {
		return version;
	}

	public String getUpdate() {
		return update;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setUpdate(String update) {
		this.update = update;
	}
	
	
}
