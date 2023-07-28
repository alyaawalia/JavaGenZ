package com.boniewijaya2021.springboot.pojo;

import com.boniewijaya2021.springboot.entity.Barang;
import com.boniewijaya2021.springboot.entity.Supplier;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParamInsertTransaksi {

    private String namaBarang;
    private Integer harga;
    private Integer stok;
    private Barang barang;
    private Supplier supplier;

}