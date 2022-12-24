package me.mrsofiane.demogdg;

import me.mrsofiane.demogdg.entities.Student;
import me.mrsofiane.demogdg.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoGdgApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGdgApplication.class, args);
	}

	@Bean
	CommandLineRunner start(StudentRepository studentRepository){
		return args -> {
			Student student1 = Student.builder()
					.firstName("amine")
					.lastName("amine")
					.email("amine@gmail.com")
					.build();

			Student student2 = Student.builder()
					.firstName("amina")
					.lastName("amina")
					.email("amina@gmail.com")
					.build();

			studentRepository.saveAll(List.of(student1, student2));



		};
	}

}
