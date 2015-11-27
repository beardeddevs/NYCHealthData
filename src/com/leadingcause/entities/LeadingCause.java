package com.leadingcause.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import com.leadingcause.enums.Sex;

@Entity
public class LeadingCause {
	
	@Id
	@TableGenerator(name="COMP",
	table="LEADINGCAUSE_IDGEN",
    pkColumnName="GEN_NAME",
    valueColumnName="GEN_VAL",
    pkColumnValue="LeadingCause_Gen")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="COMP")
	@Column(name="stream_id",columnDefinition="NUMBER(10,0)")
	private int causeId;
	@Column(columnDefinition="Number (5,0)")
	private int year;
	@Column()
	private String ethnicity;
	@Column()
	private Sex sex;
	@Column()
	private String causeOfDeath;
	@Column()
	private int count;
	
	@Column(columnDefinition="Number (4,2)")
	private double percentage;
	
	
	public LeadingCause(int year, String ethnicity, Sex sex,
			String causeOfDeath, int count, double percentage) {
		super();
		this.year = year;
		this.ethnicity = ethnicity;
		this.sex = sex;
		this.causeOfDeath = causeOfDeath;
		this.count = count;
		this.percentage = percentage;
	}
	
	public LeadingCause(){
		
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((causeOfDeath == null) ? 0 : causeOfDeath.hashCode());
		result = prime * result + count;
		result = prime * result
				+ ((ethnicity == null) ? 0 : ethnicity.hashCode());
		long temp;
		temp = Double.doubleToLongBits(percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeadingCause other = (LeadingCause) obj;
		if (causeOfDeath == null) {
			if (other.causeOfDeath != null)
				return false;
		} else if (!causeOfDeath.equals(other.causeOfDeath))
			return false;
		if (count != other.count)
			return false;
		if (ethnicity == null) {
			if (other.ethnicity != null)
				return false;
		} else if (!ethnicity.equals(other.ethnicity))
			return false;
		if (Double.doubleToLongBits(percentage) != Double
				.doubleToLongBits(other.percentage))
			return false;
		if (sex != other.sex)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	

}
