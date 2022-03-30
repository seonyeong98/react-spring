package com.solarpos.nboardinfo.model.dto;


import com.solarpos.nboardinfo.domain.NBoardInfo;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Getter
@Setter
@ToString


public class NBoardInfoDto {

    private Integer id;
    private String name;
    private String address;
    private String email;

    public NBoardInfoDto(Integer id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;

    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getEmail(){
        return email;
    }



    public NBoardInfo toEntity() {
        return NBoardInfo.builder()
                .name(name)
                .address(address)
                .email(email)
                .build();
    }

    @Override
    public String toString() {
        return "NBoardInfoDto{" +
                "이름='" + name + '\'' +
                ", 주소='" + address + '\''+
                ", 메일='" + email + '\''+
                '}';
    }
}


