package com.openclassroom.devops.orion.microcrm;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.polak.springboot.datafixtures.DataFixture;
import ro.polak.springboot.datafixtures.DataFixtureSet;

@Component
public class InitialDataFixture implements DataFixture {

    private static final Logger log = LoggerFactory.getLogger(InitialDataFixture.class);

    @Autowired
    private final PersonRepository personRepository = null;

    @Autowired
    private final OrganizationRepository organizationRepository = null;

    @Override
    public boolean canBeLoaded() {
        return personRepository.count() == 0;
    }

    @Override
    public DataFixtureSet getSet() {
        return DataFixtureSet.DICTIONARY;
    }

    @Override
    public void load() {
        log.info("Loading initial data fixtures");

        Person jdoe = new Person("John", "Doe", "jdoe@example.net");

        Organization orionInc = new Organization();
        orionInc.setName("Orion Incorporated");
        orionInc.addPerson(jdoe);

        organizationRepository.saveAll(Arrays.asList(orionInc));
        log.info("Initial data fixtures loaded: 1 organization, 1 person");
    }

}