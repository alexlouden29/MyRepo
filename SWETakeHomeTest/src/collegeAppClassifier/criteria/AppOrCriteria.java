package collegeAppClassifier.criteria;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

/**
 * Allows combination of criteria.  If app meets any criteria input, it will pass
 * @author alouden
 *
 */
public class AppOrCriteria implements IAppCriteria {

	private final IAppCriteria[] criterias;
	
	//Constructor
	public AppOrCriteria(IAppCriteria... criterias) {
		this.criterias = criterias;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		
		List<Applicant> filteredApps = new ArrayList<>();
		
		for(IAppCriteria criteria : criterias) {
			//Add all distinct values that passed the filter
			filteredApps = Stream.concat(filteredApps.stream(), criteria.meets(apps).stream())
							.distinct().collect(toList());
		}
		
		return filteredApps;
	}

}
