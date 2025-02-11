package com.example.demo.controller;



import com.example.demo.entity.SpecialityCard;
import com.example.demo.repository.SpecialityCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class SpecialityCardController {
    @Autowired
    SpecialityCardRepo SC;
    @GetMapping("/specialityCardGet")
    public List<SpecialityCard> getSpecialityCard(){
        return SC.findAll();
    }
    @PostMapping("/specialityCardPost")
    public String postSpecialityCard(@RequestBody SpecialityCard s){
        SC.save(s);
        return "Posted Successfully";
    }
    @GetMapping("/CardById/{n}")
    public Optional<SpecialityCard> getById(@PathVariable int n){
          return SC.findById(n);
    }
}