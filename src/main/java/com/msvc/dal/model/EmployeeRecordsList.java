/**
 * 
 */
package com.msvc.dal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Sanskriti.Agarwal
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmployeeRecordsList")
@XmlRootElement(name="EmployeeRecordsList")
public class EmployeeRecordsList {

	@XmlElement
	List<EmployeeRecord> emplist;

	public List<EmployeeRecord> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<EmployeeRecord> emplist) {
		this.emplist = emplist;
	}
	
}
