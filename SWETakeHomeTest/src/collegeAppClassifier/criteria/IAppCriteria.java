package collegeAppClassifier.criteria;

import java.util.List;

import collegeAppClassifier.Applicant;

/**
 * Interface for criteria to be used classifiers.  Apps should fail criteria if insufficient
 * data is present.
 * @author alouden
 *
 */
public interface IAppCriteria {
	List<Applicant> meets(List<Applicant> apps);
}
