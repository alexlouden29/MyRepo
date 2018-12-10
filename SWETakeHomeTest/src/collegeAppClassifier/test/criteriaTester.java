package collegeAppClassifier.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import collegeAppClassifier.Applicant;
import collegeAppClassifier.Applicant.Status;
import collegeAppClassifier.criteria.*;

/**
 * Tester for criteria only
 * @author alouden
 *
 */
class criteriaTester {

	//Test CAUC criteria
	//TODO: Move to separate file if college-specific criteria grow too numerous
	@Test
	void testCAUCNameFormat() {
		Applicant legalName = new Applicant("George", "Foreman", 17);
		Applicant illegalFirstName = new Applicant("gEORGE", "Forman", 17);
		Applicant illegalLastName = new Applicant("George", "foRman", 17);
		Applicant numericName = new Applicant("3eorge", "Foreman", 17);
		Applicant specialCharName = new Applicant("George*", "Foreman", 17);
		List<Applicant> apps = Arrays.asList(legalName, illegalFirstName, illegalLastName, numericName);
		List<Applicant> result = new CAUCCriteriaNameFormat().meets(apps);
		
		assertTrue(result.contains(legalName), "Legal name was filtered out");
		assertFalse(result.contains(illegalFirstName), "Illegal first name was not filtered");
		assertFalse(result.contains(illegalLastName), "Illegal last name was not filtered");
		assertFalse(result.contains(numericName), "Name with a numeric character was not filtered");
		assertFalse(result.contains(specialCharName), "Name with a special character was not filtered");
	}
	
	//Test Generic Criteria
	@Test
	void testACTGreaterThan() {
		Applicant lowACT = new Applicant();
		lowACT.setScoreACT(27);
		Applicant highACT = new Applicant();
		highACT.setScoreACT(28);
		
		List<Applicant> apps = Arrays.asList(lowACT, highACT);
		List<Applicant> result = new CriteriaACTGreaterThan(27).meets(apps);
		
		assertTrue(result.contains(highACT), "Valid ACT was filtered out");
		assertFalse(result.contains(lowACT), "Invalid ACT was not filtered");
	}
	
	@Test
	void testAgeGreaterThan() {
		Applicant lowAge = new Applicant("George", "Foreman", 16);
		Applicant highAge = new Applicant("George", "Foreman", 17);
		
		List<Applicant> apps = Arrays.asList(lowAge, highAge);
		List<Applicant> result = new CriteriaAgeGreaterThan(16).meets(apps);
		
		assertTrue(result.contains(highAge), "Valid age was filtered out");
		assertFalse(result.contains(lowAge), "Invalid age was not filtered out");
	}
	
	@Test
	void testAgeLessThan() {
		Applicant lowAge = new Applicant("George", "Foreman", 16);
		Applicant highAge = new Applicant("George", "Foreman", 17);
		
		List<Applicant> apps = Arrays.asList(lowAge, highAge);
		List<Applicant> result = new CriteriaAgeLessThan(17).meets(apps);
		
		assertTrue(result.contains(lowAge), "Valid age was filtered out");
		assertFalse(result.contains(highAge), "Invalid age was not filtered out");
	}
	
	@Test
	void testFeloniesGreaterThan() {
		Applicant lowFelonies = new Applicant();
		lowFelonies.setNumFelonies(0);
		Applicant highFelonies = new Applicant();
		highFelonies.setNumFelonies(1);
		
		List<Applicant> apps = Arrays.asList(lowFelonies, highFelonies); 
		List<Applicant> result = new CriteriaFeloniesGreaterThan(0).meets(apps);
		
		assertTrue(result.contains(highFelonies), "Valid felonies was filtered out");
		assertFalse(result.contains(lowFelonies), "Invalid felonies was not filtered out");
	}
	
	@Test
	void testGPAScaleGreaterEqual() {
		Applicant lowGPA = new Applicant();
		lowGPA.setApplicantGPA(3.5);
		lowGPA.setScaleGPA(4.0);
		Applicant highGPA = new Applicant();
		highGPA.setApplicantGPA(3.6);
		highGPA.setScaleGPA(4.0);
		
		List<Applicant> apps = Arrays.asList(lowGPA, highGPA);
		List<Applicant> result = new CriteriaGPAScaleGreaterEqual(.9).meets(apps);
		
		assertTrue(result.contains(highGPA), "Valid GPA was filtered out");
		assertFalse(result.contains(lowGPA), "Invalid GPA was not filtered out");
	}
	
	@Test
	void testGPAScaleLessThan() {
		Applicant lowGPA = new Applicant();
		lowGPA.setApplicantGPA(3.6);
		lowGPA.setScaleGPA(5.0);
		Applicant highGPA = new Applicant();
		highGPA.setApplicantGPA(3.6);
		highGPA.setScaleGPA(4.0);
		
		List<Applicant> apps = Arrays.asList(lowGPA, highGPA);
		List<Applicant> result = new CriteriaGPAScaleLessThan(.9).meets(apps);
		
		assertTrue(result.contains(lowGPA), "Valid GPA was filtered out");
		assertFalse(result.contains(highGPA), "Invalid GPA was not filtered out");
	}
	
	@Test
	void testNotRejected() {
		Applicant rejected = new Applicant();
		rejected.setStatus(Status.REJECT);
		Applicant accepted = new Applicant();
		accepted.setStatus(Status.ACCEPT);
		Applicant nullApp = new Applicant();
		nullApp.setStatus(Status.NULL);
		Applicant review = new Applicant();
		review.setStatus(Status.REVIEW);
		
		List<Applicant> apps = Arrays.asList(rejected, accepted, nullApp, review);
		List<Applicant> result = new CriteriaNotRejected().meets(apps);
		
		assertTrue(result.contains(accepted), "Accepted app was filtered out");
		assertTrue(result.contains(nullApp), "Null app was filtered out");
		assertTrue(result.contains(review), "Review app was filtered out");
		assertFalse(result.contains(rejected), "Rejected app was not filtered out");
	}
	
	@Test
	void testSATGreaterThan() {
		Applicant lowSAT = new Applicant();
		lowSAT.setScoreSAT(1900);
		Applicant highSAT = new Applicant();
		highSAT.setScoreSAT(1901);
		
		List<Applicant> apps = Arrays.asList(lowSAT, highSAT);
		List<Applicant> result = new CriteriaSATGreaterThan(1900).meets(apps);
		
		assertTrue(result.contains(highSAT), "Valid SAT was filtered out");
		assertFalse(result.contains(lowSAT), "Invalid SAT was not filtered");
	}
	
	@Test
	void testState() {
		Applicant caState = new Applicant();
		caState.setStateCd("CA");
		Applicant txState = new Applicant();
		txState.setStateCd("TX");
		
		List<Applicant> apps = Arrays.asList(caState, txState);
		List<Applicant> result = new CriteriaState("CA").meets(apps);
		
		assertTrue(result.contains(caState), "Valid state was filtered out");
		assertFalse(result.contains(txState), "Invalid state was not filtered");
	}

}
