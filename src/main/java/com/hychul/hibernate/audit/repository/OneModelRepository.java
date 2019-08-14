package com.hychul.hibernate.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hychul.hibernate.audit.repository.model.OneModel;

public interface OneModelRepository extends JpaRepository<OneModel, Long> {
}
