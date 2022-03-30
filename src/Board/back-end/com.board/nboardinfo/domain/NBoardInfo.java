package com.solarpos.nboardinfo.domain;


import com.solarpos.nboardinfo.model.dto.NBoardInfoDto;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@DynamicUpdate
@Builder
@Entity
@Table(name = "n_board_info")
public class NBoardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NBoardInfo nBoardInfo = (NBoardInfo) o;
        return Objects.equals(id, nBoardInfo.id) &&
                Objects.equals(name, nBoardInfo.name) &&
                Objects.equals(address, nBoardInfo.address) &&
                Objects.equals(email, nBoardInfo.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, address, email);
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


}

