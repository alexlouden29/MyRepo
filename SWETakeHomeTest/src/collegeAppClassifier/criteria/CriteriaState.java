package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

public class CriteriaState implements IAppCriteria {

	private final String stateCd;
	
	//Constructor
	public CriteriaState(String stateCd) {
		this.stateCd = stateCd;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> inState(app)).collect(toList());
	}
	
	private boolean inState(Applicant app) {
		String appStateCd = app.getStateCd();
		if(appStateCd != null) {
			return appStateCd.equals(this.stateCd);
		}
		return false;
	}

}
