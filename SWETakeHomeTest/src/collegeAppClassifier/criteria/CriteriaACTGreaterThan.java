package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

public class CriteriaACTGreaterThan implements IAppCriteria {

	private final int scoreMin;
	
	public CriteriaACTGreaterThan(int scoreMin) {
		this.scoreMin = scoreMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> actGreaterThan(app)).collect(toList());
	}

	private boolean actGreaterThan(Applicant app) {
		return app.getScoreACT() > scoreMin;
	}
}
