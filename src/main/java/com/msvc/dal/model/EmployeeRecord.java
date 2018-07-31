package com.msvc.dal.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="EmployeeRecord")
@XmlRootElement(name="EmployeeRecord")
public class EmployeeRecord  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Conversionid;
	private String BlkOfBusID;
	private String ClientID;
	private String EmployeeCertificateNumber;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String Suffix;
	@XmlAttribute
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
	private String LateEntrant;
	private String EnrollmentDate;

	private List<MPreexistingConditions> MPreexistingConditions;

	private List<CMS111> CMS111;
	
	private String MedicallyUnderwritten;
	private String BusinessTakeover;
	private String MailPaperEOB;
	private String ReceiveMail;
	private String SelectEOBAddress;
	private String SelectPaymentAddress;
	private String Height;
	private String Weight;
	private String Health;
	private String Beneficiary;
	private String Race;
	private String Citizenship;
	private String Handicap;
	private String DeathDate;
	private String UserDefinedField1;
	private String UserDefinedField2;
	private String UserDefinedField3;
	private String UserDefinedField4;
	private String UserDefinedField5;
	private String UserDefinedField6;
	private String Comments;
	private String WorkPhone1;
	private String WorkPhone1Ext;
	private String WorkPhone2;
	private String WorkPhone2Ext;
	private String HomePhone1;
	private String HomePhone2;
	private String MobilePhone1;
	private String MobilePhone2;
	private String FaxPhone1;
	private String FaxPhone2;
	
	private String REffectiveDate;
	private String RCountry;
	private String RAddressLine1;
	private String RAddressLine2;
	private String RAddressLine3;
	private String RCity;
	private String RState;
	private String RPostalCode;
	private String RCounty;
	private String RAlternateMailingName;
	private String MEffectiveDate;
	private String MCountry;
	private String MAddressLine1;
	private String MAddressLine2;
	private String MAddressLine3;
	private String MCity;
	private String MState;
	private String MPostalCode;
	private String MCounty;
	private String MAlternateMailingName;
	private String HIPAACreditableCovgDate;
	private String FormerHealthPlanName;
	private String PriorCoverageList;
	private String PreexistingConditions;
	private String InvestigationCompletedDate;
	private String PreexistingConditionsList;
	private String PreexistingConditions2;
	private String InvestigationCompletedDate3;
	private String PreexistingConditionsList4;
	private String PreexistingConditions5;
	private String InvestigationCompletedDate6;
	private String PreexistingConditionsList7;
	private String PreexistingConditions8;
	private String InvestigationCompletedDate9;
	private String PreexistingConditionsList10;
	private String EOBDeniedReasonCode;
	private String EOBICD9DiagnosisCodeFrom;
	private String EOBICD9DiagnosisCodeTo;
	private String EOBPendClaims;
	private String EOBPendReasonCode;
	private String EOBExpirationDate;
	private String FSAHierarchy;
	private String LFSAHierarchy;
	private String HRAHierarchy;
	private String CheckingAccountRoutingInfo;
	private String BankCheckDigit;
	private String CheckingAccountNum;
	
	private String RelationshipToEmployee;
	private String CovgEffectiveDate;
	private String EmploymentBeginDate;
	private String CreateHRADebitCard;
	private String HRAARequestReason;
	private String Status;
	private String Lifestyle;
	private String IndRenewalDate;
	private String Department;
	private String Medicare11;
	private String Salary;
	private String EmploymentStatus;
	private String LaseredStopLoss;
	private String StopLossAmount;
	private String FrequencyOfPay;
	private String WorkHours;
	private String DisabilityStatus;
	private String DisabilityBeginDate;
	private String DisabilityEndDate;
	private String BillIndividual;
	private String EmploymentEndDate;
	private String ClientLocation;
	private String TerminationReason;
	private String TerminationDate;
	private String CobraReason;
	private String PartyViewMyInfo;
	private String PartyDoNotDisplayAlert;
	private String StopLossContractMaxCap;
	private String StopLossContract;
	private String ApplyStopLossContractMax;
	private String MBenefitPlan;
	private String MBillPlan;
	private String MTier;
	private String MCoverageLevel;
	private String MBillingMode;
	private String MFirstBillDay;
	private String MSecondBillDay;
	private String MRateGuaranteeFromDate;
	private String MRateGuaranteeThruDate;
	private String MCalculateAdjustments;
	private String MAdjustAsOf;
	private String MActionExisManualAdjust;
	private String MPendClaims;
	private String MPendReason;
	private String MSellingBroker;
	private String MExpectedBillingFromDate;
	private String MExpectedBillingThruDate;
	private String MApplyCOB;
	private String MPayerResponsibility;
	private String MCOBPolicyNumber;
	private String MCOBType;
	private String MOtherCarrier;
	private String MIgnoreClaimCOBFlag;
	private String MIssueLetterforPendedCOBClaims;
	private String MLastInvestigatedDate;
	private String MInvestigatedAfter;
	private String MCOBRuleset;
	private String MCOBPatientCertificate;
	private String MOtherCovgInJavelina;
	private String MPrintIDCard;
	private String MIDCardFormat;
	private String MCardPrintReason;
	private String MNetworkChoice;
	private String MIndBenefitMaximums;
	private String MLastBillDate;
	private String MNextBillDate;
	private String DBenefitPlan;
	private String DBillPlan;
	private String DTier;
	private String DCoverageLevel;
	private String DBillingMode;
	private String DFirstBillDay;
	private String DSecondBillDay;
	private String DRateGuaranteeFromDate;
	private String DRateGuaranteeThruDate;
	private String DCalculateAdjustments;
	private String DAdjustAsOf;
	private String DActionExisManualAdjust;
	private String DPendClaims;
	private String DPendReason;
	private String DSellingBroker;
	private String DExpectedBillingFromDate;
	private String DExpectedBillingThruDate;
	private String DApplyCOB;
	private String DPayerResponsibility;
	private String DCOBPolicyNumber;
	private String DCOBType;
	private String DOtherCarrier;
	private String DIgnoreClaimCOBFlag;
	private String DIssueLetterforPendedCOBClaims;
	private String DLastInvestigatedDate;
	private String DInvestigatedAfter;
	private String DCOBRuleset;
	private String DCOBPatientCertificate;
	private String DOtherCovgInJavelina;
	private String DPrintIDCard;
	private String DIDCardFormat;
	private String DCardPrintReason;
	private String DNetworkChoice;
	private String DIndBenefitMaximums;
	private String DLastBillDate;
	private String DNextBillDate;
	private String VBenefitPlan;
	private String VBillPlan;
	private String VTier;
	private String VCoverageLevel;
	private String VBillingMode;
	private String VFirstBillDay;
	private String VSecondBillDay;
	private String VRateGuaranteeFromDate;
	private String VRateGuaranteeThruDate;
	private String VCalculateAdjustments;
	private String VAdjustAsOf;
	private String VActionExisManualAdjust;
	private String VPendClaims;
	private String VPendReason;
	private String VSellingBroker;
	private String VExpectedBillingFromDate;
	private String VExpectedBillingThruDate;
	private String VApplyCOB;
	private String VPayerResponsibility;
	private String VCOBPolicyNumber;
	private String VCOBType;
	private String VOtherCarrier;
	private String VIgnoreClaimCOBFlag;
	private String VIssueLetterforPendedCOBClaims;
	private String VLastInvestigatedDate;
	private String VInvestigatedAfter;
	private String VCOBRuleset;
	private String VCOBPatientCertificate;
	private String VOtherCovgInJavelina;
	private String VPrintIDCard;
	private String VIDCardFormat;
	private String VCardPrintReason;
	private String VNetworkChoice;
	private String VIndBenefitMaximums;
	private String VLastBillDate;
	private String VNextBillDate;
	private String PBenefitPlan;
	private String PBillPlan;
	private String PTier;
	private String PCoverageLevel;
	private String PBillingMode;
	private String PFirstBillDay;
	private String PSecondBillDay;
	private String PRateGuaranteeFromDate;
	private String PRateGuaranteeThruDate;
	private String PCalculateAdjustments;
	private String PAdjustAsOf;
	private String PActionExisManualAdjust;
	private String PPendClaims;
	private String PPendReason;
	private String PSellingBroker;
	private String PExpectedBillingFromDate;
	private String PExpectedBillingThruDate;
	private String PApplyCOB;
	private String PPayerResponsibility;
	private String PCOBPolicyNumber;
	private String PCOBType;
	private String POtherCarrier;
	private String PIgnoreClaimCOBFlag;
	private String PIssueLetterforPendedCOBClaims;
	private String PLastInvestigatedDate;
	private String PInvestigatedAfter;
	private String PCOBRuleset;
	private String PCOBPatientCertificate;
	private String POtherCovgInJavelina;
	private String PPrintIDCard;
	private String PIDCardFormat;
	private String PCardPrintReason;
	private String PNetworkChoice;
	private String PIndBenefitMaximums;
	private String PLastBillDate;
	private String PNextBillDate;
	private String FBenefitPlan;
	private String FBillPlan;
	private String FTier;
	private String FCoverageLevel;
	private String FBillingMode;
	private String FFirstBillDay;
	private String FSecondBillDay;
	private String FRateGuaranteeFromDate;
	private String FRateGuaranteeThruDate;
	private String FCalculateAdjustments;
	private String FAdjustAsOf;
	private String FActionExisManualAdjust;
	private String FPendClaims;
	private String FPendReason;
	private String FSellingBroker;
	private String FExpectedBillingFromDate;
	private String FExpectedBillingThruDate;
	private String FApplyCOB;
	private String FPayerResponsibility;
	private String FCOBPolicyNumber;
	private String FCOBType;
	private String FOtherCarrier;
	private String FIgnoreClaimCOBFlag;
	private String FIssueLetterforPendedCOBClaims;
	private String FLastBillDate;
	private String FNextBillDate;
	private String STDBenefitPlan;
	private String STDBillPlan;
	private String STDTier;
	private String STDCoverageLevel;
	private String STDBillingMode;
	private String STDFirstBillDay;
	private String STDSecondBillDay;
	private String STDRateGuaranteeFromDate;
	private String STDRateGuaranteeThruDate;
	private String STDCalculateAdjustments;
	private String STDAdjustAsOf;
	private String STDActionExisManualAdjust;
	private String STDPendClaims;
	private String STDPendReason;
	private String STDSellingBroker;
	private String STDExpectedBillingFromDate;
	private String STDExpectedBillingThruDate;
	private String STDVolume;
	private String STDLastBillDate;
	private String STDNextBillDate;
	private String LTDBenefitPlan;
	private String LTDBillPlan;
	private String LTDTier;
	private String LTDCoverageLevel;
	private String LTDBillingMode;
	private String LTDFirstBillDay;
	private String LTDSecondBillDay;
	private String LTDRateGuaranteeFromDate;
	private String LTDRateGuaranteeThruDate;
	private String LTDCalculateAdjustments;
	private String LTDAdjustAsOf;
	private String LTDActionExisManualAdjust;
	private String LTDPendClaims;
	private String LTDPendReason;
	private String LTDSellingBroker;
	private String LTDExpectedBillingFromDate;
	private String LTDExpectedBillingThruDate;
	private String LTDVolume;
	private String LTDLastBillDate;
	private String LTDNextBillDate;
	private String SC1ProductName;
	private String SC1Volume;
	private String SC1CoverageLevel;
	private String SC1BillPlan;
	private String SC1Tier;
	private String SC1CalculateAdjustments;
	private String SC1AdjustAsOf;
	private String SC1ActionExisManualAdjust;
	private String SC1BillingMode;
	private String SC1FirstBillDay;
	private String SC1SecondBillDay;
	private String SC1RateGuaranteeFrom;
	private String SC1RateGuaranteeThru;
	private String SC1LastBillDate;
	private String SC1NextBillDate;
	private String SC1SellingBroker;
	private String SC1ExpectedBillingFromDate;
	private String SC1ExpectedBillingThruDate;
	private String MConnectorID;
	private String MProviderType;
	private String DConnectorID;
	private String DProviderType;
	private String VConnectorID;
	private String VProviderType;
	private String PConnectorID;
	private String PProviderType;
	

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

	public String getConversionid() {
		return Conversionid;
	}

	public void setConversionid(String conversionid) {
		Conversionid = conversionid;
	}

	public List<MPreexistingConditions> getMPreexistingConditions() {
		return MPreexistingConditions;
	}

	public void setMPreexistingConditions(List<MPreexistingConditions> mPreexistingConditions) {
		MPreexistingConditions = mPreexistingConditions;
	}

	public List<CMS111> getCMS111() {
		return CMS111;
	}

	public void setCMS111(List<CMS111> cMS111) {
		CMS111 = cMS111;
	}

	public String getBusinessTakeover() {
		return BusinessTakeover;
	}

	public void setBusinessTakeover(String businessTakeover) {
		BusinessTakeover = businessTakeover;
	}

	public String getMailPaperEOB() {
		return MailPaperEOB;
	}

	public void setMailPaperEOB(String mailPaperEOB) {
		MailPaperEOB = mailPaperEOB;
	}

	public String getReceiveMail() {
		return ReceiveMail;
	}

	public void setReceiveMail(String receiveMail) {
		ReceiveMail = receiveMail;
	}

	public String getSelectEOBAddress() {
		return SelectEOBAddress;
	}

	public void setSelectEOBAddress(String selectEOBAddress) {
		SelectEOBAddress = selectEOBAddress;
	}

	public String getSelectPaymentAddress() {
		return SelectPaymentAddress;
	}

	public void setSelectPaymentAddress(String selectPaymentAddress) {
		SelectPaymentAddress = selectPaymentAddress;
	}

	public String getHeight() {
		return Height;
	}

	public void setHeight(String height) {
		Height = height;
	}

	public String getWeight() {
		return Weight;
	}

	public void setWeight(String weight) {
		Weight = weight;
	}

	public String getHealth() {
		return Health;
	}

	public void setHealth(String health) {
		Health = health;
	}

	public String getBeneficiary() {
		return Beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		Beneficiary = beneficiary;
	}

	public String getRace() {
		return Race;
	}

	public void setRace(String race) {
		Race = race;
	}

	public String getCitizenship() {
		return Citizenship;
	}

	public void setCitizenship(String citizenship) {
		Citizenship = citizenship;
	}

	public String getHandicap() {
		return Handicap;
	}

	public void setHandicap(String handicap) {
		Handicap = handicap;
	}

	public String getDeathDate() {
		return DeathDate;
	}

	public void setDeathDate(String deathDate) {
		DeathDate = deathDate;
	}

	public String getUserDefinedField1() {
		return UserDefinedField1;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		UserDefinedField1 = userDefinedField1;
	}

	public String getUserDefinedField2() {
		return UserDefinedField2;
	}

	public void setUserDefinedField2(String userDefinedField2) {
		UserDefinedField2 = userDefinedField2;
	}

	public String getUserDefinedField3() {
		return UserDefinedField3;
	}

	public void setUserDefinedField3(String userDefinedField3) {
		UserDefinedField3 = userDefinedField3;
	}

	public String getUserDefinedField4() {
		return UserDefinedField4;
	}

	public void setUserDefinedField4(String userDefinedField4) {
		UserDefinedField4 = userDefinedField4;
	}

	public String getUserDefinedField5() {
		return UserDefinedField5;
	}

	public void setUserDefinedField5(String userDefinedField5) {
		UserDefinedField5 = userDefinedField5;
	}

	public String getUserDefinedField6() {
		return UserDefinedField6;
	}

	public void setUserDefinedField6(String userDefinedField6) {
		UserDefinedField6 = userDefinedField6;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public String getWorkPhone1() {
		return WorkPhone1;
	}

	public void setWorkPhone1(String workPhone1) {
		WorkPhone1 = workPhone1;
	}

	public String getWorkPhone1Ext() {
		return WorkPhone1Ext;
	}

	public void setWorkPhone1Ext(String workPhone1Ext) {
		WorkPhone1Ext = workPhone1Ext;
	}

	public String getWorkPhone2() {
		return WorkPhone2;
	}

	public void setWorkPhone2(String workPhone2) {
		WorkPhone2 = workPhone2;
	}

	public String getWorkPhone2Ext() {
		return WorkPhone2Ext;
	}

	public void setWorkPhone2Ext(String workPhone2Ext) {
		WorkPhone2Ext = workPhone2Ext;
	}

	public String getHomePhone1() {
		return HomePhone1;
	}

	public void setHomePhone1(String homePhone1) {
		HomePhone1 = homePhone1;
	}

	public String getHomePhone2() {
		return HomePhone2;
	}

	public void setHomePhone2(String homePhone2) {
		HomePhone2 = homePhone2;
	}

	public String getMobilePhone1() {
		return MobilePhone1;
	}

	public void setMobilePhone1(String mobilePhone1) {
		MobilePhone1 = mobilePhone1;
	}

	public String getMobilePhone2() {
		return MobilePhone2;
	}

	public void setMobilePhone2(String mobilePhone2) {
		MobilePhone2 = mobilePhone2;
	}

	public String getFaxPhone1() {
		return FaxPhone1;
	}

	public void setFaxPhone1(String faxPhone1) {
		FaxPhone1 = faxPhone1;
	}

	public String getFaxPhone2() {
		return FaxPhone2;
	}

	public void setFaxPhone2(String faxPhone2) {
		FaxPhone2 = faxPhone2;
	}

	public String getREffectiveDate() {
		return REffectiveDate;
	}

	public void setREffectiveDate(String rEffectiveDate) {
		REffectiveDate = rEffectiveDate;
	}

	public String getRCountry() {
		return RCountry;
	}

	public void setRCountry(String rCountry) {
		RCountry = rCountry;
	}

	public String getRAddressLine1() {
		return RAddressLine1;
	}

	public void setRAddressLine1(String rAddressLine1) {
		RAddressLine1 = rAddressLine1;
	}

	public String getRAddressLine2() {
		return RAddressLine2;
	}

	public void setRAddressLine2(String rAddressLine2) {
		RAddressLine2 = rAddressLine2;
	}

	public String getRAddressLine3() {
		return RAddressLine3;
	}

	public void setRAddressLine3(String rAddressLine3) {
		RAddressLine3 = rAddressLine3;
	}

	public String getRCity() {
		return RCity;
	}

	public void setRCity(String rCity) {
		RCity = rCity;
	}

	public String getRState() {
		return RState;
	}

	public void setRState(String rState) {
		RState = rState;
	}

	public String getRPostalCode() {
		return RPostalCode;
	}

	public void setRPostalCode(String rPostalCode) {
		RPostalCode = rPostalCode;
	}

	public String getRCounty() {
		return RCounty;
	}

	public void setRCounty(String rCounty) {
		RCounty = rCounty;
	}

	public String getRAlternateMailingName() {
		return RAlternateMailingName;
	}

	public void setRAlternateMailingName(String rAlternateMailingName) {
		RAlternateMailingName = rAlternateMailingName;
	}

	public String getMEffectiveDate() {
		return MEffectiveDate;
	}

	public void setMEffectiveDate(String mEffectiveDate) {
		MEffectiveDate = mEffectiveDate;
	}

	public String getMCountry() {
		return MCountry;
	}

	public void setMCountry(String mCountry) {
		MCountry = mCountry;
	}

	public String getMAddressLine1() {
		return MAddressLine1;
	}

	public void setMAddressLine1(String mAddressLine1) {
		MAddressLine1 = mAddressLine1;
	}

	public String getMAddressLine2() {
		return MAddressLine2;
	}

	public void setMAddressLine2(String mAddressLine2) {
		MAddressLine2 = mAddressLine2;
	}

	public String getMAddressLine3() {
		return MAddressLine3;
	}

	public void setMAddressLine3(String mAddressLine3) {
		MAddressLine3 = mAddressLine3;
	}

	public String getMCity() {
		return MCity;
	}

	public void setMCity(String mCity) {
		MCity = mCity;
	}

	public String getMState() {
		return MState;
	}

	public void setMState(String mState) {
		MState = mState;
	}

	public String getMPostalCode() {
		return MPostalCode;
	}

	public void setMPostalCode(String mPostalCode) {
		MPostalCode = mPostalCode;
	}

	public String getMCounty() {
		return MCounty;
	}

	public void setMCounty(String mCounty) {
		MCounty = mCounty;
	}

	public String getMAlternateMailingName() {
		return MAlternateMailingName;
	}

	public void setMAlternateMailingName(String mAlternateMailingName) {
		MAlternateMailingName = mAlternateMailingName;
	}

	public String getHIPAACreditableCovgDate() {
		return HIPAACreditableCovgDate;
	}

	public void setHIPAACreditableCovgDate(String hIPAACreditableCovgDate) {
		HIPAACreditableCovgDate = hIPAACreditableCovgDate;
	}

	public String getFormerHealthPlanName() {
		return FormerHealthPlanName;
	}

	public void setFormerHealthPlanName(String formerHealthPlanName) {
		FormerHealthPlanName = formerHealthPlanName;
	}

	public String getPriorCoverageList() {
		return PriorCoverageList;
	}

	public void setPriorCoverageList(String priorCoverageList) {
		PriorCoverageList = priorCoverageList;
	}

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

	public String getPreexistingConditionsList() {
		return PreexistingConditionsList;
	}

	public void setPreexistingConditionsList(String preexistingConditionsList) {
		PreexistingConditionsList = preexistingConditionsList;
	}

	public String getPreexistingConditions2() {
		return PreexistingConditions2;
	}

	public void setPreexistingConditions2(String preexistingConditions2) {
		PreexistingConditions2 = preexistingConditions2;
	}

	public String getInvestigationCompletedDate3() {
		return InvestigationCompletedDate3;
	}

	public void setInvestigationCompletedDate3(String investigationCompletedDate3) {
		InvestigationCompletedDate3 = investigationCompletedDate3;
	}

	public String getPreexistingConditionsList4() {
		return PreexistingConditionsList4;
	}

	public void setPreexistingConditionsList4(String preexistingConditionsList4) {
		PreexistingConditionsList4 = preexistingConditionsList4;
	}

	public String getPreexistingConditions5() {
		return PreexistingConditions5;
	}

	public void setPreexistingConditions5(String preexistingConditions5) {
		PreexistingConditions5 = preexistingConditions5;
	}

	public String getInvestigationCompletedDate6() {
		return InvestigationCompletedDate6;
	}

	public void setInvestigationCompletedDate6(String investigationCompletedDate6) {
		InvestigationCompletedDate6 = investigationCompletedDate6;
	}

	public String getPreexistingConditionsList7() {
		return PreexistingConditionsList7;
	}

	public void setPreexistingConditionsList7(String preexistingConditionsList7) {
		PreexistingConditionsList7 = preexistingConditionsList7;
	}

	public String getPreexistingConditions8() {
		return PreexistingConditions8;
	}

	public void setPreexistingConditions8(String preexistingConditions8) {
		PreexistingConditions8 = preexistingConditions8;
	}

	public String getInvestigationCompletedDate9() {
		return InvestigationCompletedDate9;
	}

	public void setInvestigationCompletedDate9(String investigationCompletedDate9) {
		InvestigationCompletedDate9 = investigationCompletedDate9;
	}

	public String getPreexistingConditionsList10() {
		return PreexistingConditionsList10;
	}

	public void setPreexistingConditionsList10(String preexistingConditionsList10) {
		PreexistingConditionsList10 = preexistingConditionsList10;
	}

	public String getEOBDeniedReasonCode() {
		return EOBDeniedReasonCode;
	}

	public void setEOBDeniedReasonCode(String eOBDeniedReasonCode) {
		EOBDeniedReasonCode = eOBDeniedReasonCode;
	}

	public String getEOBICD9DiagnosisCodeFrom() {
		return EOBICD9DiagnosisCodeFrom;
	}

	public void setEOBICD9DiagnosisCodeFrom(String eOBICD9DiagnosisCodeFrom) {
		EOBICD9DiagnosisCodeFrom = eOBICD9DiagnosisCodeFrom;
	}

	public String getEOBICD9DiagnosisCodeTo() {
		return EOBICD9DiagnosisCodeTo;
	}

	public void setEOBICD9DiagnosisCodeTo(String eOBICD9DiagnosisCodeTo) {
		EOBICD9DiagnosisCodeTo = eOBICD9DiagnosisCodeTo;
	}

	public String getEOBPendClaims() {
		return EOBPendClaims;
	}

	public void setEOBPendClaims(String eOBPendClaims) {
		EOBPendClaims = eOBPendClaims;
	}

	public String getEOBPendReasonCode() {
		return EOBPendReasonCode;
	}

	public void setEOBPendReasonCode(String eOBPendReasonCode) {
		EOBPendReasonCode = eOBPendReasonCode;
	}

	public String getEOBExpirationDate() {
		return EOBExpirationDate;
	}

	public void setEOBExpirationDate(String eOBExpirationDate) {
		EOBExpirationDate = eOBExpirationDate;
	}

	public String getFSAHierarchy() {
		return FSAHierarchy;
	}

	public void setFSAHierarchy(String fSAHierarchy) {
		FSAHierarchy = fSAHierarchy;
	}

	public String getLFSAHierarchy() {
		return LFSAHierarchy;
	}

	public void setLFSAHierarchy(String lFSAHierarchy) {
		LFSAHierarchy = lFSAHierarchy;
	}

	public String getHRAHierarchy() {
		return HRAHierarchy;
	}

	public void setHRAHierarchy(String hRAHierarchy) {
		HRAHierarchy = hRAHierarchy;
	}

	public String getCheckingAccountRoutingInfo() {
		return CheckingAccountRoutingInfo;
	}

	public void setCheckingAccountRoutingInfo(String checkingAccountRoutingInfo) {
		CheckingAccountRoutingInfo = checkingAccountRoutingInfo;
	}

	public String getBankCheckDigit() {
		return BankCheckDigit;
	}

	public void setBankCheckDigit(String bankCheckDigit) {
		BankCheckDigit = bankCheckDigit;
	}

	public String getCheckingAccountNum() {
		return CheckingAccountNum;
	}

	public void setCheckingAccountNum(String checkingAccountNum) {
		CheckingAccountNum = checkingAccountNum;
	}

	public String getRelationshipToEmployee() {
		return RelationshipToEmployee;
	}

	public void setRelationshipToEmployee(String relationshipToEmployee) {
		RelationshipToEmployee = relationshipToEmployee;
	}

	public String getCovgEffectiveDate() {
		return CovgEffectiveDate;
	}

	public void setCovgEffectiveDate(String covgEffectiveDate) {
		CovgEffectiveDate = covgEffectiveDate;
	}

	public String getEmploymentBeginDate() {
		return EmploymentBeginDate;
	}

	public void setEmploymentBeginDate(String employmentBeginDate) {
		EmploymentBeginDate = employmentBeginDate;
	}

	public String getCreateHRADebitCard() {
		return CreateHRADebitCard;
	}

	public void setCreateHRADebitCard(String createHRADebitCard) {
		CreateHRADebitCard = createHRADebitCard;
	}

	public String getHRAARequestReason() {
		return HRAARequestReason;
	}

	public void setHRAARequestReason(String hRAARequestReason) {
		HRAARequestReason = hRAARequestReason;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getLifestyle() {
		return Lifestyle;
	}

	public void setLifestyle(String lifestyle) {
		Lifestyle = lifestyle;
	}

	public String getIndRenewalDate() {
		return IndRenewalDate;
	}

	public void setIndRenewalDate(String indRenewalDate) {
		IndRenewalDate = indRenewalDate;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getMedicare11() {
		return Medicare11;
	}

	public void setMedicare11(String medicare11) {
		Medicare11 = medicare11;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public String getEmploymentStatus() {
		return EmploymentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		EmploymentStatus = employmentStatus;
	}

	public String getLaseredStopLoss() {
		return LaseredStopLoss;
	}

	public void setLaseredStopLoss(String laseredStopLoss) {
		LaseredStopLoss = laseredStopLoss;
	}

	public String getStopLossAmount() {
		return StopLossAmount;
	}

	public void setStopLossAmount(String stopLossAmount) {
		StopLossAmount = stopLossAmount;
	}

	public String getFrequencyOfPay() {
		return FrequencyOfPay;
	}

	public void setFrequencyOfPay(String frequencyOfPay) {
		FrequencyOfPay = frequencyOfPay;
	}

	public String getWorkHours() {
		return WorkHours;
	}

	public void setWorkHours(String workHours) {
		WorkHours = workHours;
	}

	public String getDisabilityStatus() {
		return DisabilityStatus;
	}

	public void setDisabilityStatus(String disabilityStatus) {
		DisabilityStatus = disabilityStatus;
	}

	public String getDisabilityBeginDate() {
		return DisabilityBeginDate;
	}

	public void setDisabilityBeginDate(String disabilityBeginDate) {
		DisabilityBeginDate = disabilityBeginDate;
	}

	public String getDisabilityEndDate() {
		return DisabilityEndDate;
	}

	public void setDisabilityEndDate(String disabilityEndDate) {
		DisabilityEndDate = disabilityEndDate;
	}

	public String getBillIndividual() {
		return BillIndividual;
	}

	public void setBillIndividual(String billIndividual) {
		BillIndividual = billIndividual;
	}

	public String getEmploymentEndDate() {
		return EmploymentEndDate;
	}

	public void setEmploymentEndDate(String employmentEndDate) {
		EmploymentEndDate = employmentEndDate;
	}

	public String getClientLocation() {
		return ClientLocation;
	}

	public void setClientLocation(String clientLocation) {
		ClientLocation = clientLocation;
	}

	public String getTerminationReason() {
		return TerminationReason;
	}

	public void setTerminationReason(String terminationReason) {
		TerminationReason = terminationReason;
	}

	public String getTerminationDate() {
		return TerminationDate;
	}

	public void setTerminationDate(String terminationDate) {
		TerminationDate = terminationDate;
	}

	public String getCobraReason() {
		return CobraReason;
	}

	public void setCobraReason(String cobraReason) {
		CobraReason = cobraReason;
	}

	public String getPartyViewMyInfo() {
		return PartyViewMyInfo;
	}

	public void setPartyViewMyInfo(String partyViewMyInfo) {
		PartyViewMyInfo = partyViewMyInfo;
	}

	public String getPartyDoNotDisplayAlert() {
		return PartyDoNotDisplayAlert;
	}

	public void setPartyDoNotDisplayAlert(String partyDoNotDisplayAlert) {
		PartyDoNotDisplayAlert = partyDoNotDisplayAlert;
	}

	public String getStopLossContractMaxCap() {
		return StopLossContractMaxCap;
	}

	public void setStopLossContractMaxCap(String stopLossContractMaxCap) {
		StopLossContractMaxCap = stopLossContractMaxCap;
	}

	public String getStopLossContract() {
		return StopLossContract;
	}

	public void setStopLossContract(String stopLossContract) {
		StopLossContract = stopLossContract;
	}

	public String getApplyStopLossContractMax() {
		return ApplyStopLossContractMax;
	}

	public void setApplyStopLossContractMax(String applyStopLossContractMax) {
		ApplyStopLossContractMax = applyStopLossContractMax;
	}

	public String getMBenefitPlan() {
		return MBenefitPlan;
	}

	public void setMBenefitPlan(String mBenefitPlan) {
		MBenefitPlan = mBenefitPlan;
	}

	public String getMBillPlan() {
		return MBillPlan;
	}

	public void setMBillPlan(String mBillPlan) {
		MBillPlan = mBillPlan;
	}

	public String getMTier() {
		return MTier;
	}

	public void setMTier(String mTier) {
		MTier = mTier;
	}

	public String getMCoverageLevel() {
		return MCoverageLevel;
	}

	public void setMCoverageLevel(String mCoverageLevel) {
		MCoverageLevel = mCoverageLevel;
	}

	public String getMBillingMode() {
		return MBillingMode;
	}

	public void setMBillingMode(String mBillingMode) {
		MBillingMode = mBillingMode;
	}

	public String getMFirstBillDay() {
		return MFirstBillDay;
	}

	public void setMFirstBillDay(String mFirstBillDay) {
		MFirstBillDay = mFirstBillDay;
	}

	public String getMSecondBillDay() {
		return MSecondBillDay;
	}

	public void setMSecondBillDay(String mSecondBillDay) {
		MSecondBillDay = mSecondBillDay;
	}

	public String getMRateGuaranteeFromDate() {
		return MRateGuaranteeFromDate;
	}

	public void setMRateGuaranteeFromDate(String mRateGuaranteeFromDate) {
		MRateGuaranteeFromDate = mRateGuaranteeFromDate;
	}

	public String getMRateGuaranteeThruDate() {
		return MRateGuaranteeThruDate;
	}

	public void setMRateGuaranteeThruDate(String mRateGuaranteeThruDate) {
		MRateGuaranteeThruDate = mRateGuaranteeThruDate;
	}

	public String getMCalculateAdjustments() {
		return MCalculateAdjustments;
	}

	public void setMCalculateAdjustments(String mCalculateAdjustments) {
		MCalculateAdjustments = mCalculateAdjustments;
	}

	public String getMAdjustAsOf() {
		return MAdjustAsOf;
	}

	public void setMAdjustAsOf(String mAdjustAsOf) {
		MAdjustAsOf = mAdjustAsOf;
	}

	public String getMActionExisManualAdjust() {
		return MActionExisManualAdjust;
	}

	public void setMActionExisManualAdjust(String mActionExisManualAdjust) {
		MActionExisManualAdjust = mActionExisManualAdjust;
	}

	public String getMPendClaims() {
		return MPendClaims;
	}

	public void setMPendClaims(String mPendClaims) {
		MPendClaims = mPendClaims;
	}

	public String getMPendReason() {
		return MPendReason;
	}

	public void setMPendReason(String mPendReason) {
		MPendReason = mPendReason;
	}

	public String getMSellingBroker() {
		return MSellingBroker;
	}

	public void setMSellingBroker(String mSellingBroker) {
		MSellingBroker = mSellingBroker;
	}

	public String getMExpectedBillingFromDate() {
		return MExpectedBillingFromDate;
	}

	public void setMExpectedBillingFromDate(String mExpectedBillingFromDate) {
		MExpectedBillingFromDate = mExpectedBillingFromDate;
	}

	public String getMExpectedBillingThruDate() {
		return MExpectedBillingThruDate;
	}

	public void setMExpectedBillingThruDate(String mExpectedBillingThruDate) {
		MExpectedBillingThruDate = mExpectedBillingThruDate;
	}

	public String getMApplyCOB() {
		return MApplyCOB;
	}

	public void setMApplyCOB(String mApplyCOB) {
		MApplyCOB = mApplyCOB;
	}

	public String getMPayerResponsibility() {
		return MPayerResponsibility;
	}

	public void setMPayerResponsibility(String mPayerResponsibility) {
		MPayerResponsibility = mPayerResponsibility;
	}

	public String getMCOBPolicyNumber() {
		return MCOBPolicyNumber;
	}

	public void setMCOBPolicyNumber(String mCOBPolicyNumber) {
		MCOBPolicyNumber = mCOBPolicyNumber;
	}

	public String getMCOBType() {
		return MCOBType;
	}

	public void setMCOBType(String mCOBType) {
		MCOBType = mCOBType;
	}

	public String getMOtherCarrier() {
		return MOtherCarrier;
	}

	public void setMOtherCarrier(String mOtherCarrier) {
		MOtherCarrier = mOtherCarrier;
	}

	public String getMIgnoreClaimCOBFlag() {
		return MIgnoreClaimCOBFlag;
	}

	public void setMIgnoreClaimCOBFlag(String mIgnoreClaimCOBFlag) {
		MIgnoreClaimCOBFlag = mIgnoreClaimCOBFlag;
	}

	public String getMIssueLetterforPendedCOBClaims() {
		return MIssueLetterforPendedCOBClaims;
	}

	public void setMIssueLetterforPendedCOBClaims(String mIssueLetterforPendedCOBClaims) {
		MIssueLetterforPendedCOBClaims = mIssueLetterforPendedCOBClaims;
	}

	public String getMLastInvestigatedDate() {
		return MLastInvestigatedDate;
	}

	public void setMLastInvestigatedDate(String mLastInvestigatedDate) {
		MLastInvestigatedDate = mLastInvestigatedDate;
	}

	public String getMInvestigatedAfter() {
		return MInvestigatedAfter;
	}

	public void setMInvestigatedAfter(String mInvestigatedAfter) {
		MInvestigatedAfter = mInvestigatedAfter;
	}

	public String getMCOBRuleset() {
		return MCOBRuleset;
	}

	public void setMCOBRuleset(String mCOBRuleset) {
		MCOBRuleset = mCOBRuleset;
	}

	public String getMCOBPatientCertificate() {
		return MCOBPatientCertificate;
	}

	public void setMCOBPatientCertificate(String mCOBPatientCertificate) {
		MCOBPatientCertificate = mCOBPatientCertificate;
	}

	public String getMOtherCovgInJavelina() {
		return MOtherCovgInJavelina;
	}

	public void setMOtherCovgInJavelina(String mOtherCovgInJavelina) {
		MOtherCovgInJavelina = mOtherCovgInJavelina;
	}

	public String getMPrintIDCard() {
		return MPrintIDCard;
	}

	public void setMPrintIDCard(String mPrintIDCard) {
		MPrintIDCard = mPrintIDCard;
	}

	public String getMIDCardFormat() {
		return MIDCardFormat;
	}

	public void setMIDCardFormat(String mIDCardFormat) {
		MIDCardFormat = mIDCardFormat;
	}

	public String getMCardPrintReason() {
		return MCardPrintReason;
	}

	public void setMCardPrintReason(String mCardPrintReason) {
		MCardPrintReason = mCardPrintReason;
	}

	public String getMNetworkChoice() {
		return MNetworkChoice;
	}

	public void setMNetworkChoice(String mNetworkChoice) {
		MNetworkChoice = mNetworkChoice;
	}

	public String getMIndBenefitMaximums() {
		return MIndBenefitMaximums;
	}

	public void setMIndBenefitMaximums(String mIndBenefitMaximums) {
		MIndBenefitMaximums = mIndBenefitMaximums;
	}

	public String getMLastBillDate() {
		return MLastBillDate;
	}

	public void setMLastBillDate(String mLastBillDate) {
		MLastBillDate = mLastBillDate;
	}

	public String getMNextBillDate() {
		return MNextBillDate;
	}

	public void setMNextBillDate(String mNextBillDate) {
		MNextBillDate = mNextBillDate;
	}

	public String getDBenefitPlan() {
		return DBenefitPlan;
	}

	public void setDBenefitPlan(String dBenefitPlan) {
		DBenefitPlan = dBenefitPlan;
	}

	public String getDBillPlan() {
		return DBillPlan;
	}

	public void setDBillPlan(String dBillPlan) {
		DBillPlan = dBillPlan;
	}

	public String getDTier() {
		return DTier;
	}

	public void setDTier(String dTier) {
		DTier = dTier;
	}

	public String getDCoverageLevel() {
		return DCoverageLevel;
	}

	public void setDCoverageLevel(String dCoverageLevel) {
		DCoverageLevel = dCoverageLevel;
	}

	public String getDBillingMode() {
		return DBillingMode;
	}

	public void setDBillingMode(String dBillingMode) {
		DBillingMode = dBillingMode;
	}

	public String getDFirstBillDay() {
		return DFirstBillDay;
	}

	public void setDFirstBillDay(String dFirstBillDay) {
		DFirstBillDay = dFirstBillDay;
	}

	public String getDSecondBillDay() {
		return DSecondBillDay;
	}

	public void setDSecondBillDay(String dSecondBillDay) {
		DSecondBillDay = dSecondBillDay;
	}

	public String getDRateGuaranteeFromDate() {
		return DRateGuaranteeFromDate;
	}

	public void setDRateGuaranteeFromDate(String dRateGuaranteeFromDate) {
		DRateGuaranteeFromDate = dRateGuaranteeFromDate;
	}

	public String getDRateGuaranteeThruDate() {
		return DRateGuaranteeThruDate;
	}

	public void setDRateGuaranteeThruDate(String dRateGuaranteeThruDate) {
		DRateGuaranteeThruDate = dRateGuaranteeThruDate;
	}

	public String getDCalculateAdjustments() {
		return DCalculateAdjustments;
	}

	public void setDCalculateAdjustments(String dCalculateAdjustments) {
		DCalculateAdjustments = dCalculateAdjustments;
	}

	public String getDAdjustAsOf() {
		return DAdjustAsOf;
	}

	public void setDAdjustAsOf(String dAdjustAsOf) {
		DAdjustAsOf = dAdjustAsOf;
	}

	public String getDActionExisManualAdjust() {
		return DActionExisManualAdjust;
	}

	public void setDActionExisManualAdjust(String dActionExisManualAdjust) {
		DActionExisManualAdjust = dActionExisManualAdjust;
	}

	public String getDPendClaims() {
		return DPendClaims;
	}

	public void setDPendClaims(String dPendClaims) {
		DPendClaims = dPendClaims;
	}

	public String getDPendReason() {
		return DPendReason;
	}

	public void setDPendReason(String dPendReason) {
		DPendReason = dPendReason;
	}

	public String getDSellingBroker() {
		return DSellingBroker;
	}

	public void setDSellingBroker(String dSellingBroker) {
		DSellingBroker = dSellingBroker;
	}

	public String getDExpectedBillingFromDate() {
		return DExpectedBillingFromDate;
	}

	public void setDExpectedBillingFromDate(String dExpectedBillingFromDate) {
		DExpectedBillingFromDate = dExpectedBillingFromDate;
	}

	public String getDExpectedBillingThruDate() {
		return DExpectedBillingThruDate;
	}

	public void setDExpectedBillingThruDate(String dExpectedBillingThruDate) {
		DExpectedBillingThruDate = dExpectedBillingThruDate;
	}

	public String getDApplyCOB() {
		return DApplyCOB;
	}

	public void setDApplyCOB(String dApplyCOB) {
		DApplyCOB = dApplyCOB;
	}

	public String getDPayerResponsibility() {
		return DPayerResponsibility;
	}

	public void setDPayerResponsibility(String dPayerResponsibility) {
		DPayerResponsibility = dPayerResponsibility;
	}

	public String getDCOBPolicyNumber() {
		return DCOBPolicyNumber;
	}

	public void setDCOBPolicyNumber(String dCOBPolicyNumber) {
		DCOBPolicyNumber = dCOBPolicyNumber;
	}

	public String getDCOBType() {
		return DCOBType;
	}

	public void setDCOBType(String dCOBType) {
		DCOBType = dCOBType;
	}

	public String getDOtherCarrier() {
		return DOtherCarrier;
	}

	public void setDOtherCarrier(String dOtherCarrier) {
		DOtherCarrier = dOtherCarrier;
	}

	public String getDIgnoreClaimCOBFlag() {
		return DIgnoreClaimCOBFlag;
	}

	public void setDIgnoreClaimCOBFlag(String dIgnoreClaimCOBFlag) {
		DIgnoreClaimCOBFlag = dIgnoreClaimCOBFlag;
	}

	public String getDIssueLetterforPendedCOBClaims() {
		return DIssueLetterforPendedCOBClaims;
	}

	public void setDIssueLetterforPendedCOBClaims(String dIssueLetterforPendedCOBClaims) {
		DIssueLetterforPendedCOBClaims = dIssueLetterforPendedCOBClaims;
	}

	public String getDLastInvestigatedDate() {
		return DLastInvestigatedDate;
	}

	public void setDLastInvestigatedDate(String dLastInvestigatedDate) {
		DLastInvestigatedDate = dLastInvestigatedDate;
	}

	public String getDInvestigatedAfter() {
		return DInvestigatedAfter;
	}

	public void setDInvestigatedAfter(String dInvestigatedAfter) {
		DInvestigatedAfter = dInvestigatedAfter;
	}

	public String getDCOBRuleset() {
		return DCOBRuleset;
	}

	public void setDCOBRuleset(String dCOBRuleset) {
		DCOBRuleset = dCOBRuleset;
	}

	public String getDCOBPatientCertificate() {
		return DCOBPatientCertificate;
	}

	public void setDCOBPatientCertificate(String dCOBPatientCertificate) {
		DCOBPatientCertificate = dCOBPatientCertificate;
	}

	public String getDOtherCovgInJavelina() {
		return DOtherCovgInJavelina;
	}

	public void setDOtherCovgInJavelina(String dOtherCovgInJavelina) {
		DOtherCovgInJavelina = dOtherCovgInJavelina;
	}

	public String getDPrintIDCard() {
		return DPrintIDCard;
	}

	public void setDPrintIDCard(String dPrintIDCard) {
		DPrintIDCard = dPrintIDCard;
	}

	public String getDIDCardFormat() {
		return DIDCardFormat;
	}

	public void setDIDCardFormat(String dIDCardFormat) {
		DIDCardFormat = dIDCardFormat;
	}

	public String getDCardPrintReason() {
		return DCardPrintReason;
	}

	public void setDCardPrintReason(String dCardPrintReason) {
		DCardPrintReason = dCardPrintReason;
	}

	public String getDNetworkChoice() {
		return DNetworkChoice;
	}

	public void setDNetworkChoice(String dNetworkChoice) {
		DNetworkChoice = dNetworkChoice;
	}

	public String getDIndBenefitMaximums() {
		return DIndBenefitMaximums;
	}

	public void setDIndBenefitMaximums(String dIndBenefitMaximums) {
		DIndBenefitMaximums = dIndBenefitMaximums;
	}

	public String getDLastBillDate() {
		return DLastBillDate;
	}

	public void setDLastBillDate(String dLastBillDate) {
		DLastBillDate = dLastBillDate;
	}

	public String getDNextBillDate() {
		return DNextBillDate;
	}

	public void setDNextBillDate(String dNextBillDate) {
		DNextBillDate = dNextBillDate;
	}

	public String getVBenefitPlan() {
		return VBenefitPlan;
	}

	public void setVBenefitPlan(String vBenefitPlan) {
		VBenefitPlan = vBenefitPlan;
	}

	public String getVBillPlan() {
		return VBillPlan;
	}

	public void setVBillPlan(String vBillPlan) {
		VBillPlan = vBillPlan;
	}

	public String getVTier() {
		return VTier;
	}

	public void setVTier(String vTier) {
		VTier = vTier;
	}

	public String getVCoverageLevel() {
		return VCoverageLevel;
	}

	public void setVCoverageLevel(String vCoverageLevel) {
		VCoverageLevel = vCoverageLevel;
	}

	public String getVBillingMode() {
		return VBillingMode;
	}

	public void setVBillingMode(String vBillingMode) {
		VBillingMode = vBillingMode;
	}

	public String getVFirstBillDay() {
		return VFirstBillDay;
	}

	public void setVFirstBillDay(String vFirstBillDay) {
		VFirstBillDay = vFirstBillDay;
	}

	public String getVSecondBillDay() {
		return VSecondBillDay;
	}

	public void setVSecondBillDay(String vSecondBillDay) {
		VSecondBillDay = vSecondBillDay;
	}

	public String getVRateGuaranteeFromDate() {
		return VRateGuaranteeFromDate;
	}

	public void setVRateGuaranteeFromDate(String vRateGuaranteeFromDate) {
		VRateGuaranteeFromDate = vRateGuaranteeFromDate;
	}

	public String getVRateGuaranteeThruDate() {
		return VRateGuaranteeThruDate;
	}

	public void setVRateGuaranteeThruDate(String vRateGuaranteeThruDate) {
		VRateGuaranteeThruDate = vRateGuaranteeThruDate;
	}

	public String getVCalculateAdjustments() {
		return VCalculateAdjustments;
	}

	public void setVCalculateAdjustments(String vCalculateAdjustments) {
		VCalculateAdjustments = vCalculateAdjustments;
	}

	public String getVAdjustAsOf() {
		return VAdjustAsOf;
	}

	public void setVAdjustAsOf(String vAdjustAsOf) {
		VAdjustAsOf = vAdjustAsOf;
	}

	public String getVActionExisManualAdjust() {
		return VActionExisManualAdjust;
	}

	public void setVActionExisManualAdjust(String vActionExisManualAdjust) {
		VActionExisManualAdjust = vActionExisManualAdjust;
	}

	public String getVPendClaims() {
		return VPendClaims;
	}

	public void setVPendClaims(String vPendClaims) {
		VPendClaims = vPendClaims;
	}

	public String getVPendReason() {
		return VPendReason;
	}

	public void setVPendReason(String vPendReason) {
		VPendReason = vPendReason;
	}

	public String getVSellingBroker() {
		return VSellingBroker;
	}

	public void setVSellingBroker(String vSellingBroker) {
		VSellingBroker = vSellingBroker;
	}

	public String getVExpectedBillingFromDate() {
		return VExpectedBillingFromDate;
	}

	public void setVExpectedBillingFromDate(String vExpectedBillingFromDate) {
		VExpectedBillingFromDate = vExpectedBillingFromDate;
	}

	public String getVExpectedBillingThruDate() {
		return VExpectedBillingThruDate;
	}

	public void setVExpectedBillingThruDate(String vExpectedBillingThruDate) {
		VExpectedBillingThruDate = vExpectedBillingThruDate;
	}

	public String getVApplyCOB() {
		return VApplyCOB;
	}

	public void setVApplyCOB(String vApplyCOB) {
		VApplyCOB = vApplyCOB;
	}

	public String getVPayerResponsibility() {
		return VPayerResponsibility;
	}

	public void setVPayerResponsibility(String vPayerResponsibility) {
		VPayerResponsibility = vPayerResponsibility;
	}

	public String getVCOBPolicyNumber() {
		return VCOBPolicyNumber;
	}

	public void setVCOBPolicyNumber(String vCOBPolicyNumber) {
		VCOBPolicyNumber = vCOBPolicyNumber;
	}

	public String getVCOBType() {
		return VCOBType;
	}

	public void setVCOBType(String vCOBType) {
		VCOBType = vCOBType;
	}

	public String getVOtherCarrier() {
		return VOtherCarrier;
	}

	public void setVOtherCarrier(String vOtherCarrier) {
		VOtherCarrier = vOtherCarrier;
	}

	public String getVIgnoreClaimCOBFlag() {
		return VIgnoreClaimCOBFlag;
	}

	public void setVIgnoreClaimCOBFlag(String vIgnoreClaimCOBFlag) {
		VIgnoreClaimCOBFlag = vIgnoreClaimCOBFlag;
	}

	public String getVIssueLetterforPendedCOBClaims() {
		return VIssueLetterforPendedCOBClaims;
	}

	public void setVIssueLetterforPendedCOBClaims(String vIssueLetterforPendedCOBClaims) {
		VIssueLetterforPendedCOBClaims = vIssueLetterforPendedCOBClaims;
	}

	public String getVLastInvestigatedDate() {
		return VLastInvestigatedDate;
	}

	public void setVLastInvestigatedDate(String vLastInvestigatedDate) {
		VLastInvestigatedDate = vLastInvestigatedDate;
	}

	public String getVInvestigatedAfter() {
		return VInvestigatedAfter;
	}

	public void setVInvestigatedAfter(String vInvestigatedAfter) {
		VInvestigatedAfter = vInvestigatedAfter;
	}

	public String getVCOBRuleset() {
		return VCOBRuleset;
	}

	public void setVCOBRuleset(String vCOBRuleset) {
		VCOBRuleset = vCOBRuleset;
	}

	public String getVCOBPatientCertificate() {
		return VCOBPatientCertificate;
	}

	public void setVCOBPatientCertificate(String vCOBPatientCertificate) {
		VCOBPatientCertificate = vCOBPatientCertificate;
	}

	public String getVOtherCovgInJavelina() {
		return VOtherCovgInJavelina;
	}

	public void setVOtherCovgInJavelina(String vOtherCovgInJavelina) {
		VOtherCovgInJavelina = vOtherCovgInJavelina;
	}

	public String getVPrintIDCard() {
		return VPrintIDCard;
	}

	public void setVPrintIDCard(String vPrintIDCard) {
		VPrintIDCard = vPrintIDCard;
	}

	public String getVIDCardFormat() {
		return VIDCardFormat;
	}

	public void setVIDCardFormat(String vIDCardFormat) {
		VIDCardFormat = vIDCardFormat;
	}

	public String getVCardPrintReason() {
		return VCardPrintReason;
	}

	public void setVCardPrintReason(String vCardPrintReason) {
		VCardPrintReason = vCardPrintReason;
	}

	public String getVNetworkChoice() {
		return VNetworkChoice;
	}

	public void setVNetworkChoice(String vNetworkChoice) {
		VNetworkChoice = vNetworkChoice;
	}

	public String getVIndBenefitMaximums() {
		return VIndBenefitMaximums;
	}

	public void setVIndBenefitMaximums(String vIndBenefitMaximums) {
		VIndBenefitMaximums = vIndBenefitMaximums;
	}

	public String getVLastBillDate() {
		return VLastBillDate;
	}

	public void setVLastBillDate(String vLastBillDate) {
		VLastBillDate = vLastBillDate;
	}

	public String getVNextBillDate() {
		return VNextBillDate;
	}

	public void setVNextBillDate(String vNextBillDate) {
		VNextBillDate = vNextBillDate;
	}

	public String getPBenefitPlan() {
		return PBenefitPlan;
	}

	public void setPBenefitPlan(String pBenefitPlan) {
		PBenefitPlan = pBenefitPlan;
	}

	public String getPBillPlan() {
		return PBillPlan;
	}

	public void setPBillPlan(String pBillPlan) {
		PBillPlan = pBillPlan;
	}

	public String getPTier() {
		return PTier;
	}

	public void setPTier(String pTier) {
		PTier = pTier;
	}

	public String getPCoverageLevel() {
		return PCoverageLevel;
	}

	public void setPCoverageLevel(String pCoverageLevel) {
		PCoverageLevel = pCoverageLevel;
	}

	public String getPBillingMode() {
		return PBillingMode;
	}

	public void setPBillingMode(String pBillingMode) {
		PBillingMode = pBillingMode;
	}

	public String getPFirstBillDay() {
		return PFirstBillDay;
	}

	public void setPFirstBillDay(String pFirstBillDay) {
		PFirstBillDay = pFirstBillDay;
	}

	public String getPSecondBillDay() {
		return PSecondBillDay;
	}

	public void setPSecondBillDay(String pSecondBillDay) {
		PSecondBillDay = pSecondBillDay;
	}

	public String getPRateGuaranteeFromDate() {
		return PRateGuaranteeFromDate;
	}

	public void setPRateGuaranteeFromDate(String pRateGuaranteeFromDate) {
		PRateGuaranteeFromDate = pRateGuaranteeFromDate;
	}

	public String getPRateGuaranteeThruDate() {
		return PRateGuaranteeThruDate;
	}

	public void setPRateGuaranteeThruDate(String pRateGuaranteeThruDate) {
		PRateGuaranteeThruDate = pRateGuaranteeThruDate;
	}

	public String getPCalculateAdjustments() {
		return PCalculateAdjustments;
	}

	public void setPCalculateAdjustments(String pCalculateAdjustments) {
		PCalculateAdjustments = pCalculateAdjustments;
	}

	public String getPAdjustAsOf() {
		return PAdjustAsOf;
	}

	public void setPAdjustAsOf(String pAdjustAsOf) {
		PAdjustAsOf = pAdjustAsOf;
	}

	public String getPActionExisManualAdjust() {
		return PActionExisManualAdjust;
	}

	public void setPActionExisManualAdjust(String pActionExisManualAdjust) {
		PActionExisManualAdjust = pActionExisManualAdjust;
	}

	public String getPPendClaims() {
		return PPendClaims;
	}

	public void setPPendClaims(String pPendClaims) {
		PPendClaims = pPendClaims;
	}

	public String getPPendReason() {
		return PPendReason;
	}

	public void setPPendReason(String pPendReason) {
		PPendReason = pPendReason;
	}

	public String getPSellingBroker() {
		return PSellingBroker;
	}

	public void setPSellingBroker(String pSellingBroker) {
		PSellingBroker = pSellingBroker;
	}

	public String getPExpectedBillingFromDate() {
		return PExpectedBillingFromDate;
	}

	public void setPExpectedBillingFromDate(String pExpectedBillingFromDate) {
		PExpectedBillingFromDate = pExpectedBillingFromDate;
	}

	public String getPExpectedBillingThruDate() {
		return PExpectedBillingThruDate;
	}

	public void setPExpectedBillingThruDate(String pExpectedBillingThruDate) {
		PExpectedBillingThruDate = pExpectedBillingThruDate;
	}

	public String getPApplyCOB() {
		return PApplyCOB;
	}

	public void setPApplyCOB(String pApplyCOB) {
		PApplyCOB = pApplyCOB;
	}

	public String getPPayerResponsibility() {
		return PPayerResponsibility;
	}

	public void setPPayerResponsibility(String pPayerResponsibility) {
		PPayerResponsibility = pPayerResponsibility;
	}

	public String getPCOBPolicyNumber() {
		return PCOBPolicyNumber;
	}

	public void setPCOBPolicyNumber(String pCOBPolicyNumber) {
		PCOBPolicyNumber = pCOBPolicyNumber;
	}

	public String getPCOBType() {
		return PCOBType;
	}

	public void setPCOBType(String pCOBType) {
		PCOBType = pCOBType;
	}

	public String getPOtherCarrier() {
		return POtherCarrier;
	}

	public void setPOtherCarrier(String pOtherCarrier) {
		POtherCarrier = pOtherCarrier;
	}

	public String getPIgnoreClaimCOBFlag() {
		return PIgnoreClaimCOBFlag;
	}

	public void setPIgnoreClaimCOBFlag(String pIgnoreClaimCOBFlag) {
		PIgnoreClaimCOBFlag = pIgnoreClaimCOBFlag;
	}

	public String getPIssueLetterforPendedCOBClaims() {
		return PIssueLetterforPendedCOBClaims;
	}

	public void setPIssueLetterforPendedCOBClaims(String pIssueLetterforPendedCOBClaims) {
		PIssueLetterforPendedCOBClaims = pIssueLetterforPendedCOBClaims;
	}

	public String getPLastInvestigatedDate() {
		return PLastInvestigatedDate;
	}

	public void setPLastInvestigatedDate(String pLastInvestigatedDate) {
		PLastInvestigatedDate = pLastInvestigatedDate;
	}

	public String getPInvestigatedAfter() {
		return PInvestigatedAfter;
	}

	public void setPInvestigatedAfter(String pInvestigatedAfter) {
		PInvestigatedAfter = pInvestigatedAfter;
	}

	public String getPCOBRuleset() {
		return PCOBRuleset;
	}

	public void setPCOBRuleset(String pCOBRuleset) {
		PCOBRuleset = pCOBRuleset;
	}

	public String getPCOBPatientCertificate() {
		return PCOBPatientCertificate;
	}

	public void setPCOBPatientCertificate(String pCOBPatientCertificate) {
		PCOBPatientCertificate = pCOBPatientCertificate;
	}

	public String getPOtherCovgInJavelina() {
		return POtherCovgInJavelina;
	}

	public void setPOtherCovgInJavelina(String pOtherCovgInJavelina) {
		POtherCovgInJavelina = pOtherCovgInJavelina;
	}

	public String getPPrintIDCard() {
		return PPrintIDCard;
	}

	public void setPPrintIDCard(String pPrintIDCard) {
		PPrintIDCard = pPrintIDCard;
	}

	public String getPIDCardFormat() {
		return PIDCardFormat;
	}

	public void setPIDCardFormat(String pIDCardFormat) {
		PIDCardFormat = pIDCardFormat;
	}

	public String getPCardPrintReason() {
		return PCardPrintReason;
	}

	public void setPCardPrintReason(String pCardPrintReason) {
		PCardPrintReason = pCardPrintReason;
	}

	public String getPNetworkChoice() {
		return PNetworkChoice;
	}

	public void setPNetworkChoice(String pNetworkChoice) {
		PNetworkChoice = pNetworkChoice;
	}

	public String getPIndBenefitMaximums() {
		return PIndBenefitMaximums;
	}

	public void setPIndBenefitMaximums(String pIndBenefitMaximums) {
		PIndBenefitMaximums = pIndBenefitMaximums;
	}

	public String getPLastBillDate() {
		return PLastBillDate;
	}

	public void setPLastBillDate(String pLastBillDate) {
		PLastBillDate = pLastBillDate;
	}

	public String getPNextBillDate() {
		return PNextBillDate;
	}

	public void setPNextBillDate(String pNextBillDate) {
		PNextBillDate = pNextBillDate;
	}

	public String getFBenefitPlan() {
		return FBenefitPlan;
	}

	public void setFBenefitPlan(String fBenefitPlan) {
		FBenefitPlan = fBenefitPlan;
	}

	public String getFBillPlan() {
		return FBillPlan;
	}

	public void setFBillPlan(String fBillPlan) {
		FBillPlan = fBillPlan;
	}

	public String getFTier() {
		return FTier;
	}

	public void setFTier(String fTier) {
		FTier = fTier;
	}

	public String getFCoverageLevel() {
		return FCoverageLevel;
	}

	public void setFCoverageLevel(String fCoverageLevel) {
		FCoverageLevel = fCoverageLevel;
	}

	public String getFBillingMode() {
		return FBillingMode;
	}

	public void setFBillingMode(String fBillingMode) {
		FBillingMode = fBillingMode;
	}

	public String getFFirstBillDay() {
		return FFirstBillDay;
	}

	public void setFFirstBillDay(String fFirstBillDay) {
		FFirstBillDay = fFirstBillDay;
	}

	public String getFSecondBillDay() {
		return FSecondBillDay;
	}

	public void setFSecondBillDay(String fSecondBillDay) {
		FSecondBillDay = fSecondBillDay;
	}

	public String getFRateGuaranteeFromDate() {
		return FRateGuaranteeFromDate;
	}

	public void setFRateGuaranteeFromDate(String fRateGuaranteeFromDate) {
		FRateGuaranteeFromDate = fRateGuaranteeFromDate;
	}

	public String getFRateGuaranteeThruDate() {
		return FRateGuaranteeThruDate;
	}

	public void setFRateGuaranteeThruDate(String fRateGuaranteeThruDate) {
		FRateGuaranteeThruDate = fRateGuaranteeThruDate;
	}

	public String getFCalculateAdjustments() {
		return FCalculateAdjustments;
	}

	public void setFCalculateAdjustments(String fCalculateAdjustments) {
		FCalculateAdjustments = fCalculateAdjustments;
	}

	public String getFAdjustAsOf() {
		return FAdjustAsOf;
	}

	public void setFAdjustAsOf(String fAdjustAsOf) {
		FAdjustAsOf = fAdjustAsOf;
	}

	public String getFActionExisManualAdjust() {
		return FActionExisManualAdjust;
	}

	public void setFActionExisManualAdjust(String fActionExisManualAdjust) {
		FActionExisManualAdjust = fActionExisManualAdjust;
	}

	public String getFPendClaims() {
		return FPendClaims;
	}

	public void setFPendClaims(String fPendClaims) {
		FPendClaims = fPendClaims;
	}

	public String getFPendReason() {
		return FPendReason;
	}

	public void setFPendReason(String fPendReason) {
		FPendReason = fPendReason;
	}

	public String getFSellingBroker() {
		return FSellingBroker;
	}

	public void setFSellingBroker(String fSellingBroker) {
		FSellingBroker = fSellingBroker;
	}

	public String getFExpectedBillingFromDate() {
		return FExpectedBillingFromDate;
	}

	public void setFExpectedBillingFromDate(String fExpectedBillingFromDate) {
		FExpectedBillingFromDate = fExpectedBillingFromDate;
	}

	public String getFExpectedBillingThruDate() {
		return FExpectedBillingThruDate;
	}

	public void setFExpectedBillingThruDate(String fExpectedBillingThruDate) {
		FExpectedBillingThruDate = fExpectedBillingThruDate;
	}

	public String getFApplyCOB() {
		return FApplyCOB;
	}

	public void setFApplyCOB(String fApplyCOB) {
		FApplyCOB = fApplyCOB;
	}

	public String getFPayerResponsibility() {
		return FPayerResponsibility;
	}

	public void setFPayerResponsibility(String fPayerResponsibility) {
		FPayerResponsibility = fPayerResponsibility;
	}

	public String getFCOBPolicyNumber() {
		return FCOBPolicyNumber;
	}

	public void setFCOBPolicyNumber(String fCOBPolicyNumber) {
		FCOBPolicyNumber = fCOBPolicyNumber;
	}

	public String getFCOBType() {
		return FCOBType;
	}

	public void setFCOBType(String fCOBType) {
		FCOBType = fCOBType;
	}

	public String getFOtherCarrier() {
		return FOtherCarrier;
	}

	public void setFOtherCarrier(String fOtherCarrier) {
		FOtherCarrier = fOtherCarrier;
	}

	public String getFIgnoreClaimCOBFlag() {
		return FIgnoreClaimCOBFlag;
	}

	public void setFIgnoreClaimCOBFlag(String fIgnoreClaimCOBFlag) {
		FIgnoreClaimCOBFlag = fIgnoreClaimCOBFlag;
	}

	public String getFIssueLetterforPendedCOBClaims() {
		return FIssueLetterforPendedCOBClaims;
	}

	public void setFIssueLetterforPendedCOBClaims(String fIssueLetterforPendedCOBClaims) {
		FIssueLetterforPendedCOBClaims = fIssueLetterforPendedCOBClaims;
	}

	public String getFLastBillDate() {
		return FLastBillDate;
	}

	public void setFLastBillDate(String fLastBillDate) {
		FLastBillDate = fLastBillDate;
	}

	public String getFNextBillDate() {
		return FNextBillDate;
	}

	public void setFNextBillDate(String fNextBillDate) {
		FNextBillDate = fNextBillDate;
	}

	public String getSTDBenefitPlan() {
		return STDBenefitPlan;
	}

	public void setSTDBenefitPlan(String sTDBenefitPlan) {
		STDBenefitPlan = sTDBenefitPlan;
	}

	public String getSTDBillPlan() {
		return STDBillPlan;
	}

	public void setSTDBillPlan(String sTDBillPlan) {
		STDBillPlan = sTDBillPlan;
	}

	public String getSTDTier() {
		return STDTier;
	}

	public void setSTDTier(String sTDTier) {
		STDTier = sTDTier;
	}

	public String getSTDCoverageLevel() {
		return STDCoverageLevel;
	}

	public void setSTDCoverageLevel(String sTDCoverageLevel) {
		STDCoverageLevel = sTDCoverageLevel;
	}

	public String getSTDBillingMode() {
		return STDBillingMode;
	}

	public void setSTDBillingMode(String sTDBillingMode) {
		STDBillingMode = sTDBillingMode;
	}

	public String getSTDFirstBillDay() {
		return STDFirstBillDay;
	}

	public void setSTDFirstBillDay(String sTDFirstBillDay) {
		STDFirstBillDay = sTDFirstBillDay;
	}

	public String getSTDSecondBillDay() {
		return STDSecondBillDay;
	}

	public void setSTDSecondBillDay(String sTDSecondBillDay) {
		STDSecondBillDay = sTDSecondBillDay;
	}

	public String getSTDRateGuaranteeFromDate() {
		return STDRateGuaranteeFromDate;
	}

	public void setSTDRateGuaranteeFromDate(String sTDRateGuaranteeFromDate) {
		STDRateGuaranteeFromDate = sTDRateGuaranteeFromDate;
	}

	public String getSTDRateGuaranteeThruDate() {
		return STDRateGuaranteeThruDate;
	}

	public void setSTDRateGuaranteeThruDate(String sTDRateGuaranteeThruDate) {
		STDRateGuaranteeThruDate = sTDRateGuaranteeThruDate;
	}

	public String getSTDCalculateAdjustments() {
		return STDCalculateAdjustments;
	}

	public void setSTDCalculateAdjustments(String sTDCalculateAdjustments) {
		STDCalculateAdjustments = sTDCalculateAdjustments;
	}

	public String getSTDAdjustAsOf() {
		return STDAdjustAsOf;
	}

	public void setSTDAdjustAsOf(String sTDAdjustAsOf) {
		STDAdjustAsOf = sTDAdjustAsOf;
	}

	public String getSTDActionExisManualAdjust() {
		return STDActionExisManualAdjust;
	}

	public void setSTDActionExisManualAdjust(String sTDActionExisManualAdjust) {
		STDActionExisManualAdjust = sTDActionExisManualAdjust;
	}

	public String getSTDPendClaims() {
		return STDPendClaims;
	}

	public void setSTDPendClaims(String sTDPendClaims) {
		STDPendClaims = sTDPendClaims;
	}

	public String getSTDPendReason() {
		return STDPendReason;
	}

	public void setSTDPendReason(String sTDPendReason) {
		STDPendReason = sTDPendReason;
	}

	public String getSTDSellingBroker() {
		return STDSellingBroker;
	}

	public void setSTDSellingBroker(String sTDSellingBroker) {
		STDSellingBroker = sTDSellingBroker;
	}

	public String getSTDExpectedBillingFromDate() {
		return STDExpectedBillingFromDate;
	}

	public void setSTDExpectedBillingFromDate(String sTDExpectedBillingFromDate) {
		STDExpectedBillingFromDate = sTDExpectedBillingFromDate;
	}

	public String getSTDExpectedBillingThruDate() {
		return STDExpectedBillingThruDate;
	}

	public void setSTDExpectedBillingThruDate(String sTDExpectedBillingThruDate) {
		STDExpectedBillingThruDate = sTDExpectedBillingThruDate;
	}

	public String getSTDVolume() {
		return STDVolume;
	}

	public void setSTDVolume(String sTDVolume) {
		STDVolume = sTDVolume;
	}

	public String getSTDLastBillDate() {
		return STDLastBillDate;
	}

	public void setSTDLastBillDate(String sTDLastBillDate) {
		STDLastBillDate = sTDLastBillDate;
	}

	public String getSTDNextBillDate() {
		return STDNextBillDate;
	}

	public void setSTDNextBillDate(String sTDNextBillDate) {
		STDNextBillDate = sTDNextBillDate;
	}

	public String getLTDBenefitPlan() {
		return LTDBenefitPlan;
	}

	public void setLTDBenefitPlan(String lTDBenefitPlan) {
		LTDBenefitPlan = lTDBenefitPlan;
	}

	public String getLTDBillPlan() {
		return LTDBillPlan;
	}

	public void setLTDBillPlan(String lTDBillPlan) {
		LTDBillPlan = lTDBillPlan;
	}

	public String getLTDTier() {
		return LTDTier;
	}

	public void setLTDTier(String lTDTier) {
		LTDTier = lTDTier;
	}

	public String getLTDCoverageLevel() {
		return LTDCoverageLevel;
	}

	public void setLTDCoverageLevel(String lTDCoverageLevel) {
		LTDCoverageLevel = lTDCoverageLevel;
	}

	public String getLTDBillingMode() {
		return LTDBillingMode;
	}

	public void setLTDBillingMode(String lTDBillingMode) {
		LTDBillingMode = lTDBillingMode;
	}

	public String getLTDFirstBillDay() {
		return LTDFirstBillDay;
	}

	public void setLTDFirstBillDay(String lTDFirstBillDay) {
		LTDFirstBillDay = lTDFirstBillDay;
	}

	public String getLTDSecondBillDay() {
		return LTDSecondBillDay;
	}

	public void setLTDSecondBillDay(String lTDSecondBillDay) {
		LTDSecondBillDay = lTDSecondBillDay;
	}

	public String getLTDRateGuaranteeFromDate() {
		return LTDRateGuaranteeFromDate;
	}

	public void setLTDRateGuaranteeFromDate(String lTDRateGuaranteeFromDate) {
		LTDRateGuaranteeFromDate = lTDRateGuaranteeFromDate;
	}

	public String getLTDRateGuaranteeThruDate() {
		return LTDRateGuaranteeThruDate;
	}

	public void setLTDRateGuaranteeThruDate(String lTDRateGuaranteeThruDate) {
		LTDRateGuaranteeThruDate = lTDRateGuaranteeThruDate;
	}

	public String getLTDCalculateAdjustments() {
		return LTDCalculateAdjustments;
	}

	public void setLTDCalculateAdjustments(String lTDCalculateAdjustments) {
		LTDCalculateAdjustments = lTDCalculateAdjustments;
	}

	public String getLTDAdjustAsOf() {
		return LTDAdjustAsOf;
	}

	public void setLTDAdjustAsOf(String lTDAdjustAsOf) {
		LTDAdjustAsOf = lTDAdjustAsOf;
	}

	public String getLTDActionExisManualAdjust() {
		return LTDActionExisManualAdjust;
	}

	public void setLTDActionExisManualAdjust(String lTDActionExisManualAdjust) {
		LTDActionExisManualAdjust = lTDActionExisManualAdjust;
	}

	public String getLTDPendClaims() {
		return LTDPendClaims;
	}

	public void setLTDPendClaims(String lTDPendClaims) {
		LTDPendClaims = lTDPendClaims;
	}

	public String getLTDPendReason() {
		return LTDPendReason;
	}

	public void setLTDPendReason(String lTDPendReason) {
		LTDPendReason = lTDPendReason;
	}

	public String getLTDSellingBroker() {
		return LTDSellingBroker;
	}

	public void setLTDSellingBroker(String lTDSellingBroker) {
		LTDSellingBroker = lTDSellingBroker;
	}

	public String getLTDExpectedBillingFromDate() {
		return LTDExpectedBillingFromDate;
	}

	public void setLTDExpectedBillingFromDate(String lTDExpectedBillingFromDate) {
		LTDExpectedBillingFromDate = lTDExpectedBillingFromDate;
	}

	public String getLTDExpectedBillingThruDate() {
		return LTDExpectedBillingThruDate;
	}

	public void setLTDExpectedBillingThruDate(String lTDExpectedBillingThruDate) {
		LTDExpectedBillingThruDate = lTDExpectedBillingThruDate;
	}

	public String getLTDVolume() {
		return LTDVolume;
	}

	public void setLTDVolume(String lTDVolume) {
		LTDVolume = lTDVolume;
	}

	public String getLTDLastBillDate() {
		return LTDLastBillDate;
	}

	public void setLTDLastBillDate(String lTDLastBillDate) {
		LTDLastBillDate = lTDLastBillDate;
	}

	public String getLTDNextBillDate() {
		return LTDNextBillDate;
	}

	public void setLTDNextBillDate(String lTDNextBillDate) {
		LTDNextBillDate = lTDNextBillDate;
	}

	public String getSC1ProductName() {
		return SC1ProductName;
	}

	public void setSC1ProductName(String sC1ProductName) {
		SC1ProductName = sC1ProductName;
	}

	public String getSC1Volume() {
		return SC1Volume;
	}

	public void setSC1Volume(String sC1Volume) {
		SC1Volume = sC1Volume;
	}

	public String getSC1CoverageLevel() {
		return SC1CoverageLevel;
	}

	public void setSC1CoverageLevel(String sC1CoverageLevel) {
		SC1CoverageLevel = sC1CoverageLevel;
	}

	public String getSC1BillPlan() {
		return SC1BillPlan;
	}

	public void setSC1BillPlan(String sC1BillPlan) {
		SC1BillPlan = sC1BillPlan;
	}

	public String getSC1Tier() {
		return SC1Tier;
	}

	public void setSC1Tier(String sC1Tier) {
		SC1Tier = sC1Tier;
	}

	public String getSC1CalculateAdjustments() {
		return SC1CalculateAdjustments;
	}

	public void setSC1CalculateAdjustments(String sC1CalculateAdjustments) {
		SC1CalculateAdjustments = sC1CalculateAdjustments;
	}

	public String getSC1AdjustAsOf() {
		return SC1AdjustAsOf;
	}

	public void setSC1AdjustAsOf(String sC1AdjustAsOf) {
		SC1AdjustAsOf = sC1AdjustAsOf;
	}

	public String getSC1ActionExisManualAdjust() {
		return SC1ActionExisManualAdjust;
	}

	public void setSC1ActionExisManualAdjust(String sC1ActionExisManualAdjust) {
		SC1ActionExisManualAdjust = sC1ActionExisManualAdjust;
	}

	public String getSC1BillingMode() {
		return SC1BillingMode;
	}

	public void setSC1BillingMode(String sC1BillingMode) {
		SC1BillingMode = sC1BillingMode;
	}

	public String getSC1FirstBillDay() {
		return SC1FirstBillDay;
	}

	public void setSC1FirstBillDay(String sC1FirstBillDay) {
		SC1FirstBillDay = sC1FirstBillDay;
	}

	public String getSC1SecondBillDay() {
		return SC1SecondBillDay;
	}

	public void setSC1SecondBillDay(String sC1SecondBillDay) {
		SC1SecondBillDay = sC1SecondBillDay;
	}

	public String getSC1RateGuaranteeFrom() {
		return SC1RateGuaranteeFrom;
	}

	public void setSC1RateGuaranteeFrom(String sC1RateGuaranteeFrom) {
		SC1RateGuaranteeFrom = sC1RateGuaranteeFrom;
	}

	public String getSC1RateGuaranteeThru() {
		return SC1RateGuaranteeThru;
	}

	public void setSC1RateGuaranteeThru(String sC1RateGuaranteeThru) {
		SC1RateGuaranteeThru = sC1RateGuaranteeThru;
	}

	public String getSC1LastBillDate() {
		return SC1LastBillDate;
	}

	public void setSC1LastBillDate(String sC1LastBillDate) {
		SC1LastBillDate = sC1LastBillDate;
	}

	public String getSC1NextBillDate() {
		return SC1NextBillDate;
	}

	public void setSC1NextBillDate(String sC1NextBillDate) {
		SC1NextBillDate = sC1NextBillDate;
	}

	public String getSC1SellingBroker() {
		return SC1SellingBroker;
	}

	public void setSC1SellingBroker(String sC1SellingBroker) {
		SC1SellingBroker = sC1SellingBroker;
	}

	public String getSC1ExpectedBillingFromDate() {
		return SC1ExpectedBillingFromDate;
	}

	public void setSC1ExpectedBillingFromDate(String sC1ExpectedBillingFromDate) {
		SC1ExpectedBillingFromDate = sC1ExpectedBillingFromDate;
	}

	public String getSC1ExpectedBillingThruDate() {
		return SC1ExpectedBillingThruDate;
	}

	public void setSC1ExpectedBillingThruDate(String sC1ExpectedBillingThruDate) {
		SC1ExpectedBillingThruDate = sC1ExpectedBillingThruDate;
	}

	public String getMConnectorID() {
		return MConnectorID;
	}

	public void setMConnectorID(String mConnectorID) {
		MConnectorID = mConnectorID;
	}

	public String getMProviderType() {
		return MProviderType;
	}

	public void setMProviderType(String mProviderType) {
		MProviderType = mProviderType;
	}

	public String getDConnectorID() {
		return DConnectorID;
	}

	public void setDConnectorID(String dConnectorID) {
		DConnectorID = dConnectorID;
	}

	public String getDProviderType() {
		return DProviderType;
	}

	public void setDProviderType(String dProviderType) {
		DProviderType = dProviderType;
	}

	public String getVConnectorID() {
		return VConnectorID;
	}

	public void setVConnectorID(String vConnectorID) {
		VConnectorID = vConnectorID;
	}

	public String getVProviderType() {
		return VProviderType;
	}

	public void setVProviderType(String vProviderType) {
		VProviderType = vProviderType;
	}

	public String getPConnectorID() {
		return PConnectorID;
	}

	public void setPConnectorID(String pConnectorID) {
		PConnectorID = pConnectorID;
	}

	public String getPProviderType() {
		return PProviderType;
	}

	public void setPProviderType(String pProviderType) {
		PProviderType = pProviderType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EmployeeCertificateNumber == null) ? 0 : EmployeeCertificateNumber.hashCode());
		result = prime * result + ((EmployeeSSN == null) ? 0 : EmployeeSSN.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRecord other = (EmployeeRecord) obj;
		if (EmployeeCertificateNumber == null) {
			if (other.EmployeeCertificateNumber != null)
				return false;
		} else if (!EmployeeCertificateNumber.equals(other.EmployeeCertificateNumber))
			return false;
		if (EmployeeSSN == null) {
			if (other.EmployeeSSN != null)
				return false;
		} else if (!EmployeeSSN.equals(other.EmployeeSSN))
			return false;
		return true;
	}

	

}
