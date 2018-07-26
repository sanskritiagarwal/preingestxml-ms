package com.msvc.dal.model;

import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
 
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog
{
    @XmlElement(name = "employeeRecord")
    private List<EmployeeRecord> employeeRecord = new ArrayList<EmployeeRecord>();
 
    public List<EmployeeRecord> getEmployeeRecords()
    {
        return employeeRecord;
    }
 
    public void setEmployeeRecords(List<EmployeeRecord> employeeRecord)
    {
        this.employeeRecord = employeeRecord;
    }
}