package com.example.school.Service;

import com.example.school.Entity.Teacher;
import com.example.school.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        return teacherRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedTeacher.getName());
                    existing.setSubjectSpecialization(updatedTeacher.getSubjectSpecialization());
                    existing.setYearsOfExperience(updatedTeacher.getYearsOfExperience());
                    return teacherRepository.save(existing);
                })
                .orElse(null);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
