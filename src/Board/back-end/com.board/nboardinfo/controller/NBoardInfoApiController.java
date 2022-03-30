package com.solarpos.nboardinfo.controller;

import com.solarpos.nboardinfo.domain.NBoardInfo;
import com.solarpos.nboardinfo.model.dto.NBoardInfoDto;
import com.solarpos.nboardinfo.model.dto.NBoardInfoSearchDto;
import com.solarpos.nboardinfo.repository.NBoardInfoRepository;
import com.solarpos.nboardinfo.service.NBoardInfoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@ResponseBody
@RestController //api에서 JSON데이터로 소통
@RequestMapping("/api/board-info")
public class NBoardInfoApiController {

    private final NBoardInfoRepository nBoardInfoRepository;
    private final NBoardInfoService nBoardInfoService;

    @GetMapping
    public ResponseEntity<List<NBoardInfo>> findAll() {

        List<NBoardInfo> entity = nBoardInfoRepository.findAll();
        String a = "1";
        if (a != "1") {
        }
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NBoardInfo> findById(@PathVariable Integer id) {
        //System.out.println(id);
        Optional<NBoardInfo> entity = nBoardInfoRepository.findById(id);
        //System.out.println(entity.get().getName());
        return ResponseEntity.ok(entity.get());
    }


//파라미터로 받아오는 방법
//    @GetMapping("/test")
//    public ResponseEntity<NBoardInfo> findById(@RequestParam("id") Integer id) {
//        System.out.println("@@@@@@@@@@@");
//        System.out.println(id);
//        Optional<NBoardInfo>entity = nBoardInfoRepository.findById(id);
//        return ResponseEntity.ok(entity.get());
//    }

    @GetMapping("/search")
    public ResponseEntity<List<NBoardInfo>> search(HttpServletRequest request) {
        String keyword = request.getParameter("keyword");
        System.out.println(keyword);
        List<NBoardInfo> entity = nBoardInfoRepository.findAllSearch(keyword);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/search-body")
    public ResponseEntity<List<NBoardInfo>> searchBody(NBoardInfoSearchDto search) {
        String name = search.getName();
        String address = search.getAddress();
        System.out.println(address);
        System.out.println(name);
        //List<NBoardInfo> entity = nBoardInfoRepository.findAllSearch(keyword);
        //return ResponseEntity.ok(entity);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/example")
    public String newNBoardInfoForm()throws Exception {
        return "/example";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") Integer id) {
        System.out.println(id);
        nBoardInfoService.deleteForm(id);

//    public ResponseEntity<NBoardInfo> findById(@PathVariable Integer id) {
//        //System.out.println(id);
//        Optional<NBoardInfo> entity = nBoardInfoRepository.findById(id);
//        //System.out.println(entity.get().getName());
//        return ResponseEntity.ok(entity.get());
//    }

        return "삭제완료";
}


    @PostMapping("/example") //form 데이터 받기
    public String createForm(@RequestBody NBoardInfo form){
        System.out.println(form.toString());
        nBoardInfoService.createForm(form);
//
//        NBoardInfo nBoardInfo = form.toEntity();
//        System.out.println(nBoardInfo.toString());
//        NBoardInfo saved = nBoardInfoRepository.save(nBoardInfo);
//        System.out.println(saved.toString());

        return "saved";
    }

    @PatchMapping("/example")
    public String updateForm(@RequestBody NBoardInfoDto form){
        System.out.println(form.toString());
        nBoardInfoService.updateForm(form);

        return "saved";
    }

}


