package collegeAppClassifier.criteria;

import java.util.List;
import static java.util.stream.Collectors.toList;

import collegeAppClassifier.Applicant;

/**
 * Checks if applicants name matches format required by CAUC
 * @author alouden
 *
 */
public class CAUCCriteriaNameFormat implements IAppCriteria {

	//Default Constructor
	public CAUCCriteriaNameFormat() {
		//Do Nothing
	}
	
	@Override
	public List<Applicant> meets(List<Applicant> apps) {
		return apps.stream().filter(app -> legalFullName(app)).collect(toList());
	}

	//First and Last name are required, no validation necessary
	private boolean legalFullName(Applicant app) {
		return legalNameFormat(app.getFirstName()) && legalNameFormat(app.getLastName());
	}
	
	//Check name format
	private boolean legalNameFormat(String name) {
		
		//Check for blank string
		if(name.equals("")) {
			return false;
		}
		
		//Check for invalid characters
		char[] chars = name.toCharArray();
		for(char c : chars) {
			if(!Character.isLetter(c)) {
				return false;
			}
		}
		
		//Check for proper capitalization
		String first = name.substring(0, 1);
		String second = name.substring(1);
		if(!first.equals(first.toUpperCase()) || !second.equals(second.toLowerCase())) {
			return false;
		}
		
		return true;
	}
}
