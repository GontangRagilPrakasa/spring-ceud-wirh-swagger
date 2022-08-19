package com.test.springcrudswagger.services;

import com.test.springcrudswagger.domain.dto.ServiceDto;
import com.test.springcrudswagger.domain.entities.ServiceEntity;
import com.test.springcrudswagger.repository.ServiceRepository;
import com.test.springcrudswagger.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceServices {
    @Autowired
    ServiceRepository serviceRepository;

    public ResponseEntity<Object> store(ServiceDto serviceDto)
    {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setBrand(serviceDto.getMerk());
        serviceEntity.setServiceType(serviceDto.getService_type());
        serviceEntity.setComplaint(serviceDto.getComplaint());
        serviceEntity.setMotorCycleType(serviceDto.getMotorcycle_type());
        serviceEntity.setOwner(serviceDto.getOwner());
        serviceEntity.setPhoneNumber(serviceDto.getPhone_number());
        serviceEntity.setCost(serviceDto.getCost());
        serviceEntity.setStatus("WAITING");
        serviceRepository.save(serviceEntity);

        //Convert to DTO
        ServiceDto serviceDto1 = new ServiceDto();
        serviceDto1.setId(serviceEntity.getId());
        serviceDto1.setMerk(serviceEntity.getBrand());
        serviceDto1.setService_type(serviceEntity.getServiceType());
        serviceDto1.setComplaint(serviceEntity.getComplaint());
        serviceDto1.setMotorcycle_type(serviceEntity.getMotorCycleType());
        serviceDto1.setOwner(serviceEntity.getOwner());
        serviceDto1.setPhone_number(serviceEntity.getPhoneNumber());
        serviceDto1.setCost(serviceEntity.getCost());
        serviceDto1.setStatus(serviceEntity.getStatus());

        return ResponseUtil.build(
                true,
                HttpStatus.CREATED.value(),
                "Data berhasil ditambahkan",
                serviceDto1,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> getAll(String status)
    {
        List<ServiceEntity> serviceEntities = serviceRepository.findByStatus(status);
        List<ServiceDto> serviceDtoList = new ArrayList<>();

        for (ServiceEntity serviceEntity : serviceEntities) {
            ServiceDto serviceDto = new ServiceDto();
            serviceDto.setId(serviceEntity.getId());
            serviceDto.setMerk(serviceEntity.getBrand());
            serviceDto.setService_type(serviceEntity.getServiceType());
            serviceDto.setMotorcycle_type(serviceEntity.getMotorCycleType());
            serviceDto.setOwner(serviceEntity.getOwner());
            serviceDto.setComplaint(serviceEntity.getComplaint());
            serviceDto.setPhone_number(serviceEntity.getPhoneNumber());
            serviceDto.setCost(serviceEntity.getCost());
            serviceDto.setStatus(serviceEntity.getStatus());
            serviceDtoList.add(serviceDto);
        }

        return ResponseUtil.build(
                true,
                HttpStatus.OK.value(),
                "Berhasil Ditemuakn",
                serviceDtoList,
                HttpStatus.OK
        );
    }

    public ResponseEntity<Object> updateStatus(long id, String status)
    {
        Optional<ServiceEntity> serviceEntity = serviceRepository.findById(id);
        if (serviceEntity.isPresent()) {
            ServiceEntity serviceEntity1 = serviceEntity.get();
            serviceEntity1.setStatus(status);
            serviceRepository.save((serviceEntity1));

            ServiceDto serviceDto = new ServiceDto();
            serviceDto.setId(serviceEntity1.getId());
            serviceDto.setId(serviceEntity1.getId());
            serviceDto.setMerk(serviceEntity1.getBrand());
            serviceDto.setService_type(serviceEntity1.getServiceType());
            serviceDto.setMotorcycle_type(serviceEntity1.getMotorCycleType());
            serviceDto.setOwner(serviceEntity1.getOwner());
            serviceDto.setComplaint(serviceEntity1.getComplaint());
            serviceDto.setPhone_number(serviceEntity1.getPhoneNumber());
            serviceDto.setCost(serviceEntity1.getCost());
            serviceDto.setStatus(serviceEntity1.getStatus());

            return ResponseUtil.build(
                    true,
                    HttpStatus.OK.value(),
                    "Berhasil Ditemukan",
                    serviceDto,
                    HttpStatus.OK
            );
        } else {
            return ResponseUtil.build(
                    false,
                    HttpStatus.NOT_FOUND.value(),
                    "Tidak Berhasil Ditemukan",
                    null,
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
