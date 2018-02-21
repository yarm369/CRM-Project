package beans;

public class ContactBean extends CRMBean {

	private String firstName;
	private String lastName;
	private String company;
	private long client;
	private String telephone;
	private String email;
	private String facebook;
	
	public ContactBean(long id) {
		super(id);
		firstName = "";
		lastName = "";
		company = "";
		client = -1;
		telephone = "";
		email = "";
		facebook = "";
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
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	public long getClient() {
		return client;
	}
	public void setClient(long id) {
		this.client = id;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFacebook() {
		return facebook;
	}
	
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	public String getDescription() {
		return firstName + " " + lastName;
	}
	
	public String toString() {
		return this.getId() + ": " + this.getFirstName() + " " + this.getLastName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof ContactBean) {
			ContactBean c = (ContactBean) o;
			return (c.getId() == this.getId());
		}
		return false;
	}
	
}
