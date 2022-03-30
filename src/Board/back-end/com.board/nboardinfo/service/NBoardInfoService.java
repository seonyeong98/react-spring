package com.solarpos.nboardinfo.service;

import com.solarpos.nboardinfo.domain.NBoardInfo;
import com.solarpos.nboardinfo.model.dto.NBoardInfoDto;
import com.solarpos.nboardinfo.repository.NBoardInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static com.solarpos.base.model.mapper.ModelMapper.map;

@Service
public class NBoardInfoService {

    private NBoardInfoRepository nBoardInfoRepository;

    public NBoardInfoService(NBoardInfoRepository nBoardInfoRepository) {
        this.nBoardInfoRepository = nBoardInfoRepository;
    }


    @Transactional
    public void createForm(NBoardInfo form) {
        System.out.println("@@@");
        System.out.println(form.toString());
        nBoardInfoRepository.save(form);
        /*
        NBoardInfo entity1 = new NBoardInfo();
        entity1.setAddress(form.getAddress());
        entity1.setEmail(form.getEmail());
        entity1.setName(form.getName());
        nBoardInfoRepository.save(entity1);
        */

        //NBoardInfo entity2 = map(form, NBoardInfo.class);

    }

    @Transactional
    public void deleteForm(Integer id) {
        System.out.println("##################");
        System.out.println(id);

        Optional<NBoardInfo> entity = nBoardInfoRepository.findById(id);
        if (entity.isPresent()) {
            //NBoardInfo selectEntity= entity.get();
            //selectEntity.setName(form.getName());
            //selectEntity.setAddress(form.getAddress());
            //selectEntity.setEmail(form.getEmail());
            nBoardInfoRepository.delete(entity.get());
        } else {
            System.out.println("데이터가 존재하지 않습니다. id : " + id);
        }

        /*
        Integer id = form.getId();
        Optional<NBoardInfo> entity = nBoardInfoRepository.findById(id);
        if (entity.isPresent()) {
            NBoardInfo selectEntity= entity.get();
            selectEntity.setName(form.getName());
            selectEntity.setAddress(form.getAddress());
            selectEntity.setEmail(form.getEmail());
            nBoardInfoRepository.delete(selectEntity);
        } else {
            System.out.println("데이터가 존재하지 않습니다. id : " + id);
        }
        */
    }

    @Transactional
    public void updateForm(NBoardInfoDto form) {
        System.out.println("@@@");
        System.out.println(form.toString());

        //int, Integer, float, Double, Long, String
        Integer id = form.getId();
        Optional<NBoardInfo> entity = nBoardInfoRepository.findById(id);
        if (entity.isPresent()) {
            NBoardInfo selectEntity = entity.get();
            selectEntity.setName(form.getName());
            selectEntity.setAddress(form.getAddress());
            selectEntity.setEmail(form.getEmail());
            nBoardInfoRepository.save(selectEntity);
        } else {
            System.out.println("데이터가 존재하지 않습니다. id : " + id);
            //throw new Exception("eddfdfef");
        }

        boolean a = true;
        if (a) {
        } else {
        }

        /*
        NBoardInfo entity1 = new NBoardInfo();
        entity1.setAddress(form.getAddress());
        entity1.setEmail(form.getEmail());
        entity1.setName(form.getName());
        nBoardInfoRepository.save(entity1);
        */

    }


}
