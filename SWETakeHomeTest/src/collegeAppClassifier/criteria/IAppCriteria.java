package collegeAppClassifier.criteria;


import java.util.List;

import collegeAppClassifier.Applicant;

public interface IAppCriteria {
	//Applications that are missing data required for comparison should be filtered out
	List<Applicant> meets(List<Applicant> apps);
}
