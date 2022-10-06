package org.delta.person.serialization;

import com.google.inject.Singleton;
import org.delta.person.Person;

@Singleton
public class PersonSerializationObjectFactory {

        public PersonSerializationObject createFromPerson(Person person) {
            PersonSerializationObject personSerializationObject = new PersonSerializationObject();
            personSerializationObject.firstName = person.getFirstName();
            personSerializationObject.lastName = person.getLastName();

            return personSerializationObject;
        }
}
