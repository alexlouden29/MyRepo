package collegeAppClassifier.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import collegeAppClassifier.Applicant;
import collegeAppClassifier.Applicant.Status;
import collegeAppClassifier.CollegeAppClassifierFacade;

/**
 * Tester for the CAUC Classifier
 * @author alouden
 *
 */
class CAUCClassifierTester {

	private CollegeAppClassifierFacade classifierFacade = new CollegeAppClassifierFacade();
	private String SCHOOL = "California University College";

	@Test
	void testInstantAccept() {
		Applicant youngSAT = new Applicant("John", "Doe", 17, 1921, null, 3.6, 4.0, "CA", 0);
		Applicant oldACT = new Applicant("John", "Doe", 81, null, 28, 3.6, 4.0, "TX", 0);
		
		List<Applicant> apps = Arrays.asList(youngSAT, oldACT);
		classifierFacade.classify(apps, SCHOOL);

		assertTrue(youngSAT.getStatus().equals(Status.ACCEPT), "Valid applicant was not accepted");
		assertTrue(oldACT.getStatus().equals(Status.ACCEPT), "Valid applicant was not accepted");
	}
	
	//These should technically be split into separate tests, but in the interest of time and readability, are combined
	@Test
	void testJustMissedAccept() {
		Applicant zero = new Applicant("John", "Doe", 16, 1921, null, 3.6, 4.0, "CA", 0); //Too Young
		Applicant one = new Applicant("John", "Doe", 26, 1921, null, 3.6, 4.0, "CA", 0); //Too Old
		Applicant two = new Applicant("John", "Doe", 17, 1921, null, 3.6, 4.0, "TX", 0); //Wrong State
		Applicant three = new Applicant("John", "Doe", 17, 1921, null, 3.5, 4.0, "CA", 0); //Low GPA
		Applicant four = new Applicant("John", "Doe", 17, 1920, null, 3.6, 4.0, "CA", 0); //Low SAT
		Applicant five = new Applicant("John", "Doe", 17, null, 27, 3.6, 4.0, "CA", 0); //Low ACT

		List<Applicant> apps = Arrays.asList(zero, one, two, three, four, five);
		classifierFacade.classify(apps, SCHOOL);
		
		for(Applicant app : apps) {
			assertTrue(app.getStatus().equals(Status.REVIEW), "Reviewable app was instant accepted");
		}
		
	}
	
	@Test
	void testRejectBlocksAccept() {
		Applicant app = new Applicant("John", "Doe", 17, 1921, null, 3.6, 4.0, "CA", 0);
		app.setStatus(Status.REJECT);
		
		List<Applicant> apps = Arrays.asList(app);
		classifierFacade.classify(apps, SCHOOL);
		
		assertTrue(app.getStatus().equals(Status.REJECT), "Already rejected application was accepted");
	}
	
	@Test
	void testPendingReview() {
		Applicant youngTexan = new Applicant("John", "Doe", 17, 1921, null, 3.6, 4.0, "TX", 0);
		
		List<Applicant> apps = Arrays.asList(youngTexan);
		classifierFacade.classify(apps, SCHOOL);
		
		assertTrue(youngTexan.getStatus().equals(Status.REVIEW), "Reviewable app was accepted or rejected");
		
	}
	
	@Test
	void testRejectFelonies() {
		Applicant felon = new Applicant();
		felon.setNumFelonies(1);
		Applicant lawAbidingCitizen = new Applicant();
		lawAbidingCitizen.setNumFelonies(0);
		
		List<Applicant> apps = Arrays.asList(felon, lawAbidingCitizen);
		classifierFacade.classify(apps, SCHOOL);
		
		assertTrue(felon.getStatus().equals(Status.REJECT), "Felon was not rejected");
		assertFalse(lawAbidingCitizen.getStatus().equals(Status.REJECT), "Law Abiding Citizen was rejected");
	}
	
	@Test
	void testRejectGPA() {
		Applicant cStudent = new Applicant();
		cStudent.setApplicantGPA(2.7);
		cStudent.setScaleGPA(4.0);
		Applicant bStudent = new Applicant();
		bStudent.setApplicantGPA(2.8);
		bStudent.setScaleGPA(4.0);
		
		List<Applicant> apps = Arrays.asList(cStudent, bStudent);
		classifierFacade.classify(apps, SCHOOL);
		
		assertTrue(cStudent.getStatus().equals(Status.REJECT), "Bad GPA was not rejected");
		assertFalse(bStudent.getStatus().equals(Status.REJECT), "Good GPA was rejected");
	}
	
	@Test
	void testRejectAge() {
		Applicant lyingStudent = new Applicant("Liarliar", "Pantsonfire", -1);
		Applicant newborn = new Applicant("Supersmart", "Baby", 0);
		
		List<Applicant> apps = Arrays.asList(lyingStudent, newborn);
		classifierFacade.classify(apps, SCHOOL);
		
		assertTrue(lyingStudent.getStatus().equals(Status.REJECT), "Negative Age was not rejected");
		assertFalse(newborn.getStatus().equals(Status.REJECT), "Non-Negative was rejected");
	}
	
	@Test
	void testNameFormat() {
		Applicant normalName = new Applicant("George", "McMarks", 17);
		Applicant moreNormalName = new Applicant("Azxasdfn", "Eqewrqwer", 17);
		
		List<Applicant> apps = Arrays.asList(normalName, moreNormalName);
		classifierFacade.classify(apps, SCHOOL);
		
		assertTrue(normalName.getStatus().equals(Status.REJECT), "Badly formatted name was not rejected");
		assertFalse(moreNormalName.getStatus().equals(Status.REJECT), "Correctly formatted name was rejected");
	}

}
