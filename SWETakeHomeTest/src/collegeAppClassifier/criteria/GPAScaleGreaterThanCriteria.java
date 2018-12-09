package collegeAppClassifier.criteria;

import java.util.List;

import collegeAppClassifier.Applicant;

public class GPAScaleGreaterThanCriteria implements IAppCriteria {

	private double scaleMin;
	
	public GPAScaleGreaterThanCriteria(double scaleMin) {
		this.scaleMin = scaleMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		// TODO Auto-generated method stub
		return null;
	}

}
