package org.delta.action;


import org.delta.account.BaseAccount;
import org.delta.storage.JsonSerializationService;
import org.delta.storage.StringSerializationService;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class LoadBankAction implements Action {
    @Inject
    private StringSerializationService jsonSerializationService;


    String path = "";
    String name = "account.json";


    @Override
    public void processAction() {
        try {
            this.jsonSerializationService.deserializeAccount(name);
        } catch (Exception e) {
            throw new RuntimeException("Invalid bank name/Path supplied");
        }
    }
}
