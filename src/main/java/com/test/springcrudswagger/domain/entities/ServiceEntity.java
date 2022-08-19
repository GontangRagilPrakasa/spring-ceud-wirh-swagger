package com.test.springcrudswagger.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "Services")
public class ServiceEntity {
    public ServiceEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "motorcycle_type")
    private String motorCycleType;

    @Column(name = "owner")
    private String owner;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "cost")
    private int cost;

    @Column(name = "status", columnDefinition="varchar(255) default 'WAITING'")
    private String status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMotorCycleType() {
        return motorCycleType;
    }

    public void setMotorCycleType(String motorCycleType) {
        this.motorCycleType = motorCycleType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
