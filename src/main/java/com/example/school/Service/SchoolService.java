package com.example.school.Service;

import com.example.school.Entity.School;
import com.example.school.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<School> getSchoolById(Long id) {
        return schoolRepository.findById(id);
    }

    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    public School updateSchool(Long id, School updatedSchool) {
        return schoolRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedSchool.getName());
                    existing.setAddress(updatedSchool.getAddress());
                    return schoolRepository.save(existing);
                })
                .orElse(null);
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
}
