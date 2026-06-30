package com.vinay.CRUD.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vinay.CRUD.entity.Student;
import com.vinay.CRUD.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
       Student studentRes=studentRepository.save(studentReq);
       return studentRes;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentRes=studentRepository.findById(id);
        
        if(studentRes.isPresent())
            return studentRes.get();

        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList =studentRepository.findAll();
        return studentList;
    }

    public Student updateStudent(Long id,Student studentreq) {
        Optional<Student> existingStudent =studentRepository.findById(id);
        if(existingStudent.isEmpty())
            return null;

        Student studentToSave= existingStudent.get();

        studentToSave.setAge(studentreq.getAge());
        studentToSave.setEmail(studentreq.getEmail());
        studentToSave.setName(studentreq.getName());
        studentToSave.setRoll(studentreq.getRoll());
        studentToSave.setSubject(studentreq.getSubject());

        Student updatedStudent=studentRepository.save(studentToSave);
        return updatedStudent;

    }

    public boolean deleteStudent(Long id) {
        Boolean isPresent=studentRepository.existsById(id);
        if(!isPresent)
            return false;
        studentRepository.deleteById(id);
        return true;
    }
}
