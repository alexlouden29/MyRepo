package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

public class CriteriaAgeGreaterThan implements IAppCriteria {

	private final int ageMin;
	
	//Constructor
	public CriteriaAgeGreaterThan(int ageMin) {
		this.ageMin = ageMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> ageGreaterThan(app)).collect(toList());
	}
	
	//Age is required, no validation necessary
	private boolean ageGreaterThan(Applicant app) {
		return app.getAge() > ageMin;
	}

}
