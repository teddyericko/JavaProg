package com.example.restaurant.repository;

import com.example.restaurant.entity.Cart;
import com.example.restaurant.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByGoodsId(String goodsId);

    @Modifying
    @Transactional
    void deleteAllByGoodsId(String goodsId);
}
