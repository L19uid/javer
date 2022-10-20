package org.delta.action;

import com.google.inject.Inject;
import org.delta.account.AccountFactory;
import org.delta.account.AccountInfoPrinterService;
import org.delta.account.BaseAccount;
import org.delta.person.Person;
import org.delta.person.PersonInfoPrintService;
import org.delta.person.PersonService;
import org.delta.storage.JsonSerializationService;

public class DetailAction implements Action {
    // constructor

    @Inject
    JsonSerializationService jsonSerializationService;

    @Inject
    PersonInfoPrintService personInfoPrintService;

    @Inject
    PersonService personService;

    @Inject
    AccountFactory accountFactory;

    @Inject
    AccountInfoPrinterService accountInfoPrinterService;

    @Override
    public void processAction() {
        try {
            for (BaseAccount account : this.accountFactory.getAccounts()){
                this.accountInfoPrinterService.printAccountInfo(account);
            }
        } catch (Throwable t) {
        }
    }
}
