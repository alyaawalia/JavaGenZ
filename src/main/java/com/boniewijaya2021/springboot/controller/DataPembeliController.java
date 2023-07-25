package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.service.PembeliService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pembeli")
public class DataPembeliController {

    @Autowired
    private PembeliService pembeliService;

    @PostMapping("/post/pembeli")
    private ResponseEntity<MessageModel> addSales(@RequestBody Pembeli pembeli) {
        ResponseEntity responseEntity = pembeliService.addDataPembeli(pembeli);
        return responseEntity;
    }
    @DeleteMapping("/delete/pembeli")
    private ResponseEntity<MessageModel> addSales(@RequestBody UUID idPembeli) {
        ResponseEntity responseEntity = pembeliService.deleteDataPembeli(idPembeli);
        return responseEntity;
    }
}
