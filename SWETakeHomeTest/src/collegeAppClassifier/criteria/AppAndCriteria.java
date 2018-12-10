package collegeAppClassifier.criteria;
import java.util.List;

import collegeAppClassifier.Applicant;

/**
 *  Allows combination of criteria.  If app meets all criteria input, it will pass
 * @author alouden
 *
 */
public class AppAndCriteria implements IAppCriteria {

	private final IAppCriteria[] criterias;
	
	//Constructor
	public AppAndCriteria(IAppCriteria... criterias) {
		this.criterias = criterias;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		List<Applicant> filteredApps = apps;
		
		//Filter list until only those meeting all conditions are left
		for(IAppCriteria criteria : criterias) {
			filteredApps = criteria.meets(filteredApps);
		}
		
		return filteredApps;
	}

}
