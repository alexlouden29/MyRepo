package collegeAppClassifier.criteria;

import static java.util.stream.Collectors.toList;
import java.util.List;

import collegeAppClassifier.Applicant;

/**
 * @author alouden
 *
 */
public class CriteriaGPAScaleLessThan implements IAppCriteria {

	//App GPA scaled score must be lower than this to pass
	private final double scaleMax;
	
	//Constructor
	//Scale should be in the form of a decimal, .9 for 90%
	public CriteriaGPAScaleLessThan(double scaleMax) {
		this.scaleMax = scaleMax;
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> gpaScaleLessThan(app)).collect(toList());
	}
	
	private boolean gpaScaleLessThan(Applicant app) {
		Double appGPA = app.getApplicantGPA();
		Double scaleGPA = app.getScaleGPA();
		if(appGPA != null && scaleGPA != null) {
			//Determine scaled GPA
			double appScale = appGPA/scaleGPA;
			return appScale < scaleMax;
		}
		return false;
	}

}
