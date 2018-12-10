package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

/**
 * @author alouden
 *
 */
public class CriteriaGPAScaleGreaterEqual implements IAppCriteria {

	//App GPA scaled score must be higher than this to pass
	private final double scaleMin;
	
	//Constructor
	//Scale should be in the form of a decimal, .9 for 90%
	public CriteriaGPAScaleGreaterEqual(double scaleMin) {
		this.scaleMin = scaleMin;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> gpaScaleGreaterEqual(app)).collect(toList());
	}
	
	private boolean gpaScaleGreaterEqual(Applicant app) {
		Double appGPA = app.getApplicantGPA();
		Double scaleGPA = app.getScaleGPA();
		if(appGPA != null && scaleGPA != null) {
			//Determine scaled GPA
			double appScale = appGPA/scaleGPA;
			return appScale >= scaleMin;
		}
		return false;
	}

}
