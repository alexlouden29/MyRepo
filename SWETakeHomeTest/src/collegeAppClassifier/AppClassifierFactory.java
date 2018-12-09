package collegeAppClassifier;

import collegeAppClassifier.classifier.*;

public class AppClassifierFactory {
	private static AppClassifierFactory factory;
	
	private AppClassifierFactory() {}
	
	public static AppClassifierFactory getInstance() {
		if(factory == null) {
			factory = new AppClassifierFactory();
		}
		return factory;
	}
	
	public IAppClassifier getApplicantClassifier(String schoolName){
		if(schoolName.equals("My School")) {
			return new CAUCAppClassifier();
		}
		throw new IllegalArgumentException();
	}
}
