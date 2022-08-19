package com.test.springcrudswagger.controller;

import com.test.springcrudswagger.domain.dto.ServiceDto;
import com.test.springcrudswagger.domain.dto.ServiceRequestDto;
import com.test.springcrudswagger.services.ServiceServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
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
//    @RouterOperation(operation = @Operation(description = "Say hello", operationId = "hello", tags = "persons",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "Success|OK"),
//                    @ApiResponse(responseCode = "201", description = "CREATED"),
//                    @ApiResponse(responseCode = "401", description = "FORBIDDEN!!!"),
//                    @ApiResponse(responseCode = "404", description = "NOT FOUND!!!"),
//                    @ApiResponse(responseCode = "500", description = "SERVER ERROR")
//            }
//    ))
    public ResponseEntity<Object> store(@Valid @RequestBody ServiceRequestDto serviceRequestDto)
    {
        return serviceServices.store(serviceRequestDto);
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
