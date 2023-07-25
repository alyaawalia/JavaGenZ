package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataTransaksiRepository extends JpaRepository<Transaksi, UUID> {
}
