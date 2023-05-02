package co.develhope.crud.services;

import co.develhope.crud.entities.Student;
import co.develhope.crud.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     Updates the working status of a student with the given ID.
     @param id the ID of the student to update
     @param isWorking the new working status to set for the student
     @return the updated student object, or null if no student was found with the given ID
     */
    public Student setStudentIsWorkingStatus(Long id, boolean isWorking){
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()) return null;
        student.get().setWorking(isWorking);
        return studentRepository.save(student.get());
    }
}
