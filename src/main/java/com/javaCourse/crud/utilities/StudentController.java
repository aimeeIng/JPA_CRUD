package com.javaCourse.crud.utilities;

import com.javaCourse.crud.entity.Student;
import com.javaCourse.crud.exception.ResourceNotFoundException;
import com.javaCourse.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentRepository stRepository;

    @GetMapping
    public List<Student> getAllStudent(){
        return this.stRepository.findAll();
    }

    @GetMapping("/{reg_no}")
    public Student getStByRegnbr(@PathVariable(value ="reg_no") int reg_no){
        return this.stRepository.findById(reg_no).orElseThrow(() -> new ResourceNotFoundException("student not found"));
    }

    @PostMapping
    public Student createSt(@RequestBody Student st){
        return this.stRepository.save(st);
    }

    @PutMapping("/{reg_no}")
    public Student updateSt(@RequestBody Student st, @PathVariable(value ="reg_no") int reg_no){
        Student existingSt = this.stRepository.findById(reg_no).orElseThrow(() -> new ResourceNotFoundException("student not Found"));
        existingSt.setReg_no(st.getReg_no());
        existingSt.setFname(st.getFname());
        existingSt.setLname(st.getLname());
        existingSt.setMark(st.getMark());
        return this.stRepository.save(existingSt);
    }

    @DeleteMapping("/{reg_no}")
    public ResponseEntity<Student> deleteSt(@PathVariable (value="reg_no") int reg_no){
        Student existingSt = this.stRepository.findById(reg_no).orElseThrow(() -> new ResourceNotFoundException("student not found"));
        this.stRepository.delete(existingSt);
        return ResponseEntity.ok().build();
    }
}
