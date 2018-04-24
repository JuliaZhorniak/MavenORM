package ua.logos.orm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = { "courses", "teacherDetails" })
public class Teacher extends BaseEntity {

	@Column(name = "first_name", length = 50) // VARCHAR(50)
	private String firstName; // first_name

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "description", length = 500)
	private String description;

	@OneToMany(mappedBy = "teacher",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Course> courses = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_details_id")
	private TeacherDetails teacherDetails;

}
