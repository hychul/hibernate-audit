package com.hychul.hibernate.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hychul.hibernate.audit.repository.model.ManyModel;

public interface ManyModelRepository extends JpaRepository<ManyModel, Long> {
}
