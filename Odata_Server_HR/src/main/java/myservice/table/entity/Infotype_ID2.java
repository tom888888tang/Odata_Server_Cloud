package myservice.table.entity;

import java.io.Serializable;
import java.util.Date;

public class Infotype_ID2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employee_id;
	private Date end_date;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + ((employee_id == null) ? 0 : employee_id.hashCode());
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
		Infotype_ID2 other = (Infotype_ID2) obj;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (employee_id == null) {
			if (other.employee_id != null)
				return false;
		} else if (!employee_id.equals(other.employee_id))
			return false;
		return true;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public Date getend_date() {
		return end_date;
	}
	public void setend_date(Date end_date) {
		this.end_date = end_date;
	}

}
