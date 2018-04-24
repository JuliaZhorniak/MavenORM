package ua.logos.orm;



import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.logos.orm.entity.Course;
import ua.logos.orm.entity.Student;
import ua.logos.orm.entity.Teacher;
import ua.logos.orm.entity.TeacherDetails;
import ua.logos.orm.entity1.Car;
import ua.logos.orm.entity1.Car_color;
import ua.logos.orm.entity1.Car_engine_capacity;
import ua.logos.orm.entity1.Car_make;
import ua.logos.orm.entity1.Car_model;
import ua.logos.orm.entity1.Car_seller;
import ua.logos.orm.entity1.car_fuel_type;
import ua.logos.orm.entity11.User;


public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory managerFactory = 
				Persistence.createEntityManagerFactory("mysql");
		EntityManager em = managerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
//addStudentCurse(em);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> query = cb.createQuery(Course.class);
		Root<Course> root = query.from(Course.class);
		query.select(root);//SELECT C FROM course
		
		
		Expression<Integer> courseIdExpression = root.get("Id");
		Predicate courseIdPredicate = cb.greaterThanOrEqualTo(courseIdExpression, 2);//id>=20
		
	    Predicate courseidin = courseIdExpression.in(Arrays.asList(2,3,4,5,5));
	    query.where(courseidin);
		
		Expression<BigDecimal> course1IDeXPRESSION = root.get("price");
		Predicate course = cb.greaterThanOrEqualTo(course1IDeXPRESSION, new BigDecimal("40.00"));
		Predicate allpredicate = cb.and(courseIdPredicate,course);
		//query.where(allpredicate);
		
		Expression<String> courseTitrleExpression = root.get("title");
		Predicate courseTitleLikePredicate = cb.like(courseTitrleExpression,"%2");
		
		Predicate allpredicate1 = cb.and(courseTitleLikePredicate,courseIdPredicate);
		//query.where(allpredicate1);
		Predicate coursePriceBetween  = cb.between(course1IDeXPRESSION, new BigDecimal("20.00"), new BigDecimal("35.00"));
		//query.where(coursePriceBetween);
		
		
		Join<Course,Teacher> teacherjoin = root.join("teacher");
		Join<Course,Student> studentjoin = root.join("students");
		Expression<Integer> studentIdjoin = studentjoin.get("id");
		Expression<Integer> teacherIdjoin = teacherjoin.get("id");
		Predicate teacherIdPredicate = cb.equal(teacherIdjoin, 2);
		Predicate studentIdPredicate = cb.greaterThanOrEqualTo(teacherIdjoin, 480);//==id
		query.where(teacherIdPredicate,studentIdPredicate);
		root.fetch("teacher");
		em.createQuery(query).getResultList().forEach(System.out::println);
		
//		Student student = em.createQuery("SELECT s FROM Student s LEFT JOIN FETCH s.courses sc WHERE s.id = ?1",Student.class).setParameter(1, 11).getSingleResult();
//		System.out.println(student);
		
		//MAX
//		BigDecimal max = em.createQuery("SELECT max(c.price)FROM Course c",BigDecimal.class).getSingleResult();
//		System.out.println("MAX: "+ max);
//		BigDecimal min = em.createQuery("SELECT min(c.price) FROM Course c",BigDecimal.class).getSingleResult();
//		System.out.println("MIN:"+min);
		
		//BigDecimal sum = em.createQuery("SELECT sum(c.price)FROM Course c",BigDecimal.class).getSingleResult();
		//System.out.println("SUM:"+ sum);
		
//		BigDecimal sum = em
//				.createQuery("SELECT sum(c.price) FROM Course c  WHERE c.id BETWEEN ?1 AND ?2", BigDecimal.class)
//				.setParameter(1, 20).setParameter(2, 40).getSingleResult();
//		System.out.println("sum between" + sum);
//
//		Double avg = em.createQuery("SELECT avg(c.price) FROM Course c", Double.class).getSingleResult();
//		System.out.println("AVG" + avg);
//	
//		Long count = em.createQuery("SELECT count(c) FROM Course c",Long.class).getSingleResult();
//		System.out.println("count" + count);
//		
		
		
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = ?1",Teacher.class).setParameter(1, 10).getSingleResult();
//		System.out.println(teacher);
//		System.out.println(teacher.getTeacherDetails());
//		
//		Course course = em.createQuery("SELECT c FROM Course c WHERE c.id = ?1",Course.class).setParameter(1, 20).getSingleResult();
//		System.out.println(course);
		//System.out.println(course.getTeacher());
		
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t " + "JOIN FETCH t.teacherDetails WHERE t.id = ?1",Teacher.class).setParameter(1, 5).getSingleResult();
//		System.out.println(teacher);
//		System.out.println(teacher.getTeacherDetails());
		
		
		
//		for (int i = 1; i <= 50; i++) {
//			Teacher teacher = new Teacher();
//			teacher.setFirstName("FirstName #" + i);
//			teacher.setLastName("LastName #" + i);
//			teacher.setAge(i);
//			teacher.setDescription("Teacher Description #" + i);
//			teacher.setTeacherDetails(new TeacherDetails("My Hobby#" + i,"my email#" + i+"@email.com")
//					);
//
//			em.persist(teacher);
//		}
//
//		for (int i = 1; i <= 50; i++) {
//			Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :teacherId", Teacher.class)
//			.setParameter("teacherId", i).getSingleResult();
//			Course course = new Course();
//			course.setTitle("Course title #" + i);
//			course.setDescription("Course Description #" + i);
//			course.setPrice(new BigDecimal(i + ".00"));
//
//			course.setTeacher(teacher);
//			em.persist(course);
//		}
//	List<Course > courses = em.createQuery("SELECT c FROM Course c WHERE c.id BETWEEN :start AND :finish",Course.class).getResultList();
//		for(int i = 1;i<100;i++) {
//			Student student = new Student();
//			student.setFullName("Student Full Name#" + i);
//			student.setAge(i);
//			student.setHobby("BLA BLA#" + i);
//			if(i%2==1) {
//				student.setCourses(courses);
//			}
//			
//			em.persist(student);
//		}
//		List<Teacher> teachersList = 
//				em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
//		teachersList.forEach(t -> System.out.println(t));
		
//		Course course = 
//				em.createQuery("SELECT c FROM Course c WHERE c.id = :courseId", Course.class)
//				.setParameter("courseId", 25).getSingleResult();
//		System.out.println(course);

		//List<Course> courses 
//		em.createQuery("SELECT c FROM Course c WHERE c.id >= :courseId", Course.class)
//			.setParameter("courseId", 40).getResultList()
//			.forEach(System.out::println);

		// LIKE
//		em.createQuery("SELECT t FROM Teacher t WHERE t.firstName LIKE :firstNamePattern", Teacher.class)
//			.setParameter("firstNamePattern", "%Name #_").getResultList()
//			.forEach(System.out::println);
		
//		em.createQuery("SELECT c FROM Course c WHERE c.title LIKE :titlePattern AND c.id >= :courseId", Course.class)
//			.setParameter("titlePattern", "%8")
//			.setParameter("courseId", 10)
//			.getResultList()
//			.forEach(System.out::println);

		// BETWEEN
//		em.createQuery("SELECT t FROM Teacher t WHERE t.id BETWEEN :start AND :finish", Teacher.class)
//			.setParameter("start", 23)
//			.setParameter("finish", 33)
//			.getResultList().forEach(System.out::println);
		
		// IN
//		em.createQuery("SELECT c FROM Course c WHERE c.id IN (:ids)", Course.class)
//			.setParameter("ids", Arrays.asList(12, 34, 23, 39, 49, 55))
//			.getResultList().forEach(System.out::println);
//		teacher.setDescription("Teacher Description #" + i);
//		teacher.setTeacherDetails(new TeacherDetails());
		
		
		

	

		
		
		
		
		
	
		
		em.getTransaction().commit();
		em.close();
		managerFactory.close();
	}




//TeacherDetails teacherDetails = new TeacherDetails();
//teacherDetails.setEmail("teacher@gmail.com");
//teacherDetails.setHobby("Programming");
//em.persist(teacherDetails);
//
//Teacher teacher = new Teacher();
//teacher.setFirstName("Tom");
//teacher.setLastName("Doe");
//teacher.setAge(32);
//teacher.setDescription("Tom's Description");
//teacher.setTeacherDetails(teacherDetails);
//em.persist(teacher);
//Teacher teacher = em.find(Teacher.class, 1);
//System.out.println(teacher.getFirstName() + " " + teacher.getId());
}
