package ua.logos.orm.entity1;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ua.logos.orm.entity.Teacher;

//@Entity
@Table(name = "Car_model")
public class Car_model extends Autobazar {

	public Car_model(String model_title, int engine_capacity_id, int fuel_type_id, String collor_id, int car_make_id) {
		super();
		this.model_title = model_title;
		this.engine_capacity_id = engine_capacity_id;
		this.fuel_type_id = fuel_type_id;
		this.collor_id = collor_id;
		this.car_make_id = car_make_id;
	}

	public Car_model() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "model_title", length = 120)
	private String model_title;
	
	@Column(name = "engine_capacity_id")
	private int engine_capacity_id;
	
	@Column(name = "fuel_type_id")
	private int fuel_type_id;
	
	@Column(name = "collor_id")
	private String collor_id;
	
	@Column(name = "car_make_id")
	private int car_make_id;
	@ManyToOne
	@JoinColumn(name = "car_make1_id")
	private Car_make car_make;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_engine_capacity")
	private Car_engine_capacity car_engine;

	public String getModel_title() {
		return model_title;
	}

	public int getEngine_capacity_id() {
		return engine_capacity_id;
	}

	public void setEngine_capacity_id(int engine_capacity_id) {
		this.engine_capacity_id = engine_capacity_id;
	}

	public int getFuel_type_id() {
		return fuel_type_id;
	}

	public void setFuel_type_id(int fuel_type_id) {
		this.fuel_type_id = fuel_type_id;
	}

	public String getCollor_id() {
		return collor_id;
	}

	public void setCollor_id(String collor_id) {
		this.collor_id = collor_id;
	}

	public int getCar_make_id() {
		return car_make_id;
	}

	public void setCar_make_id(int car_make_id) {
		this.car_make_id = car_make_id;
	}

	public void setModel_title(String model_title) {
		this.model_title = model_title;
	}

	public Car_make getCar_make() {
		return car_make;
	}

	public void setCar_make(Car_make car_make) {
		this.car_make = car_make;
	}

	public Car_engine_capacity getCar_engine() {
		return car_engine;
	}

	public void setCar_engine(Car_engine_capacity car_engine) {
		this.car_engine = car_engine;
	}

}
