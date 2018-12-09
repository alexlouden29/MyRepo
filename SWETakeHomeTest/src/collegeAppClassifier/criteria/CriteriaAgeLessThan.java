package collegeAppClassifier.criteria;
import java.util.List;

import collegeAppClassifier.Applicant;

public class CriteriaAgeLessThan implements IAppCriteria {

private int ageMax;
	
	public CriteriaAgeLessThan(int ageMax) {
		this.ageMax = ageMax;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		// TODO Auto-generated method stub
		return null;
	}

}
