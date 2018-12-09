package collegeAppClassifier.criteria;
import java.util.List;

import collegeAppClassifier.Applicant;

public class AppAndCriteria implements IAppCriteria {

	private IAppCriteria[] criterias;
	
	public AppAndCriteria(IAppCriteria... criterias) {
		this.criterias = criterias;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		List<Applicant> filteredApps = apps;
		
		for(IAppCriteria criteria : criterias) {
			filteredApps = criteria.meets(filteredApps);
		}
		
		return filteredApps;
	}

}
