package collegeAppClassifier.criteria;
import java.util.List;

import collegeAppClassifier.Applicant;

public class CriteriaState implements IAppCriteria {

	private String state;
	
	public CriteriaState(String state) {
		this.state = state;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		// TODO Auto-generated method stub
		return null;
	}

}
