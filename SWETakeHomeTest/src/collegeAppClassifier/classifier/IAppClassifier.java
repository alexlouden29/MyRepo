package collegeAppClassifier.classifier;

import java.util.List;

import collegeAppClassifier.Applicant;

/**
 * Interface for classifiers.  Each college should have it's own classifier class implementing IAppClassifier
 * @author alouden
 *
 */
public interface IAppClassifier {
	void classify(List<Applicant> apps);
}
