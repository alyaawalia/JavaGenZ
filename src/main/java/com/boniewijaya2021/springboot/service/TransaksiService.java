package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.entity.Transaksi;
import com.boniewijaya2021.springboot.repository.DataTransaksiRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransaksiService {

    @Autowired
    private DataTransaksiRepository dataTransaksiRepository;

    public ResponseEntity<MessageModel> addDataTransaksi (Transaksi transaksi)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try{
            dataTransaksiRepository.save(transaksi);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", transaksi);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

}
