package com.experion.mainbackend.controller;

import com.experion.mainbackend.entity.Manager;
import com.experion.mainbackend.helper.Helper;
import com.experion.mainbackend.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("*/managers/upload")

    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            //true

            this.managerService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


//    @GetMapping("*/managers")
//    public List<Manager> getAllManagers() {
//        return this.managerService.getAllManagers();
//    }




}
