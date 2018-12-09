package collegeAppClassifier.criteria;

import java.util.List;

import collegeAppClassifier.Applicant;

public class AppNotCriteria implements IAppCriteria {

	private IAppCriteria[] criterias;
	
	public AppNotCriteria(IAppCriteria... criterias) {
		this.criterias = criterias;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		
		return null;
	}

}
