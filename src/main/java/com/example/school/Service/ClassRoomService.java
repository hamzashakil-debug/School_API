package com.example.school.Service;

import com.example.school.Entity.ClassRoom;
import com.example.school.Repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomRepository classroomRepository;

    public List<ClassRoom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public Optional<ClassRoom> getClassroomById(Long id) {
        return classroomRepository.findById(id);
    }

    public ClassRoom addClassroom(ClassRoom classroom) {
        return classroomRepository.save(classroom);
    }

    public ClassRoom updateClassroom(Long id, ClassRoom updated) {
        return classroomRepository.findById(id)
                .map(existing -> {
                    existing.setRoomNumber(updated.getRoomNumber());
                    existing.setCapacity(updated.getCapacity());
                    existing.setFloor(updated.getFloor());
                    return classroomRepository.save(existing);
                })
                .orElse(null);
    }

    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }
}
