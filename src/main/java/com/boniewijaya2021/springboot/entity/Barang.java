package com.boniewijaya2021.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_barang", schema = "sample")

public class Barang {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_barang")
    private UUID idBarang;

    @Column(name = "nama_barang", length = 20, nullable = false)
    private String namaBarang;

    @Column(name = "harga")
    private UUID harga;

    @Column(name = "stok")
    private UUID stok;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier suplier;
}
