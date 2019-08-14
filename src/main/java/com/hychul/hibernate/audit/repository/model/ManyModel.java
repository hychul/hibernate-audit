package com.hychul.hibernate.audit.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Audited
//@AuditOverride
public class ManyModel extends BaseModel {
    @Id
    public Long id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    public OneModel oneModel;

    public ManyModel() {

    }

    public ManyModel(Long id, String name, OneModel oneModel) {
        this.id = id;
        this.name = name;
        this.oneModel = oneModel;
    }
}
