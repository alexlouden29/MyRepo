package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

public class CACUCriteriaNameFormat implements IAppCriteria {

	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> legalFullName(app)).collect(toList());
	}

	private boolean legalFullName(Applicant app) {
		return legalNameFormat(app.getFirstName()) && legalNameFormat(app.getLastName());
	}
	
	//Checks if name has first letter upper case, rest lower case.
	private boolean legalNameFormat(String name) {
		String first = name.substring(0, 1);
		String second = name.substring(1);
		if(first.equals(first.toUpperCase()) && second.equals(second.toLowerCase())) {
			return true;
		}
		return false;
	}
}
