package org.delta.action;

import com.google.inject.Inject;
import org.delta.account.AccountFactory;
import org.delta.account.BaseAccount;
import org.delta.storage.JsonSerializationService;

public class SaveBankAction implements Action {
    @Inject
    JsonSerializationService jsonSerializationService;

    @Inject
    AccountFactory accountFactory;

    @Override
    public void processAction() {
        for(BaseAccount account : this.accountFactory.getAccounts()) {
            try {
                this.jsonSerializationService.serializeAccount(account);
            } catch (Exception e) {
            }
        }
    }
}
