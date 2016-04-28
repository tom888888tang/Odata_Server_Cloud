package myservice.table.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Infotype_ID.class)
public class Cont_Info {
	@Id
	private String employee_id;
	@Id
	private Date end_date;
	@Basic
	private Date start_date;
	@Basic
	private String country;
	@Basic
	private String document_type;
	@Basic
	private String document_title;
	@Basic
	private String document_number;
	@Basic
	private String publish_date;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getDocument_title() {
		return document_title;
	}

	public void setDocument_title(String document_title) {
		this.document_title = document_title;
	}

	public String getDocument_number() {
		return document_number;
	}

	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getPublish_place() {
		return publish_place;
	}

	public void setPublish_place(String publish_place) {
		this.publish_place = publish_place;
	}

	public String getPublish_authority() {
		return publish_authority;
	}

	public void setPublish_authority(String publish_authority) {
		this.publish_authority = publish_authority;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Basic
	private String publish_place;
	@Basic
	private String publish_authority;
	@Basic
	private String expire_date;
	@Basic
	private String attachment;

}
