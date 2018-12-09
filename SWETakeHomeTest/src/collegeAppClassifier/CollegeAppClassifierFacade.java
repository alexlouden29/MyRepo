package collegeAppClassifier;

import java.util.List;

import collegeAppClassifier.classifier.IAppClassifier;

//Review if this should be a facade, standard facade design
public class CollegeAppClassifierFacade {
	private List<Applicant> applicants;
	private String schoolName;
	
	public CollegeAppClassifierFacade(List<Applicant> applicants, String schoolName) {
		this.applicants = applicants;
		this.schoolName = schoolName;
	}
	
	public void classify() {
		AppClassifierFactory classifierFactory = AppClassifierFactory.getInstance();
		IAppClassifier classifier = classifierFactory.getApplicantClassifier(schoolName);
		classifier.classify(applicants);
	}
	
	public List<Applicant> getApplicants(){
		return applicants;
	}
	
	public void setApplicants(List<Applicant> applicants) {
		this.applicants = applicants;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	
	//No setter for school name, should create new runner
}
