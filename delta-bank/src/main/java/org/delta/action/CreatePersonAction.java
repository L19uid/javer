package org.delta.action;

import com.google.inject.Inject;
import org.delta.account.AccountService;
import org.delta.account.AccountType;
import org.delta.account.BaseAccount;
import org.delta.person.PersonFactory;
import org.delta.person.PersonService;

import java.io.InputStreamReader;
import java.util.Scanner;

public class CreatePersonAction implements Action {

    @Inject
    AccountService accountService;

    @Inject
    PersonService personService;

    @Override
    public void processAction() {
        try {
            System.out.println("Creating a new person.");
            System.out.print("Enter the first name: ");
            Scanner scanner = new Scanner(new InputStreamReader(System.in));
            String firstName = scanner.next();
            System.out.print("Enter the last name: ");
            String lastName = scanner.next();
            System.out.print("Enter the ID: ");
            String ID = scanner.next();

            this.personService.createPerson(firstName,lastName, ID);
        } catch (Throwable t) {
        }
    }
}
