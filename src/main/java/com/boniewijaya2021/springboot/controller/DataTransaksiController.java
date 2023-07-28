package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.entity.Transaksi;
import com.boniewijaya2021.springboot.pojo.ParamInsertTransaksi;
import com.boniewijaya2021.springboot.service.TransaksiService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaksi")
public class DataTransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @PostMapping("/post/transaksi")
    private ResponseEntity<MessageModel> addSales(@RequestBody ParamInsertTransaksi transaksi) {
        ResponseEntity responseEntity = transaksiService.addDataTransaksi(transaksi);
        return responseEntity;
    }
}
