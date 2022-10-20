package org.delta.storage;

import org.delta.account.BaseAccount;

public interface StringSerializationService {
    String serialize(Object object);
    <T> T deserialize(String data, Class<T> type);
    BaseAccount deserializeAccount(String data);
    void serializeAccount(BaseAccount data);
}
