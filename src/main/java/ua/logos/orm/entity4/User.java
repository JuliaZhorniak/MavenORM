package ua.logos.orm.entity4;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.logos.orm.entity.Teacher;

//@Entity
//@NoArgsConstructor
//@Table(name="user")
//@Getter@Setter
//@ToString(callSuper = true, exclude = {"city"})
//public class User extends Ent{
//	@Column(nullable = false)
//
//	private String full_name;
//	private int age;
//	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name = "city_id")
//	private City city;
//
//	
//}
