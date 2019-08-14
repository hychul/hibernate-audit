package com.hychul.hibernate.audit.repository.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Audited
public class OneModel extends BaseModel {
    @Id
    public Long id;

    public String name;

    @OneToMany(mappedBy = "oneModel")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED) // to @NotAudited
    public Set<ManyModel> manyModelList;

    public OneModel() {

    }

    public OneModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
