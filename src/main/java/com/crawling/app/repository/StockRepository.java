package com.crawling.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crawling.app.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
