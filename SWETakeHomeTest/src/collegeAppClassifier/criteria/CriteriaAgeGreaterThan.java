package collegeAppClassifier.criteria;
import java.util.List;

import collegeAppClassifier.Applicant;

public class CriteriaAgeGreaterThan implements IAppCriteria {

	private int ageMin;
	
	public CriteriaAgeGreaterThan(int ageMin) {
		this.ageMin = ageMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		// TODO Auto-generated method stub
		return null;
	}

}
