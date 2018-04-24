package ua.logos.orm.entity4;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.logos.orm.entity.Course;
import ua.logos.orm.entity.Student;

////@Entity
//@NoArgsConstructor
//@Getter @Setter
//@ToString(callSuper = true, exclude = { "students", "user" })
//public class City extends Ent{
//	private String name;
//
//	
//	@OneToMany(mappedBy = "city",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//	private List<User> user = new ArrayList<>();
//
//}
