/**
 * 
 */
package com.msvc.dal.model;

import java.util.List;

/**
 * @author Sanskriti.Agarwal
 *
 */
public class MPreexistingConditions {
	 private String PreexistingConditions;
	 private String InvestigationCompletedDate;
	private List<String> PreexistingConditionsList;
	public String getPreexistingConditions() {
		return PreexistingConditions;
	}
	public void setPreexistingConditions(String preexistingConditions) {
		PreexistingConditions = preexistingConditions;
	}
	public String getInvestigationCompletedDate() {
		return InvestigationCompletedDate;
	}
	public void setInvestigationCompletedDate(String investigationCompletedDate) {
		InvestigationCompletedDate = investigationCompletedDate;
	}
	public List<String> getPreexistingConditionsList() {
		return PreexistingConditionsList;
	}
	public void setPreexistingConditionsList(List<String> preexistingConditionsList) {
		PreexistingConditionsList = preexistingConditionsList;
	}
	
	
}
