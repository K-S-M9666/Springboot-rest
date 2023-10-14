package com.javaguides.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springbootrestapi.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {
  
	//Springboot rest Api with Getmapping
	//http://localhost:8080/students/student
	/*
	 * @GetMapping("student") public Student getStudent() { Student student =new
	 * Student(1,"Surya","Manikantha"); return student; }
	 */
	
	@GetMapping("student")
	 public ResponseEntity<Student> getStudent()
	 {
		 Student student =new Student(1,"Surya","Manikantha");
		// return new ResponseEntity<>(student,HttpStatus.OK);
		 return  ResponseEntity.ok().header("custom-header", "Surya").body(student);
	 }
	
	//Springboot rest Api with Getmapping
	//http://localhost:8080/students
	/*
	 * @GetMapping public List<Student> getStudents() { List<Student>
	 * students = new ArrayList<>(); students.add(new
	 * Student(1,"Surya","Manikantha")); students.add(new
	 * Student(2,"Ramesh","Fadatare")); students.add(new
	 * Student(3,"Siva","Ramesh")); students.add(new Student(4,"Surya","Keerthi"));
	 * 
	 * return students; }
	 */
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents()
	{
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Surya","Manikantha"));
		students.add(new Student(2,"Ramesh","Fadatare"));
		students.add(new Student(3,"Siva","Ramesh"));
		students.add(new Student(4,"Surya","Keerthi"));
		
		return ResponseEntity.ok(students);
	}
	
	
	
	//Springboot rest Api with Getmapping with pathvariable
	//http://localhost:8080/students/1
	/*
	 * @GetMapping("{id}/{first-name}/{last-name}") public Student
	 * studentPathVariable(@PathVariable int id,@PathVariable("first-name") String
	 * firstName ,@PathVariable("last-name") String lastName ) { //return new
	 * Student(id,"Surya","Manikantha"); return new Student(id,firstName,lastName);
	 * }
	 */
	
	
	@GetMapping("{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> studentPathVariable(@PathVariable int id,@PathVariable("first-name") String firstName
			                                           ,@PathVariable("last-name") String lastName	)
	{
		//return new Student(id,"Surya","Manikantha");
		Student student= new Student(id,firstName,lastName);
		return ResponseEntity.ok(student);
	}
	
	//Springboot rest Api with request parm 
	//http://localhost:8080/students/query?id=1
	//http://localhost:8080/students/query?id=1&firstName="Surya"&lastName="Manikantha"
	/*
	 * @GetMapping("query") public Student
	 * studentRequestVariable(@RequestParam int id,@RequestParam String
	 * firstName,@RequestParam String lastName) { //return new
	 * Student(id,"Surya","manikantha"); return new Student(id,firstName,lastName);
	 * }
	 */
	
	
	@GetMapping("query")
	public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName)
	{
		//return new Student(id,"Surya","manikantha");
		Student student= new Student(id,firstName,lastName);
		return ResponseEntity.ok(student);
	}
	
	//Spring boot Rest API that handles HTTP Post Request
	//http://localhost:8080/students/create
	/*
	 * @PostMapping("create")
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public Student createStudent(@RequestBody
	 * Student student) { System.out.println(student.getId());
	 * System.out.println(student.getFirstName());
	 * System.out.println(student.getLastName());
	 * 
	 * return student; }
	 */
	
	@PostMapping("create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student)
	{
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}
	
	
	
	//Spring boot Rest API that handles HTTP Put Request
	//http://localhost:8080/students/1/update
	/*
	 * @PutMapping("{id}/update") public Student updateStudent(@RequestBody
	 * Student student,@PathVariable int id) {
	 * System.out.println(student.getFirstName());
	 * System.out.println(student.getLastName()); return student; }
	 */
	
	
	@PutMapping("{id}/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable int id)
	{
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
	}
	
	
	
	//Spring boot Rest API that handles HTTP Delete Request
	//http://localhost:8080/student/1/delete
	/*
	 * @DeleteMapping("student/{id}/delete") public String
	 * deleteStudent(@PathVariable int id) { System.out.println(id); return
	 * "Student deleted sucessfully :"+id; }
	 */
	
	@DeleteMapping("student/{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable int id)
	{
		System.out.println(id);
		return ResponseEntity.ok("Student deleted sucessfully :"+id);
	}
}
