package beans;

import java.util.Date;

public class Employee {
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", doj=");
		builder.append(doj);
		builder.append("]");
		return builder.toString();
	}
	private int id;
	private String name;
	private Date dob;
	private Date doj;
	
	public int getId() {
		return id;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, Date dob, Date doj) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	

}
