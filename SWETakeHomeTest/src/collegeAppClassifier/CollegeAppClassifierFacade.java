package collegeAppClassifier;

import java.util.List;

import collegeAppClassifier.classifier.IAppClassifier;

/* Facade isn't completely necessary, but could be used to add on other tasks,
 * and slightly simplifies use for testing and client.
 */
public class CollegeAppClassifierFacade {
	
	//Constructor
	public CollegeAppClassifierFacade() {
		//Do Nothing
	}
	
	/**
	 * Classify all of the applicants given using the classifier for the given school
	 * @param apps
	 * @param schoolName
	 */
	public void classify(List<Applicant> apps, String schoolName) {
		AppClassifierFactory classifierFactory = AppClassifierFactory.getInstance();
		IAppClassifier classifier = classifierFactory.getApplicantClassifier(schoolName);
		classifier.classify(apps);
	}
}
