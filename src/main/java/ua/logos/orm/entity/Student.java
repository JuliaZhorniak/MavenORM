package ua.logos.orm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true,exclude = { "course", "teacher" })
public class Student extends BaseEntity {

	@Column(name = "full_name")
	private String fullName;

	private int age;

	@Column(length = 300)
	private String hobby;

	@ManyToMany(cascade =  {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "student_course", 
		joinColumns = @JoinColumn(name = "student_id"), 
		inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses = new ArrayList<>();

}
