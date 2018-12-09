package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;


public class CriteriaSATGreaterThan implements IAppCriteria {

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
