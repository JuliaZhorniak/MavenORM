package ua.logos.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teacher_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class TeacherDetails extends BaseEntity {

	@Column(name = "hobby")
	private String hobby;

	@Column(name = "email")
	private String email;

}
