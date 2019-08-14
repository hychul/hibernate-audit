package com.hychul.hibernate.audit.revision;

import javax.persistence.Entity;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@RevisionEntity(DemoRevisionListener.class)
public class DemoRevisionEntity extends DefaultRevisionEntity {
    public String userName;
}
