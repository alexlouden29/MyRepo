package collegeAppClassifier.criteria;


import java.util.List;

import collegeAppClassifier.Applicant;

public interface IAppCriteria {
	List<Applicant> meets(List<Applicant> apps);
}
