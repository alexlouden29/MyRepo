package collegeAppClassifier.criteria;

import static java.util.stream.Collectors.toList;

import java.util.List;

import collegeAppClassifier.Applicant;

public class CriteriaAgeLessThan implements IAppCriteria {

	private final int ageMax;
	
	//Constructor
	public CriteriaAgeLessThan(int ageMax) {
		this.ageMax = ageMax;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> ageLessThan(app)).collect(toList());
	}
	
	//Age is required, no validation necessary
	private boolean ageLessThan(Applicant app) {
		return app.getAge() < ageMax;
	}

}
