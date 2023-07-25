package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.repository.DataPembeliRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class PembeliService {
    @Autowired
    private DataPembeliRepository dataPembeliRepository;

    public ResponseEntity<MessageModel> addDataPembeli(Pembeli pembeli)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try{
            dataPembeliRepository.save(pembeli);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", pembeli);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

    }
    public ResponseEntity<MessageModel> deleteDataPembeli(UUID idPembeli) {
        MessageModel msg = new MessageModel();
        try {
            Optional<Pembeli> pembeliOptional = dataPembeliRepository.findById(idPembeli);
            if (pembeliOptional.isPresent()) {
                dataPembeliRepository.deleteById(idPembeli);
                msg.setStatus(true);
                msg.setMessage("Data pembeli berhasil dihapus");
                return ResponseEntity.status(HttpStatus.OK).body(msg);
            } else {
                msg.setStatus(false);
                msg.setMessage("Data pembeli dengan ID " + idPembeli + " tidak ditemukan");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
        }
    }
}
