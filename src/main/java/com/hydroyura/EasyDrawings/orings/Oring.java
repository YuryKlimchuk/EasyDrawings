package com.hydroyura.EasyDrawings.orings;

public class Oring {
	
	private int id;
	private String number;
	private String standart;
	private float crossSection;
	private float internalDiameter;
	private int countsInAsm;
	
	
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
	public String getStandart() {
		return standart;
	}
	public float getCrossSection() {
		return crossSection;
	}
	public float getInternalDiameter() {
		return internalDiameter;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setStandart(String standart) {
		this.standart = standart;
	}
	public void setCrossSection(float crossSection) {
		this.crossSection = crossSection;
	}
	public void setInternalDiameter(float internalDiameter) {
		this.internalDiameter = internalDiameter;
	}
	@Override
	public String toString() {
		return "Oring [id=" + id + ", number=" + number + ", standart=" + standart + ", crossSection=" + crossSection
				+ ", internalDiameter=" + internalDiameter + "]";
	}
	
	

}
