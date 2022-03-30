package com.solarpos.nboardinfo.repository;

import com.solarpos.nboardinfo.domain.NBoardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface NBoardInfoRepository extends JpaRepository<NBoardInfo, Integer> {
    @Query(value = "SELECT i FROM NBoardInfo i WHERE i.name LIKE %:keyword% OR i.address LIKE %:keyword% OR i.email LIKE %:keyword%"
    )
    List<NBoardInfo> findAllSearch(String keyword);
}

