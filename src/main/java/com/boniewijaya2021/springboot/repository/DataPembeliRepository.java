package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.entity.TblSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DataPembeliRepository extends JpaRepository<Pembeli, UUID>{
    @Query(value = "SELECT cast (id_pembeli as varchar) id_pembeli, nama_pembeli, jk, no_telp, alamat\n" +
            "FROM sample.tbl_pembeli where id_pembeli =:idPembeli", nativeQuery = true)
    Pembeli getPembeliByid(@Param("idPembeli") UUID idPembeli);


}
