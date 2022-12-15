package org.delta.account;

import com.google.inject.Guice;
import com.google.inject.Inject;
import org.delta.person.Person;
import org.delta.account.AccountFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    void testInjectbaseService() throws Exception{
        AccountService accountService = new AccountService();
        assertNotNull(accountService);
        assertInstanceOf(AccountService.class, accountService);
    }

    @Inject
    AccountService accountService;

    @Inject
    AccountFactory accountFactory;

    @Test
    void createAccount() {
        Person p = new Person("A", "B", "1234567890");
        SavingAccount a = accountFactory.createSavingAccount( "a" ,p, 0f);
        assertEquals(accountService.getAccountByNumber(a.getAccountNumber()), a);
        assertSame(accountService.getAccountByNumber(a.getAccountNumber()).getOwner(), p);
        assertTrue(accountService.getAccountByNumber(a.getAccountNumber()) instanceof SavingAccount);

        StudentAccount b = accountFactory.createStudentAccount( "a", p, 0f);
        assertEquals(accountService.getAccountByNumber(b.getAccountNumber()), b);
        assertTrue(accountService.getAccountByNumber(b.getAccountNumber()) instanceof StudentAccount);

        assertEquals(2, accountService.getAccounts().length);

        assertNotEquals(a.getAccountNumber(), b.getAccountNumber());

        assertNull(accountService.getAccountByNumber("a"));
    }
}