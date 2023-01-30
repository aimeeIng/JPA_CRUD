package com.javaCourse.crud.utilities;

import com.javaCourse.crud.entity.Mark;
import com.javaCourse.crud.exception.ResourceNotFoundException;
import com.javaCourse.crud.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mark")
public class MarkController {

    @Autowired
    private MarkRepository mrkRepository;

    @GetMapping
    public List<Mark> getAllMarks(){
        return this.mrkRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mark getStById(@PathVariable(value ="id") int id){
        return this.mrkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not found"));
    }

    @PostMapping
    public Mark createMrk(@RequestBody Mark mrk){
        return this.mrkRepository.save(mrk);
    }

    @PutMapping("/{id}")
    public Mark updateMark(@RequestBody Mark mrk, @PathVariable(value ="id") int id){
        Mark existingMark = this.mrkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("mark not Found"));
        existingMark.setMrk(mrk.getMrk());
        existingMark.setCode(mrk.getCode());
        return this.mrkRepository.save(existingMark);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mark> deleteSt(@PathVariable (value="id") int id){
        Mark existingMark = this.mrkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not found"));
        this.mrkRepository.delete(existingMark);
        return ResponseEntity.ok().build();
    }
}
