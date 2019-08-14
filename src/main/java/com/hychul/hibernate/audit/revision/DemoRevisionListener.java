package com.hychul.hibernate.audit.revision;

import java.io.Serializable;

import org.hibernate.envers.EntityTrackingRevisionListener;
import org.hibernate.envers.RevisionType;

public class DemoRevisionListener implements EntityTrackingRevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        DemoRevisionEntity demoRevisionEntity = (DemoRevisionEntity) revisionEntity;

        demoRevisionEntity.userName = "TEST";
    }

    @Override
    public void entityChanged(Class entityClass, String entityName, Serializable entityId, RevisionType revisionType, Object revisionEntity) {
        System.out.println("*** revision entity changed");
    }
}