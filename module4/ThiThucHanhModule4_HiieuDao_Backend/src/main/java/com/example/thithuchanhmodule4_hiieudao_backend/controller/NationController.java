package com.example.thithuchanhmodule4_hiieudao_backend.controller;

import com.example.thithuchanhmodule4_hiieudao_backend.model.Nation;
import com.example.thithuchanhmodule4_hiieudao_backend.service.nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/nations")
public class NationController {

    @Autowired
    INationService nationService;

    @GetMapping
    public ResponseEntity<Iterable<Nation>> findAllNationals() {
        return new ResponseEntity<>(nationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nation> findNationalById(@PathVariable Long id) {
        return new ResponseEntity<>(nationService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Nation> save(@RequestBody Nation nation) {
        nationService.save(nation);
        return new ResponseEntity<>(nation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nation> updateNational(@PathVariable Long id, @RequestBody Nation nation) {
        Optional<Nation> nationalOptional = nationService.findById(id);
        if (!nationalOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        nation.setId(nationalOptional.get().getId());
        nationService.save(nation);
        return new ResponseEntity<>(nation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Nation> deleteNational(@PathVariable Long id) {
        Optional<Nation> nationalOptional = nationService.findById(id);
        if (!nationalOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        nationService.remove(id);
        return new ResponseEntity<>(nationalOptional.get(), HttpStatus.NO_CONTENT);
    }
}
