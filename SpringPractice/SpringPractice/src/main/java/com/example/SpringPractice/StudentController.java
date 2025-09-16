package com.example.SpringPractice;

import com.example.SpringPractice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepo repo;

   @ResponseBody
   @GetMapping("students")
   public List<Student>getStudents(){
       return repo.findAll();
   }

   @PostMapping("student")
   public Student saveStudent(@RequestBody Student student){
       return repo.save(student);
   }

   @GetMapping("student")
    public Student findStudent(@RequestParam("id")int id){
       return repo.findById(id).orElse(null);
   }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
       if(repo.existsById(id)){
           repo .deleteById(id);
           return "Student deleted" +id + "successfully";
       }
       return "Student with ID " + id + " not found.";
   }

    @PutMapping("/student/{id}")
    public  Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent){
        return repo.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setId(updatedStudent.getId());
                    // update other fields as needed
                    return repo.save(student);
                })
                .orElseGet(() -> {
                    // Optionally, create new if ID not found
                    updatedStudent.setId(id);
                    return repo.save(updatedStudent);
                });
    }

}
