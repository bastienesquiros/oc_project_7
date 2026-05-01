package com.openclassroom.devops.orion.microcrm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CrudEventLogger {

    private static final Logger log = LoggerFactory.getLogger(CrudEventLogger.class);

    // ── Person ────────────────────────────────────────────────────────────────

    @HandleBeforeCreate(Person.class)
    public void onPersonBeforeCreate(Person p) {
        log.info("Creating person email={}", p.getEmail());
    }

    @HandleAfterCreate(Person.class)
    public void onPersonAfterCreate(Person p) {
        log.info("Person created id={} email={}", p.getId(), p.getEmail());
    }

    @HandleBeforeSave(Person.class)
    public void onPersonBeforeSave(Person p) {
        log.info("Updating person id={} email={}", p.getId(), p.getEmail());
    }

    @HandleAfterSave(Person.class)
    public void onPersonAfterSave(Person p) {
        log.info("Person updated id={} email={}", p.getId(), p.getEmail());
    }

    @HandleBeforeDelete(Person.class)
    public void onPersonBeforeDelete(Person p) {
        log.warn("Deleting person id={} email={}", p.getId(), p.getEmail());
    }

    @HandleAfterDelete(Person.class)
    public void onPersonAfterDelete(Person p) {
        log.warn("Person deleted id={} email={}", p.getId(), p.getEmail());
    }

    // ── Organization ──────────────────────────────────────────────────────────

    @HandleBeforeCreate(Organization.class)
    public void onOrgBeforeCreate(Organization o) {
        log.info("Creating organization name={}", o.getName());
    }

    @HandleAfterCreate(Organization.class)
    public void onOrgAfterCreate(Organization o) {
        log.info("Organization created id={} name={}", o.getId(), o.getName());
    }

    @HandleBeforeSave(Organization.class)
    public void onOrgBeforeSave(Organization o) {
        log.info("Updating organization id={} name={}", o.getId(), o.getName());
    }

    @HandleAfterSave(Organization.class)
    public void onOrgAfterSave(Organization o) {
        log.info("Organization updated id={} name={}", o.getId(), o.getName());
    }

    @HandleBeforeDelete(Organization.class)
    public void onOrgBeforeDelete(Organization o) {
        log.warn("Deleting organization id={} name={}", o.getId(), o.getName());
    }

    @HandleAfterDelete(Organization.class)
    public void onOrgAfterDelete(Organization o) {
        log.warn("Organization deleted id={} name={}", o.getId(), o.getName());
    }
}
