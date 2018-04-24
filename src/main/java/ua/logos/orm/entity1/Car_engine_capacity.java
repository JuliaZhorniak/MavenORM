package ua.logos.orm.entity1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ua.logos.orm.entity.Course;

//@Entity
@Table(name = "Car_engine_capacity")
public class Car_engine_capacity extends Autobazar {

	public Car_engine_capacity(BigDecimal engine_capacity) {
		super();
		this.engine_capacity = engine_capacity;
	}

	public Car_engine_capacity() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "engine_capacity", columnDefinition = "DECIMAL(5,2)")
	private BigDecimal engine_capacity;
	@ManyToMany
	@JoinTable(name = "car_engine_capacity_car_fuel_type", joinColumns = @JoinColumn(name = "car_engine_capacity_id"), inverseJoinColumns = @JoinColumn(name = "car_fuel_type_id"))
	private List<car_fuel_type> fuel = new ArrayList<>();

	public BigDecimal getEngine_capacity() {
		return engine_capacity;
	}

	public void setEngine_capacity(BigDecimal engine_capacity) {
		this.engine_capacity = engine_capacity;
	}

	public List<car_fuel_type> getFuel() {
		return fuel;
	}

	public void setFuel(List<car_fuel_type> fuel) {
		this.fuel = fuel;
	}


}
