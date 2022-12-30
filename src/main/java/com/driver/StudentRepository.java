package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentmap;
    private HashMap<String, Teacher> teachermap;
    private HashMap<String, List<String>> teacherstudent;

    public StudentRepository(){
        this.studentmap = new HashMap<String, Student>();
        this.teachermap = new HashMap<String, Teacher>();
        this.teacherstudent = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        studentmap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher){
        teachermap.put(teacher.getName(), teacher);
    }

    //student teacher00
    public void StudentTeacherPair(String student, String teacher){

        if(studentmap.containsKey(student) && teachermap.containsKey(teacher)){

            List<String> TeachertoStudent = new ArrayList<>();

            if(teacherstudent.containsKey(teacher)) {
                TeachertoStudent = teacherstudent.get(teacher);
            }

            TeachertoStudent.add(student);

            teacherstudent.put(teacher,TeachertoStudent);
        }
    }

    public Student findStudent(String name){
        return studentmap.get(name);
    }

    public Teacher findTeacher(String name){
        return teachermap.get(name);
    }

    public List<String> findStudentbyTeacher(String teachername){
        List<String> studentList = new ArrayList<String>();
        if(teacherstudent.containsKey(teachername)) studentList = teacherstudent.get(teachername);
        return studentList;
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(studentmap.keySet());
    }

    public void DeleteTeacher(String TeacherName){

        List<String>students = new ArrayList<>();

        if(teacherstudent.containsKey(TeacherName)){
            students = teacherstudent.get(TeacherName);

            for(String name : students ){
                if(studentmap.containsKey(name)) studentmap.remove(name);
            }
            teacherstudent.remove(TeacherName);
        }//if

        if(teachermap.containsKey(TeacherName)){
            teachermap.remove(TeacherName);
        }
    }//deleteTeacher

    public void deleteAllTeacher(){
        HashSet<String> students = new HashSet<String>();

        //delete all the teacher
        teachermap = new HashMap<>();

        //iterate and find for students by treacher
        for(String teacher: teacherstudent.keySet()){

            //Iterating in the list of students
            for(String student: teacherstudent.get(teacher)){
                students.add(student);
            }
        }

        //Deleting the students from Db.
        for(String student: students){
            if(studentmap.containsKey(student)){
                studentmap.remove(student);
            }
        }
        //clearing the pair.
        teacherstudent = new HashMap<>();
    }

}//class student repo
