package ua.logos.orm.entity4;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.logos.orm.entity.Course;

////@Entity
//@NoArgsConstructor
//@Table(name="country")
//@Getter@Setter
//@ToString(callSuper = true, exclude = { "city"})
//public class Country extends Ent {
//
//
//	@Column(nullable = false)
//	private String name;
//	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.LAZY)
//	@JoinTable(name = "country_city", joinColumns = @JoinColumn(name = "country_id"), inverseJoinColumns = @JoinColumn(name = "city_id"))
//	private List<City> city = new ArrayList<>();
	


	
//}
