package com.b2camp.Testt.repository;

import com.b2camp.Testt.controller.BukuContoller;
import com.b2camp.Testt.model.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BukuRepository extends JpaRepository<Buku, Long> {

}
