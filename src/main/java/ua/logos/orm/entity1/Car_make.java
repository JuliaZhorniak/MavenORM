package ua.logos.orm.entity1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ua.logos.orm.entity.Course;
import ua.logos.orm.entity.TeacherDetails;

//@Entity
@Table(name = "Car_make")
public class Car_make extends Autobazar {

	public Car_make() {

	}

	@Column(name = "make_title", length = 120)
	private String make_title;
	@Column(name = "manufacture_year")
	private int manufacture_year;
	@OneToMany(mappedBy = "car_make")
	private List<Car_model> model = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "car_make_car_color", joinColumns = @JoinColumn(name = "car_make_id"), inverseJoinColumns = @JoinColumn(name = "car_color_id"))
	private List<Car_color> color = new ArrayList<>();

	public String getMake_title() {
		return make_title;
	}

	public int getManufacture_year() {
		return manufacture_year;
	}

	public void setManufacture_year(int manufacture_year) {
		this.manufacture_year = manufacture_year;
	}

	public void setMake_title(String make_title) {
		this.make_title = make_title;
	}

	public List<Car_model> getModel() {
		return model;
	}

	public void setModel(List<Car_model> model) {
		this.model = model;
	}

	public List<Car_color> getColor() {
		return color;
	}

	public void setColor(List<Car_color> color) {
		this.color = color;
	}

}
