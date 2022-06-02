package com.example.restaurant.repository;

import com.example.restaurant.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository  extends JpaRepository<Goods, Long> {
    List<Goods> findAllByCategory(String category);
}
