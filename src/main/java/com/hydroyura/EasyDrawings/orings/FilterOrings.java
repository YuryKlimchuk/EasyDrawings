package com.hydroyura.EasyDrawings.orings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterOrings {
	



	private float[] crossSectionEnableList;
	private float[] crossSectionsSelectedList;
	private float minInternalDiameter;
	private float maxInternalDiameter;
	private float minInternalDiameterDefault;
	private float maxInternalDiameterDefault;
	private List<FilterOrings.DiameterCheckBox> checkBoxList = new ArrayList<FilterOrings.DiameterCheckBox>();
	
	
	
	public float getMinInternalDiameterDefault() {
		return minInternalDiameterDefault;
	}

	public float getMaxInternalDiameterDefault() {
		return maxInternalDiameterDefault;
	}

	public void setMinInternalDiameterDefault(float minInternalDiameterDefault) {
		this.minInternalDiameterDefault = minInternalDiameterDefault;
	}

	public void setMaxInternalDiameterDefault(float maxInternalDiameterDefault) {
		this.maxInternalDiameterDefault = maxInternalDiameterDefault;
	}



	public FilterOrings() {
		setMaxInternalDiameter(-1f);
		setMinInternalDiameter(-1f);
		float[] defaultArr = {-1f};
		setCrossSectionsSelectedList(defaultArr);
	}
	
	public void generateCheckBoxList() {
		checkBoxList.clear();
		
		for (float diameter : crossSectionEnableList) {
			boolean flag =  false;
			for (float selectedDiameter : crossSectionsSelectedList) {
				if(diameter == selectedDiameter) {
					flag = true;
				}
			}
			checkBoxList.add(new DiameterCheckBox(flag, diameter));
		}
		
	}
	
	public float[] getCrossSectionEnableList() {
		return crossSectionEnableList;
	}

	public void setCrossSectionEnableList(float[] crossSectionEnableList) {
		this.crossSectionEnableList = crossSectionEnableList;
	}

	public float[] getCrossSectionsSelectedList() {
		return crossSectionsSelectedList;
	}

	public void setCrossSectionsSelectedList(float[] crossSectionsSelectedList) {
		this.crossSectionsSelectedList = crossSectionsSelectedList;
	}
	
	public float getMinInternalDiameter() {
		return minInternalDiameter;
	}
	
	public float getMaxInternalDiameter() {
		return maxInternalDiameter;
	}
	
	public void setMinInternalDiameter(float minInternalDiameter) {
		this.minInternalDiameter = minInternalDiameter;
	}
	
	public void setMaxInternalDiameter(float maxInternalDiameter) {
		this.maxInternalDiameter = maxInternalDiameter;
	}

	public List<FilterOrings.DiameterCheckBox> getCheckBoxList() {
		return checkBoxList;
	}
	
	@Override
	public String toString() {
		return "FilterOrings [crossSectionEnableList=" + Arrays.toString(crossSectionEnableList)
				+ ", crossSectionsSelectedList=" + Arrays.toString(crossSectionsSelectedList) + ", minInternalDiameter="
				+ minInternalDiameter + ", maxInternalDiameter=" + maxInternalDiameter + ", checkBoxList="
				+ checkBoxList + "]";
	}


	public class DiameterCheckBox {
		
		private boolean isCheacked;
		private float diameter;
		
		public DiameterCheckBox(boolean isCheacked, float diameter) {
			this.isCheacked = isCheacked;
			this.diameter = diameter;
		}
		
		public boolean isCheacked() {
			return isCheacked;
		}
		public float getDiameter() {
			return diameter;
		}
		public void setCheacked(boolean isCheacked) {
			this.isCheacked = isCheacked;
		}
		public void setDiameter(float diameter) {
			this.diameter = diameter;
		}

		@Override
		public String toString() {
			return "DiameterCheckBox [isCheacked=" + isCheacked + ", diameter=" + diameter + "]";
		}
		
		
		
	}
	
	
	

}
