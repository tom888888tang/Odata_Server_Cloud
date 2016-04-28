package myservice.table.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Infotype_ID.class)
public class Employment_Info {
	@Id
	private String employee_id;
	@Id
	private Date end_date;
	@Basic
	private Date start_date;
	@Basic
	private String company;
	@Basic
	private String business_unit;
	@Basic
	private String position_category;
	@Basic
	private String position;
	@Basic
	private String employee_group;
	@Basic
	private String grade;
	@Basic
	private String line_manager;
	@Basic
	private String hr_manager;

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBusiness_unit() {
		return business_unit;
	}

	public void setBusiness_unit(String business_unit) {
		this.business_unit = business_unit;
	}

	public String getPosition_category() {
		return position_category;
	}

	public void setPosition_category(String position_category) {
		this.position_category = position_category;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmployee_group() {
		return employee_group;
	}

	public void setEmployee_group(String employee_group) {
		this.employee_group = employee_group;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getLine_manager() {
		return line_manager;
	}

	public void setLine_manager(String line_manager) {
		this.line_manager = line_manager;
	}

	public String getHr_manager() {
		return hr_manager;
	}

	public void setHr_manager(String hr_manager) {
		this.hr_manager = hr_manager;
	}

}
