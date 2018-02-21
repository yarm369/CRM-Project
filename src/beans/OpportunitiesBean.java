package beans;

public class OpportunitiesBean extends CRMBean {

	private String firstName;
	private String lastName;
	private String startDate;
	private long client;
	private String descriptionInfo;
	private String amountOfDollars;
	private String predictedClosingDate;
	private String status;
	
	public OpportunitiesBean(long id) {
		super(id);
		firstName = "";
		lastName = "";
		startDate = "";
		client = -1;
		descriptionInfo = "";
		amountOfDollars = "";
		predictedClosingDate = "";
		status = "";
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public long getClient() {
		return client;
	}
	public void setClient(long id) {
		this.client = id;
	}
	
	public String getDescriptionInfo() {
		return descriptionInfo;
	}
	
	public void setDescriptionInfo(String descriptionInfo) {
		this.descriptionInfo = descriptionInfo;
	}
	
	public String getAmountOfDollars() {
		return amountOfDollars;
	}
	
	public void setAmountOfDollars(String amountOfDollars) {
		this.amountOfDollars = amountOfDollars;
	}
	
	public String getPredictedClosingDate() {
		return predictedClosingDate;
	}
	
	public void setPredictedClosingDate(String predictedClosingDate) {
		this.predictedClosingDate = predictedClosingDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDescription() {
		return firstName + " " + lastName;
	}
	
	public String toString() {
		return this.getId() + ": " + this.getFirstName() + " " + this.getLastName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof OpportunitiesBean) {
			OpportunitiesBean c = (OpportunitiesBean) o;
			return (c.getId() == this.getId());
		}
		return false;
	}
	
}
