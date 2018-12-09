package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

public class CriteriaFeloniesGreaterThan implements IAppCriteria {

	private final int felonyMin;
	
	//Constructor
	public CriteriaFeloniesGreaterThan(int felonyMin) {
		this.felonyMin = felonyMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> feloniesGreaterThan(app)).collect(toList());
	}
	
	private boolean feloniesGreaterThan(Applicant app) {
		Integer numFelonies = app.getNumFelonies();
		if(numFelonies != null) {
			return numFelonies > felonyMin;
		}
		return false;
	}

}
