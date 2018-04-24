package ua.logos.orm.entity1;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ua.logos.orm.entity.Teacher;

//@Entity
@Table(name = "Car")
public class Car extends Autobazar {

	public Car() {
		super();
		this.make_id = make_id;
		this.seller_id = seller_id;
		this.sell_price = sell_price;
	}

	@Column(name = "make_id")
	private int make_id;
	@Column(name = "seller_id")
	private int seller_id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_make_id")
	private Car_make car_make;

	@Column(name = "sell_price", columnDefinition = "DECIMAL(5,2)")
	private BigDecimal sell_price;

	public int getMake_id() {
		return make_id;
	}

	public void setMake_id(int make_id) {
		this.make_id = make_id;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public BigDecimal getSell_price() {
		return sell_price;
	}

	public void setSell_price(BigDecimal sell_price) {
		this.sell_price = sell_price;
	}

	public Car_make getCar_make() {
		return car_make;
	}

	public void setCar_make(Car_make car_make) {
		this.car_make = car_make;
	}

}
