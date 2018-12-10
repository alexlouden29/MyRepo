package collegeAppClassifier.classifier;

import java.util.List;

import collegeAppClassifier.Applicant;
import collegeAppClassifier.Applicant.Status;
import collegeAppClassifier.criteria.*;

/**
 * Classifier for California University College
 * @author alouden
 *
 */
public class CAUCAppClassifier implements IAppClassifier {

	private final String FELONY_REASON = "Number of felonies is 1 or higher.";
	private final String GPA_REASON = "High school GPA is below 70% of provided scale.";
	private final String NEGATIVE_AGE_REASON = "Age is reported as negative.";
	private final String NAME_FORMAT_REASON = "Name is not in the format of first letter capitalized, remaining lowercase.";
	
	@Override
	public void classify(List<Applicant> apps) {

		//Reject apps with reasons.  Reject first so instant accept logic knows if reject was hit
		setRejected(new CriteriaFeloniesGreaterThan(0).meets(apps), FELONY_REASON);
		setRejected(new CriteriaGPAScaleLessThan(.7).meets(apps), GPA_REASON);
		setRejected(new CriteriaAgeLessThan(0).meets(apps), NEGATIVE_AGE_REASON);
		setRejected(new AppNotCriteria(new CAUCCriteriaNameFormat()).meets(apps), NAME_FORMAT_REASON);	
		
		//Build Accept Criteria
		AppAndCriteria inStateAgeCriteria = new AppAndCriteria(new CriteriaState("CA"),
															   new CriteriaAgeGreaterThan(16),
															   new CriteriaAgeLessThan(26));
		
		AppOrCriteria inStateOrOldCriteria = new AppOrCriteria(new CriteriaAgeGreaterThan(80),
														inStateAgeCriteria);
		
		AppOrCriteria testScoreCriteria = new AppOrCriteria(new CriteriaSATGreaterThan(1920),
															new CriteriaACTGreaterThan(27));
		
		AppAndCriteria acceptCriteria = new AppAndCriteria(new CriteriaGPAScaleGreaterEqual(.9),
														   new CriteriaNotRejected(),
														   inStateOrOldCriteria,
														   testScoreCriteria);
		//Instant Accept Applicants
		setAccepted(acceptCriteria.meets(apps));
		
		//Set remaining apps to further review
		setReview(apps);
	}
	
	//Helper method sets apps rejected with a reason
	private void setRejected(List<Applicant> apps, String reason) {
		for(Applicant app : apps) {
			app.setStatus(Status.REJECT);
			if(reason != null && !reason.equals("")) {
				app.addReason("Rejected: " + reason);
			}
		}
	}
	
	//Helper method sets apps accepted
	private void setAccepted(List<Applicant> apps) {
		for(Applicant app : apps) {
			app.setStatus(Status.ACCEPT);
		}
	}
	
	//Helper method sets apps to review if they do not have a status
	private void setReview(List<Applicant> apps) {
		for(Applicant app : apps) {
			if(app.getStatus().equals(Status.NULL)) {
				app.setStatus(Status.REVIEW);
			}
		}
	}

}
