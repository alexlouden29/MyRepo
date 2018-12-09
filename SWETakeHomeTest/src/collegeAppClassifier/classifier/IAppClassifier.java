package collegeAppClassifier.classifier;

import java.util.List;

import collegeAppClassifier.Applicant;

public interface IAppClassifier {
	void classify(List<Applicant> apps);
}
