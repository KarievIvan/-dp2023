package com.example.backend.controller;

import com.example.backend.entity.ShampooEntity;
import com.example.backend.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/shampoo")
public class ShampooController {
    @Autowired
    ShampooRepository shampooRepository;

    @GetMapping("/retrieve")
    public List<ShampooEntity> getEntities(){
        return shampooRepository.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ShampooEntity postEntity(@RequestBody ShampooEntity guitarEntity){
        return shampooRepository.save(guitarEntity);
    }

    @PutMapping("/update/{id}")
    public ShampooEntity putEntity(@PathVariable long id, @RequestBody ShampooEntity newEntity){
        ShampooEntity updatedEntity = shampooRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found guitarEntity with id: "+id));
        updatedEntity.setName(newEntity.getName());
        updatedEntity.setPhoto(newEntity.getPhoto());
        updatedEntity.setRate(newEntity.getRate());
        updatedEntity.setPrice(newEntity.getPrice());

        return shampooRepository.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        shampooRepository.deleteById(id);
    }
}
