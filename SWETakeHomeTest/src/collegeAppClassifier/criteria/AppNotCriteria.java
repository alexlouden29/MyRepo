package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

/**
 * Allows inverse of criteria, without creating a new criteria
 * @author alouden
 *
 */
public class AppNotCriteria implements IAppCriteria {

	private final IAppCriteria criteria;
	
	//Construtor
	public AppNotCriteria(IAppCriteria criteria) {
		this.criteria = criteria;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		List<Applicant> doesMeet = criteria.meets(apps);
		//Get apps that did not meet the criteria
		return apps.stream().filter(app -> !doesMeet.contains(app)).collect(toList());
	}

}
