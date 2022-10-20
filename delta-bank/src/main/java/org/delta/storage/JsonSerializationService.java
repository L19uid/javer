package org.delta.storage;

import com.google.gson.Gson;
import com.google.inject.Singleton;
import org.delta.account.AccountFactory;
import org.delta.account.BaseAccount;
import org.delta.account.serialization.AccountJsonSerializationFactory;
import org.delta.account.serialization.AccountJsonSerializationObject;

import javax.inject.Inject;

@Singleton
public class JsonSerializationService implements StringSerializationService {

    @Inject
    JsonSerializationService jsonSerializationService;

    @Inject
    FileSystemStorage fileSystemStorage;

    @Inject
    AccountFactory accountFactory;

    @Inject
    AccountJsonSerializationFactory accountJsonSerializationFactory;

    private Gson gson = new Gson();

    public JsonSerializationService() {
        this.gson = new Gson();
    }

    @Override
    public String serialize(Object object) {
        return this.gson.toJson(object);
    }

    @Override
    public BaseAccount deserializeAccount(String data) {
        String jsonFile = fileSystemStorage.read(data);

        AccountJsonSerializationObject readAccount = jsonSerializationService.deserialize(jsonFile, AccountJsonSerializationObject.class);
        BaseAccount account = accountFactory.createFactoryFromJsonSerializationObject(readAccount);
        accountFactory.addAccount(account);
        return account;
    }


    @Override
    public void serializeAccount(BaseAccount data) {
        AccountJsonSerializationObject jsonAcc = accountJsonSerializationFactory.createFromBaseAccount(data);

        String json = jsonSerializationService.serialize(jsonAcc);

        fileSystemStorage.save(json,"account.json");
    }

    public <T> T deserialize(String data, Class<T> type) {
        return this.gson.fromJson(data, type);
    }
}
