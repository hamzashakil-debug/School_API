package com.example.school.Service;

import com.example.school.Entity.Subject;
import com.example.school.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Long id, Subject updatedSubject) {
        return subjectRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedSubject.getName());
                    existing.setCode(updatedSubject.getCode());
                    existing.setCreditHours(updatedSubject.getCreditHours());
                    return subjectRepository.save(existing);
                })
                .orElse(null);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
