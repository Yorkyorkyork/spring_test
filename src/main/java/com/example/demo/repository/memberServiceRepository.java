package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Account;

public interface memberServiceRepository extends JpaRepository<Account, Long>{
	Account findByEmail(String email);
	
	@Query(value = "select * from customer where email = ?1", nativeQuery = true)
    Account queryByEmail(String email);

	Account findByEmailAndPassword(String email, String password);

	Account findByPassword(String password);

	
	//Account findByAccountAndPassword(String account , String password);

	//Account findByAccountToEmail(String email);
}
