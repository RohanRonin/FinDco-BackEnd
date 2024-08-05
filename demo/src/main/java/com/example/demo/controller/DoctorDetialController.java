package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DoctorDetails;
import com.example.demo.repository.DoctorDetailRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DoctorDetialController {
    @Autowired
    DoctorDetailRepo DD;
    @GetMapping("/doctorDetailGet")
    public List<DoctorDetails> getDoctorDetail(){
        return DD.findAll();
    }
    @PostMapping("/doctorDetailPost")
    public String postDoctorDetail(@RequestBody DoctorDetails d){
        DD.save(d);
        return "Posted Successfully";
    }
    @GetMapping("/DoctorDetailById/{n}")
    public Optional<DoctorDetails> getById(@PathVariable int n){
        return DD.findById(n);
    }

}