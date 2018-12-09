package collegeAppClassifier.criteria;

import java.util.List;

import collegeAppClassifier.Applicant;

public class ACTGreaterThanCriteria implements IAppCriteria {

	private int scoreMin;
	
	public ACTGreaterThanCriteria(int scoreMin) {
		this.scoreMin = scoreMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		// TODO Auto-generated method stub
		return null;
	}

}
