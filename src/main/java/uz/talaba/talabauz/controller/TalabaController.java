package uz.talaba.talabauz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.talaba.talabauz.entity.Talaba;
import uz.talaba.talabauz.service.TalabaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/talaba")
@CrossOrigin(maxAge = 3600)
public class TalabaController {
    
    @Autowired
    TalabaService talabaService;
  

    @GetMapping
    public List<Talaba> getAll() {

        return talabaService.getAll();
    }

    @GetMapping("/{id}")
    public Talaba getById(@PathVariable Long id) {

        return talabaService.getById(id);

    }

    @PostMapping
    public Talaba create(@RequestBody Talaba talaba) {

        return talabaService.create(talaba);
    }

    @PutMapping
    public Talaba update(@RequestBody Talaba talaba) {

        return   talabaService.update(talaba);
    }

    @DeleteMapping
    public void delete(@RequestBody Talaba talaba) {

        talabaService.delete(talaba);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") Long id) {
        if(talabaService.deleteById(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }
    
    
}
