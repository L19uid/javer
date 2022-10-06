package org.delta.person;

import org.delta.person.serialization.PersonSerializationObject;

import javax.inject.Singleton;

@Singleton
public class PersonFactory {

    public Person createPerson(String name, String lastName) {
        return new Person(name, lastName);
    }

    public Person createPersonFromSerializationObject(PersonSerializationObject personSerializationObject) {
        return createPerson(personSerializationObject.firstName, personSerializationObject.lastName);
    }
}
