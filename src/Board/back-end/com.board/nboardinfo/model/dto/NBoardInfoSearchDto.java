package com.solarpos.nboardinfo.model.dto;


import com.solarpos.nboardinfo.domain.NBoardInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NBoardInfoSearchDto {
    private Integer id;
    private String name;
    private String address;
    private String email;

}
