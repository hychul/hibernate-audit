package com.hychul.hibernate.audit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hychul.hibernate.audit.repository.model.OneModel;
import com.hychul.hibernate.audit.repository.OneModelRepository;

@Service
public class OneModelService {

    private OneModelRepository oneModelRepository;

    public OneModelService(OneModelRepository oneModelRepository) {
        this.oneModelRepository = oneModelRepository;
    }

    public OneModel get(Long id) {
        return oneModelRepository.findById(id).orElse(null);
    }

    @Transactional
    public OneModel update(OneModel oneModel) {
        return oneModelRepository.save(oneModel);
    }
}
