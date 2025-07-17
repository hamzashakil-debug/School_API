package com.example.school.Controller;

import com.example.school.Entity.ClassRoom;
import com.example.school.Service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classrooms")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classroomService;

    @GetMapping
    public List<ClassRoom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public Optional<ClassRoom> getClassroomById(@PathVariable Long id) {
        return classroomService.getClassroomById(id);
    }

    @PostMapping
    public ClassRoom addClassroom(@RequestBody ClassRoom classroom) {
        return classroomService.addClassroom(classroom);
    }

    @PutMapping("/{id}")
    public ClassRoom updateClassroom(@PathVariable Long id, @RequestBody ClassRoom classroom) {
        return classroomService.updateClassroom(id, classroom);
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
    }
}
