package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createMultipleStudents(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);


		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(1);
		System.out.println("Delete successfully");
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		 int deletedNumbers = studentDAO.deleteAll();
		System.out.println("Delete students: " + deletedNumbers);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id =1;
		Student student = studentDAO.findById(id);
		student.setFirstName("Mr.Chonsawat");

		studentDAO.update(student);
		var foundedStudent = studentDAO.findById(id);
		System.out.println("Update done: " + foundedStudent);
	}

	private void queryFromStudentByLastname(StudentDAO studentDAO) {
		Student student = studentDAO.findByLastName("Nakanam");
		System.out.println(student);
	}

	private void queryFromStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		students.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO, Integer id) {
		Student student = studentDAO.findById(id);
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object ...");
		Student student = new Student("Chonsawat", "Nakanam", "chonsawat.nakanam@kkumail.com");

		System.out.println("saving ...");
		studentDAO.save(student);

		System.out.println("saving success with id: " + student.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating student object ...");
		Student student1 = new Student("Mesinee", "Yomanat", "mesinee.yo@kkumail.com");
		Student student2 = new Student("Chonsawat", "Nakanam", "chonsawat.nakanam@kkumail.com");
		Student student3 = new Student("Wanisaraporn", "Klinsawat", "y.wanis@kkumail.com");
		Student student4 = new Student("Nathida", "Saiman", "nathida.saiman@kkumail.com");
		Student student5 = new Student("Sarawut", "Posan", "sarawut.posan@kkumail.com");

		System.out.println("saving ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);
		studentDAO.save(student5);

		System.out.println("saving success with id: " + student1.getId());
		System.out.println("saving success with id: " + student2.getId());
		System.out.println("saving success with id: " + student3.getId());
		System.out.println("saving success with id: " + student4.getId());
		System.out.println("saving success with id: " + student5.getId());
	}
}
