package collegeAppClassifier.criteria;

import java.util.List;

import collegeAppClassifier.Applicant;

public class CriteriaFeloniesGreaterThan implements IAppCriteria {

	private int felonyMin;
	
	public CriteriaFeloniesGreaterThan(int felonyMin) {
		this.felonyMin = felonyMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		// TODO Auto-generated method stub
		return null;
	}

}
