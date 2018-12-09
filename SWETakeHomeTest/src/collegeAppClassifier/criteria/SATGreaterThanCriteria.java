package collegeAppClassifier.criteria;
import java.util.List;

import collegeAppClassifier.Applicant;

public class SATGreaterThanCriteria implements IAppCriteria {

	private int scoreMin;
	
	public SATGreaterThanCriteria(int scoreMin) {
		this.scoreMin = scoreMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		// TODO Auto-generated method stub
		return null;
	}

}
