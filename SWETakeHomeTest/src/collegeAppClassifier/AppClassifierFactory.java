package collegeAppClassifier;

import collegeAppClassifier.classifier.*;

/**
 * Given a school name, this factory determines the correct classifier to return.
 * Could be altered to pick from multiple classifiers per school, etc.
 * @author alouden
 *
 */
public class AppClassifierFactory {
	
	private static AppClassifierFactory factory;
	
	private AppClassifierFactory() {}
	
	//Singleton Getter
	public static AppClassifierFactory getInstance() {
		if(factory == null) {
			factory = new AppClassifierFactory();
		}
		return factory;
	}
	
	public IAppClassifier getApplicantClassifier(String schoolName){
		if(schoolName.equals("California University College")) {
			return new CAUCAppClassifier();
		}
		throw new IllegalArgumentException("School Name not Recognized");
	}
}
