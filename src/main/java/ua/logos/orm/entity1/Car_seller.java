package ua.logos.orm.entity1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ua.logos.orm.entity.Course;
import ua.logos.orm.entity.TeacherDetails;

//@Entity
@Table(name = "Car_seller")
public class Car_seller extends Autobazar {

	public Car_seller() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;

	private int age;

	private int phone_number;

	public String getFirst_name() {
		return first_name;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id")
	private Car car;

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
