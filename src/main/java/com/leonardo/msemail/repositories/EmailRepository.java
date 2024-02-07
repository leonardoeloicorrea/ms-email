package com.leonardo.msemail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.msemail.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
