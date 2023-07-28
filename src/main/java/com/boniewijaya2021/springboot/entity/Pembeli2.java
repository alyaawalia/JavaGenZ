package com.boniewijaya2021.springboot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

public class Pembeli2 {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_pembayaran")
    private UUID idPembayaran;

    @Column(name = "tgl_bayar")
    private Date tglBayar;

    @Column(name = "total_bayar")
    private UUID totalBayar;

    @Column
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;
}
