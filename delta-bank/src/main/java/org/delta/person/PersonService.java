package org.delta.person;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class PersonService {
    private final Map<String, Person> persons = new HashMap<>();

    @Inject
    private PersonFactory personFactory;

    public Person createPerson(String firstName, String lastName, String ID) {;
        Person person = personFactory.createPerson(firstName, lastName, ID);
        persons.put(person.getID(), person);
        return person;
    }

    public Person findPersonByID(String personId) {
        return persons.get(personId);
    }

    public Person findPersonByName(String firstName, String lastName) {
        for (Person person : persons.values()) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public Person[] getAllPersons() {
        return persons.values().toArray(new Person[0]);
    }
}