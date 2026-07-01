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
       studentReq.setDeleted(false);
       Student studentRes=studentRepository.save(studentReq);
       return studentRes;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentRes=studentRepository.findByIdAndDeletedIsFalse(id);
        
        if(studentRes.isPresent())
            return studentRes.get();

        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList =studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    public Student updateStudent(Long id,Student studentreq) {
        Optional<Student> existingStudent =studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty())
            return null;

        Student studentToSave= existingStudent.get();

        studentToSave.setAge(studentreq.getAge());
        studentToSave.setEmail(studentreq.getEmail());
        studentToSave.setName(studentreq.getName());
        studentToSave.setRoll(studentreq.getRoll());
        studentToSave.setSubject(studentreq.getSubject());
        studentToSave.setDeleted(false);

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

    public boolean softDeleteStudent(Long id) {
        Optional<Student> existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty())
            return false;

        Student studentToSave=existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }
}
