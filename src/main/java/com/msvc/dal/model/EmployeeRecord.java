package com.msvc.dal.model;

public class EmployeeRecord {

	private String BlkOfBusID;
	private String ClientID;
	private String EmployeeCertificateNumber;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String Suffix;
	private String EmployeeSSN;
	private String Medicare;
	private String BirthDate;
	private String Gender;
	private String MaritalStatus;
	private String AsOfDate;
	private String Email;
	private String Languages;
	private String AlternateID1;
	private String AlternateID2;
	
	private String Title;
	private String ExpediteClaims;
	private String MedicallyUnderwritten;
	private String LateEntrant;
	private String EnrollmentDate;
	
	
	public String getBlkOfBusID() {
		return BlkOfBusID;
	}
	public void setBlkOfBusID(String blkOfBusID) {
		BlkOfBusID = blkOfBusID;
	}
	public String getClientID() {
		return ClientID;
	}
	public void setClientID(String clientID) {
		ClientID = clientID;
	}
	public String getEmployeeCertificateNumber() {
		return EmployeeCertificateNumber;
	}
	public void setEmployeeCertificateNumber(String employeeCertificateNumber) {
		EmployeeCertificateNumber = employeeCertificateNumber;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getSuffix() {
		return Suffix;
	}
	public void setSuffix(String suffix) {
		Suffix = suffix;
	}
	public String getEmployeeSSN() {
		return EmployeeSSN;
	}
	public void setEmployeeSSN(String employeeSSN) {
		EmployeeSSN = employeeSSN;
	}
	public String getMedicare() {
		return Medicare;
	}
	public void setMedicare(String medicare) {
		Medicare = medicare;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getMaritalStatus() {
		return MaritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}
	public String getAsOfDate() {
		return AsOfDate;
	}
	public void setAsOfDate(String asOfDate) {
		AsOfDate = asOfDate;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getLanguages() {
		return Languages;
	}
	public void setLanguages(String languages) {
		Languages = languages;
	}
	public String getAlternateID1() {
		return AlternateID1;
	}
	public void setAlternateID1(String alternateID1) {
		AlternateID1 = alternateID1;
	}
	public String getAlternateID2() {
		return AlternateID2;
	}
	public void setAlternateID2(String alternateID2) {
		AlternateID2 = alternateID2;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getExpediteClaims() {
		return ExpediteClaims;
	}
	public void setExpediteClaims(String expediteClaims) {
		ExpediteClaims = expediteClaims;
	}
	public String getMedicallyUnderwritten() {
		return MedicallyUnderwritten;
	}
	public void setMedicallyUnderwritten(String medicallyUnderwritten) {
		MedicallyUnderwritten = medicallyUnderwritten;
	}
	public String getLateEntrant() {
		return LateEntrant;
	}
	public void setLateEntrant(String lateEntrant) {
		LateEntrant = lateEntrant;
	}
	public String getEnrollmentDate() {
		return EnrollmentDate;
	}
	public void setEnrollmentDate(String enrollmentDate) {
		EnrollmentDate = enrollmentDate;
	}
	
	
	/*
    
    <MailPaperEOB>Y</MailPaperEOB>
    <ReceiveMail>N</ReceiveMail>
    <SelectEOBAddress>E</SelectEOBAddress>
    <SelectPaymentAddress>9</SelectPaymentAddress>
    <Height/>
    <Weight/>
    <Health/>
    <Beneficiary/>
    <Race/>
    <Citizenship/>
    <Handicap>N</Handicap>
    <DeathDate/>
    <UserDefinedField1/>
    <UserDefinedField2/>
    <UserDefinedField3/>
    <UserDefinedField4/>
    <UserDefinedField5/>
    <UserDefinedField6/>
    <Comments/>
    <WorkPhone1/>
    <WorkPhone1Ext/>
    <WorkPhone2/>
    <WorkPhone2Ext/>
    <HomePhone1/>
    <HomePhone2/>
    <MobilePhone1/>
    <MobilePhone2/>
    <FaxPhone1/>
    <FaxPhone2/>
    <Conversionid/>
    <REffectiveDate>20180101</REffectiveDate>
    <RCountry>USA</RCountry>
    <RAddressLine1>1 main street</RAddressLine1>
    <RAddressLine2/>
    <RAddressLine3/>
    <RCity>Lockport</RCity>
    <RState>NY</RState>
    <RPostalCode>14094</RPostalCode>
    <RCounty>Niagara</RCounty>
    <RAlternateMailingName/>
    <MEffectiveDate>20180101</MEffectiveDate>
    <MCountry>USA</MCountry>
    <MAddressLine1>1 Main Street</MAddressLine1>
    <MAddressLine2/>
    <MAddressLine3/>
    <MCity>Lockport</MCity>
    <MState>NY</MState>
    <MPostalCode>14094</MPostalCode>
    <MCounty>Niagara</MCounty>
    <MAlternateMailingName/>
    <HIPAACreditableCovgDate>20180601</HIPAACreditableCovgDate>
    <FormerHealthPlanName/>
    <PriorCoverageList/>
    <MPreexistingConditions/>
    <DPreexistingConditions/>
    <VPreexistingConditions/>
    <PPreexistingConditions/>
    <EOBDeniedReasonCode/>
    <EOBICD9DiagnosisCodeFrom/>
    <EOBICD9DiagnosisCodeTo/>
    <EOBPendClaims/>
    <EOBPendReasonCode/>
    <EOBExpirationDate/>
    <FSAHierarchy/>
    <LFSAHierarchy/>
    <HRAHierarchy/>
    <CheckingAccountRoutingInfo/>
    <BankCheckDigit/>
    <CheckingAccountNum/>
	*/
	
}
