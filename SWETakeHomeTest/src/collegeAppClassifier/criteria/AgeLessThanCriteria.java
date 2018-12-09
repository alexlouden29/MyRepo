package collegeAppClassifier.criteria;
import java.util.List;

import collegeAppClassifier.Applicant;

public class AgeLessThanCriteria implements IAppCriteria {

private int ageMax;
	
	public AgeLessThanCriteria(int ageMax) {
		this.ageMax = ageMax;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		// TODO Auto-generated method stub
		return null;
	}

}
