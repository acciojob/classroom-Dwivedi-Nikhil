package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class StudentService {

@Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.saveStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.saveTeacher(teacher);
    }

    public void StudentTeacher(String student, String teacher){
        studentRepository.StudentTeacherPair(student, teacher);
    }

    public Student getStudent(String name){
        return studentRepository.findStudent(name);  //mistake: return type void liya tha
    }
    public Teacher findTeacher(String name){
       return studentRepository.findTeacher(name); //mistake: return type void liya tha
    }

    public List<String> findStudentsbyTeacher(String teacher){
        return studentRepository.findStudentbyTeacher(teacher);
    }
    public List<String> findAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String teacher){
        studentRepository.DeleteTeacher(teacher);
    }
    public void deleteAllTeachers(){
        studentRepository.deleteAllTeacher();
    }

}//class StudentService

