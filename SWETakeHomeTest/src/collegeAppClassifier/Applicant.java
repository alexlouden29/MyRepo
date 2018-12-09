package collegeAppClassifier;

/**
 * Represents a student application snapshot, used for classification
 * @author alouden
 *
 */
public class Applicant {

	//Scores
	private Integer scoreSAT = null; //pre-2016 SAT only per requirements
	private Integer scoreACT = null;
	private Double applicantGPA = null;
	private Double scaleGPA = null;
	
	//Personal Details
	private Integer age;
	private String lastName;
	private String firstName;
	private String stateCd = null;
	
	//If more detailed crime reporting becomes necessary, change this to a crime object and track details
	private Integer numFelonies = null;
	
	private Status status = Status.NULL;
	
	//Lock status types and descriptions
	public enum Status {
		ACCEPT ("Instant Accept"),
		REJECT ("Instant Reject"),
		REVIEW ("Further Review"),
		NULL ("null");
		
		private final String displayStr;
		
		Status(String displayStr){
			this.displayStr = displayStr;
		}
	}
	
	/**
	 * Full CTOR.  
	 * Required Fields: firstName, lastName, age
	 * Optional Fields not needed can be set to Null
	 * @param scoreSAT
	 * @param scoreACT
	 * @param applicantGPA
	 * @param scaleGPA
	 * @param age
	 * @param lastName
	 * @param firstName
	 * @param stateCd
	 * @param numFelonies
	 */
	public Applicant(String lastName, String firstName, Integer age, Integer scoreSAT, Integer scoreACT, Double applicantGPA, Double scaleGPA, String stateCd, Integer numFelonies) {
		
		//Validate inputs
		//TODO: Ask division if these should be criteria, or allowed
		if(firstName == null || lastName == null || age == null) {
			throw new IllegalArgumentException("Mising required parameters");
		}
		if(scoreSAT != null) {
			if(scoreSAT < 600 || scoreSAT > 2400) {
				throw new IllegalArgumentException("Invalid SAT score");
			}
		}
		if(scoreACT != null) {
			if(scoreACT < 1 || scoreACT > 36) {
				throw new IllegalArgumentException("Invalid ACT score");
			}
		}
		
		//Set fields
		this.age = age;
		this.lastName = lastName;
		this.firstName = firstName;
		this.scoreSAT = scoreSAT;
		this.scoreACT = scoreACT;
		this.applicantGPA = applicantGPA;
		this.scaleGPA = scaleGPA;
		
		this.stateCd = stateCd;
		this.numFelonies = numFelonies;
	}
	
	/**
	 * Minimum required info CTOR
	 */
	public Applicant(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	/**
	 * Default CTOR, use not recommended outside testing.
	 */
	public Applicant() {
		this.firstName = "John";
		this.lastName = "Doe";
		this.age = 17;
	}

	/************ Getters/Setters ************/
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public String getStatusDisplay() {
		return status.displayStr;
	}

	/**
	 * @return the scoreSAT
	 */
	public Integer getScoreSAT() {
		return scoreSAT;
	}

	/**
	 * @param scoreSAT the scoreSAT to set
	 */
	public void setScoreSAT(Integer scoreSAT) {
		if(scoreSAT < 600 || scoreSAT > 2400) {
			throw new IllegalArgumentException("Invalid SAT score");
		}
		this.scoreSAT = scoreSAT;
	}

	/**
	 * @return the scoreACT
	 */
	public Integer getScoreACT() {
		return scoreACT;
	}

	/**
	 * @param scoreACT the scoreACT to set
	 */
	public void setScoreACT(Integer scoreACT) {
		if(scoreACT < 1 || scoreACT > 36) {
			throw new IllegalArgumentException("Invalid ACT score");
		}
		this.scoreACT = scoreACT;
	}

	/**
	 * @return the applicantGPA
	 */
	public Double getApplicantGPA() {
		return applicantGPA;
	}

	/**
	 * @param applicantGPA the applicantGPA to set
	 */
	public void setApplicantGPA(Double applicantGPA) {
		this.applicantGPA = applicantGPA;
	}

	/**
	 * @return the scaleGPA
	 */
	public Double getScaleGPA() {
		return scaleGPA;
	}

	/**
	 * @param scaleGPA the scaleGPA to set
	 */
	public void setScaleGPA(Double scaleGPA) {
		this.scaleGPA = scaleGPA;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		if(age == null) {
			throw new IllegalArgumentException("Age cannot be null");
		}
		this.age = age;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if(lastName == null) {
			throw new IllegalArgumentException("Last Name cannot be null");
		}
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if(firstName == null) {
			throw new IllegalArgumentException("First Name cannot be null");
		}
		this.firstName = firstName;
	}

	/**
	 * @return the stateCd
	 */
	public String getStateCd() {
		return stateCd;
	}

	/**
	 * @param stateCd the stateCd to set
	 */
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	/**
	 * @return the numFelonies
	 */
	public Integer getNumFelonies() {
		return numFelonies;
	}

	/**
	 * @param numFelonies the numFelonies to set
	 */
	public void setNumFelonies(Integer numFelonies) {
		this.numFelonies = numFelonies;
	}
}
