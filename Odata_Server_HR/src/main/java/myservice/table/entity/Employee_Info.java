package myservice.table.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Infotype_ID.class)
public class Employee_Info {
@Id
private String employee_id;
@Id 
private Date end_date;
@Basic
private Date begin_date;
public Date getEnd_date() {
	return end_date;
}
public void setEnd_date(Date end_date) {
	this.end_date = end_date;
}
@Basic
private String last_name;
@Basic
private String first_name;
@Basic
private String gender;
@Basic
private String marital_status;
@Basic
private String marital_begin;
@Basic
private String nationality;
@Basic
private String language;
@Basic
private String residence_type;
@Basic
private String ethnic;
@Basic
private String id_type;
@Basic
private String id_number;
@Basic
private String email;
@Basic
private String phone;
@Basic
private String birthday;
@Basic
private String birth_place;
@Basic
private String birth_country;
@Basic
private String hire_date;
public String getEmployee_id() {
	return employee_id;
}
public void setEmployee_id(String employee_id) {
	this.employee_id = employee_id;
}
public Date getBegin_date() {
	return begin_date;
}
public void setBegin_date(Date begin_date) {
	this.begin_date = begin_date;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMarital_status() {
	return marital_status;
}
public void setMarital_status(String marital_status) {
	this.marital_status = marital_status;
}
public String getMarital_begin() {
	return marital_begin;
}
public void setMarital_begin(String marital_begin) {
	this.marital_begin = marital_begin;
}
public String getNationality() {
	return nationality;
}
public void setNationality(String nationality) {
	this.nationality = nationality;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getResidence_type() {
	return residence_type;
}
public void setResidence_type(String residence_type) {
	this.residence_type = residence_type;
}
public String getEthnic() {
	return ethnic;
}
public void setEthnic(String ethnic) {
	this.ethnic = ethnic;
}
public String getId_type() {
	return id_type;
}
public void setId_type(String id_type) {
	this.id_type = id_type;
}
public String getId_number() {
	return id_number;
}
public void setId_number(String id_number) {
	this.id_number = id_number;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getBirth_place() {
	return birth_place;
}
public void setBirth_place(String birth_place) {
	this.birth_place = birth_place;
}
public String getBirth_country() {
	return birth_country;
}
public void setBirth_country(String birth_country) {
	this.birth_country = birth_country;
}
public String getHire_date() {
	return hire_date;
}
public void setHire_date(String hire_date) {
	this.hire_date = hire_date;
}

}


