package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

public class CriteriaGPAScaleGreaterThan implements IAppCriteria {

	private final double scaleMin;
	
	//Constructor
	//Scale should be in the form of a decimal, .9 for 90%
	public CriteriaGPAScaleGreaterThan(double scaleMin) {
		this.scaleMin = scaleMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> gpaScaleGreaterThan(app)).collect(toList());
	}
	
	private boolean gpaScaleGreaterThan(Applicant app) {
		Double appGPA = app.getApplicantGPA();
		Double scaleGPA = app.getScaleGPA();
		if(appGPA != null && scaleGPA != null) {
			double appScale = appGPA/scaleGPA;
			return appScale > scaleMin;
		}
		return false;
	}

}
