package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Account, Long> {

    // 使用自動化命名規則進行條件搜尋
	Account findByEmail(String email); 

    // 使用自動化命名規則進行條件搜尋(多條件)
    Account findByEmailAndPassword(String email, String password);

    // 自定義SQL查詢
    @Query(value = "select * from customer where email = ?1", nativeQuery = true)
    Account queryByEmail(String email);

}
