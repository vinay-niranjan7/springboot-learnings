package com.vinay.CRUD.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.vinay.CRUD.dto.CreateStudentRequestDto;
import com.vinay.CRUD.dto.CreateStudentResponseDto;
import com.vinay.CRUD.dto.UpdateStudentRequestDto;
import com.vinay.CRUD.dto.UpdateStudentResponseDto;
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

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReq) {
       Student studentEntity = mapToEntity(studentReq);
       Student studentRes=studentRepository.save(studentEntity);
       return mapToDto(studentRes);
    }

    public CreateStudentResponseDto getStudent(Long id) {
        Optional<Student> studentRes=studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentRes.isPresent())
            return mapToDto(studentRes.get());

        return null;
    }

    public List<CreateStudentResponseDto> getAllStudents() {
        List<Student> studentList =studentRepository.findByDeletedIsFalse();

        return studentList.stream()
                .map(this::mapToDto)
                .toList();
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentreq) {
        Optional<Student> existingStudent =studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty())
            return null;

        Student studentToSave= existingStudent.get();
        studentToSave.setAge(studentreq.getAge());
        studentToSave.setName(studentreq.getName());
        studentToSave.setRoll(studentreq.getRoll());
        studentToSave.setSubject(studentreq.getSubject());
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student updatedStudent=studentRepository.save(studentToSave);
        return mapToUpdateDto(updatedStudent);

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

    private CreateStudentResponseDto mapToDto(Student studentRes) {
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();
        responseDto.setId(studentRes.getId());
        responseDto.setAge(studentRes.getAge());
        responseDto.setEmail(studentRes.getEmail());
        responseDto.setName(studentRes.getName());
        responseDto.setRoll(studentRes.getRoll());
        responseDto.setSubject(studentRes.getSubject());
        responseDto.setUpdatedAt(studentRes.getUpdatedAt());
        responseDto.setCreatedAt(studentRes.getCreatedAt());
        responseDto.setMessage("Student Saved Successfully");
        return responseDto;

    }

    private Student mapToEntity(CreateStudentRequestDto studentReq) {
        Student student=new Student();

        student.setRoll(studentReq.getRoll());
        student.setAge(studentReq.getAge());
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setSubject(studentReq.getSubject());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student updatedStudent) {
        UpdateStudentResponseDto responseDto = new UpdateStudentResponseDto();
        responseDto.setId(updatedStudent.getId());
        responseDto.setAge(updatedStudent.getAge());
        responseDto.setName(updatedStudent.getName());
        responseDto.setRoll(updatedStudent.getRoll());
        responseDto.setSubject(updatedStudent.getSubject());
        responseDto.setUpdatedAt(updatedStudent.getUpdatedAt());
        responseDto.setMessage("Student Updated Successfully");
        return responseDto;
    }
}
