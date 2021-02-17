package com.hydroyura.EasyDrawings.asm;

import java.util.ArrayList;
import java.util.List;
import com.hydroyura.EasyDrawings.opp.Opp;
import com.hydroyura.EasyDrawings.orings.Oring;
import com.hydroyura.EasyDrawings.vzk.Vzk;

public class AsmComposition {
	
	private List<Asm> asmList;
	private List<Opp> oppList;
	private List<Oring> oringList;
	private List<Vzk> vzkList;
	
	
	public AsmComposition() {}
	
	
	
	public void compositionInnerAsm(DaoAsm daoAsm) {
		System.out.println("1");
		while (asmList.size() != 0) {
			System.out.println("2");
			List<Asm> asmToRemove = new ArrayList<Asm>();
			List<Asm> asmToAdd = new ArrayList<Asm>();
			for (Asm asm : asmList) {
				System.out.println(asm.getName());
				AsmComposition innerAsmComposition = daoAsm.getAsmCompositionById(asm.getId());
				
				asmToRemove.add(asm);
				asmToAdd.addAll(innerAsmComposition.asmList);
				oppList.addAll(innerAsmComposition.oppList);
				oringList.addAll(innerAsmComposition.oringList);
				vzkList.addAll(innerAsmComposition.vzkList);
			}
			
			asmList.removeAll(asmToRemove);
			asmList.addAll(asmToAdd);
		}
	}
	
	
	public List<Vzk> getVzkList() {
		return vzkList;
	}

	@Override
	public String toString() {
		return "AsmComposition [asmList=" + asmList + ", oppList=" + oppList + ", oringList=" + oringList + ", vzkList="
				+ vzkList + "]";
	}



	public List<Asm> getAsmList() {
		return asmList;
	}

	public List<Opp> getOppList() {
		return oppList;
	}

	public List<Oring> getOringList() {
		return oringList;
	}
	
	public void setVzkList(List<Vzk> vzkList) {
		this.vzkList = vzkList;
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
	
}
