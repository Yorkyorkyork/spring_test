package com.example.demo.repository;

import com.example.demo.model.EmailDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailDTO, String> {

    Integer countByEmailAndStatus(String email, Integer status);

    EmailDTO findFirstByEmailAndVerifyAndStatus(String email, String verify, Integer status);
}
