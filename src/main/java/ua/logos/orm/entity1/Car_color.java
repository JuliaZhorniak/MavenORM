package ua.logos.orm.entity1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ua.logos.orm.entity.Student;

//@Entity
@Table(name = "Car_color")
public class Car_color  extends Autobazar{


	public Car_color(String color) {
		super();
		this.color = color;
	}

	public Car_color() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "color")
	private String color;
	@ManyToMany
	@JoinTable(name = "car_make_car_color", joinColumns = @JoinColumn(name = "car_color_id"), inverseJoinColumns = @JoinColumn(name = "car_make_id"))
	private List<Car_make> make = new ArrayList<>();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Car_make> getMake() {
		return make;
	}

	public void setMake(List<Car_make> make) {
		this.make = make;
	}

}
