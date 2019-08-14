package com.hychul.hibernate.audit.repository.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.envers.Audited;

@MappedSuperclass
@Audited
public class BaseModel implements Serializable {
    public Instant createdTime;

    public Instant modifiedTime;

    @PrePersist
    public void onCreate() {
        System.out.println("*** onCreate");
        createdTime = Instant.now();
    }

    @PreUpdate
    public void onUpdate() {
        System.out.println("*** onUpdate");
        modifiedTime = Instant.now();
    }
}
