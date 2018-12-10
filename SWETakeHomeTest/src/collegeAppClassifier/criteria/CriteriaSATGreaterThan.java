package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

/**
 * @author alouden
 *
 */
public class CriteriaSATGreaterThan implements IAppCriteria {

	//App SAT score must be greater than this to pass
	private final int scoreMin;
	
	//Constructor
	public CriteriaSATGreaterThan(int scoreMin) {
		this.scoreMin = scoreMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> satGreaterThan(app)).collect(toList());
	}
	
	private boolean satGreaterThan(Applicant app) {
		Integer appSAT = app.getScoreSAT();
		if(appSAT !=null) {
			return appSAT > scoreMin;
		}
		return false;
	}
	
}
