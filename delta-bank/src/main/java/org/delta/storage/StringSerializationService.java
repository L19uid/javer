package org.delta.storage;

public interface StringSerializationService {
    String serialize(Object object);
    <T> T deserialize(String data, Class<T> type);
}
