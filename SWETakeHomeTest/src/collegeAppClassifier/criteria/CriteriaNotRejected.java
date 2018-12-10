package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;
import collegeAppClassifier.Applicant.Status;

/**
 * @author alouden
 *
 */
public class CriteriaNotRejected implements IAppCriteria {

	//Default Constructor
	public CriteriaNotRejected() {
		//Do Nothing
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> isNotRejected(app)).collect(toList());
	}
	
	private boolean isNotRejected(Applicant app) {
		return !app.getStatus().equals(Status.REJECT);
	}

}
