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
@Table(name = "Car_fuel_type")
public class car_fuel_type extends Autobazar {

	public car_fuel_type(String fuel_type) {
		super();
		this.fuel_type = fuel_type;
	}

	public car_fuel_type() {
		// TODO Auto-generated constructor stub
	}
	@ManyToMany
	@JoinTable(name = "car_engine_capacity_car_fuel_type", joinColumns = @JoinColumn(name = "car_fuel_type_id"), inverseJoinColumns = @JoinColumn(name = "car_engine_capacity_id"))
	private List<Car_engine_capacity> cap = new ArrayList<>();
	@Column(name = "fuel_type")
	private String fuel_type;

	public String getFuel_type() {
		return fuel_type;
	}

	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}

	public List<Car_engine_capacity> getCap() {
		return cap;
	}

	public void setCap(List<Car_engine_capacity> cap) {
		this.cap = cap;
	}

}
