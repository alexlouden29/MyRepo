package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

/**
 * @author alouden
 *
 */
public class CriteriaACTGreaterThan implements IAppCriteria {

	//App ACT score must be greater than this amount to pass
	private final int scoreMin;
	
	//Constructor
	public CriteriaACTGreaterThan(int scoreMin) {
		this.scoreMin = scoreMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> actGreaterThan(app)).collect(toList());
	}

	private boolean actGreaterThan(Applicant app) {
		Integer appACT = app.getScoreACT();
		if(appACT != null) {
			return appACT > scoreMin;
		}
		return false;
	}
}
