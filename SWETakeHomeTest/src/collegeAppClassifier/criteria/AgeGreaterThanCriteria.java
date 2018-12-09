package collegeAppClassifier.criteria;
import java.util.List;

import collegeAppClassifier.Applicant;

public class AgeGreaterThanCriteria implements IAppCriteria {

	private int ageMin;
	
	public AgeGreaterThanCriteria(int ageMin) {
		this.ageMin = ageMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		// TODO Auto-generated method stub
		return null;
	}

}
