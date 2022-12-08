package org.delta.account;

import com.google.inject.Guice;
import com.google.inject.Inject;
import org.delta.person.Person;
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

    @Test
    void createAccount() {
        Person p = new Person("A", "B", "1234567890");
        BaseAccount a = accountService.createAccount(AccountType.SAVING, p, 0);
        assertEquals(accountService.getAccountByNumber(a.getAccountNumber()), a);
        assertSame(accountService.getAccountByNumber(a.getAccountNumber()).getOwner(), p);
        assertTrue(accountService.getAccountByNumber(a.getAccountNumber()) instanceof SavingAccount);

        BaseAccount b = accountService.createAccount(AccountType.STUDENT, p, 0);
        assertEquals(accountService.getAccountByNumber(b.getAccountNumber()), b);
        assertTrue(accountService.getAccountByNumber(b.getAccountNumber()) instanceof StudentAccount);

        assertEquals(2, accountService.getAccounts().length);

        assertNotEquals(a.getAccountNumber(), b.getAccountNumber());

        assertNull(accountService.getAccountByNumber("a"));
    }
}