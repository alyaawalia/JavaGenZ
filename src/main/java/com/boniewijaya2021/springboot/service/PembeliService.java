package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.repository.DataPembeliRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PembeliService {
    @Autowired
    private DataPembeliRepository dataPembeliRepository;

    public ResponseEntity getDataPembeli(UUID idPembeli) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            Pembeli data = dataPembeliRepository.getPembeliByid(idPembeli);
            if(data.getIdPembeli() ==null) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Success");
                result.put("data", data);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }

        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }
    }

    public ResponseEntity<MessageModel> addDataPembeli(List<Pembeli> pembelis) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            List<Pembeli> param = pembelis;
            List<Pembeli> objectSave = new ArrayList<>();
            String pembeliResponSave ="Tersimpan";

            for(Pembeli map: pembelis ) {
                Pembeli object1 = new Pembeli();
                object1.setNamaPembeli(map.getNamaPembeli());
                object1.setAlamat(map.getAlamat());
                object1.setJk(map.getJk());
                object1.setNoTelp(map.getNoTelp());
                objectSave.add(object1);
            }

            dataPembeliRepository.saveAll(objectSave);
            //dataPembeliRepository.save(pembeli);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", pembeliResponSave);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
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
