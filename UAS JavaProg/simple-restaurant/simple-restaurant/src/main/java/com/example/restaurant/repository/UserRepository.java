package com.example.restaurant.repository;

import com.example.restaurant.entity.Goods;
import com.example.restaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository   extends JpaRepository<User, Long> {
}
