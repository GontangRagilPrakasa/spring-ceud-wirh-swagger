package com.test.springcrudswagger.repository;

import com.test.springcrudswagger.domain.entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
        List<ServiceEntity> findByStatus(String status);


}