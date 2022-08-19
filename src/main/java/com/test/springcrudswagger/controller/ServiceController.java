package com.test.springcrudswagger.controller;

import com.test.springcrudswagger.domain.dto.ServiceDto;
import com.test.springcrudswagger.services.ServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceServices serviceServices;

    @PostMapping("")
    public ResponseEntity<Object> store(@Valid @RequestBody ServiceDto serviceDto)
    {
        return serviceServices.store(serviceDto);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll(@RequestParam(value = "status", required = true) String status)
    {
        return serviceServices.getAll(status);
    }

    @PutMapping("/{id}/update-status")
    public ResponseEntity<Object> updateStatus(@PathVariable("id") long id, @RequestParam(value = "status") String status)
    {
        return  serviceServices.updateStatus(id, status);
    }
}
