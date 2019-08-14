package com.hychul.hibernate.audit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hychul.hibernate.audit.repository.ManyModelRepository;
import com.hychul.hibernate.audit.repository.model.ManyModel;

@Service
public class ManyModelService {

    private final ManyModelRepository manyModelRepository;

    public ManyModelService(ManyModelRepository manyModelRepository) {
        this.manyModelRepository = manyModelRepository;
    }

    public ManyModel get(Long id) {
        return manyModelRepository.findById(id).orElse(null);
    }

    @Transactional
    public ManyModel update(ManyModel entity) {
        final ManyModel patchedEntity = manyModelRepository.findById(entity.id).map(it -> patch(it, entity)).orElse(entity);
        return manyModelRepository.save(patchedEntity);
    }

    public ManyModel patch(ManyModel preEntity, ManyModel newEntity) {
        preEntity.name = newEntity.name;
        preEntity.oneModel.name = newEntity.oneModel.name;

        return preEntity;
    }
}
