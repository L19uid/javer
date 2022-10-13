package org.delta.storage;

import com.google.gson.Gson;
import com.google.inject.Singleton;

@Singleton
public class JsonSerializationService implements StringSerializationService {
    private Gson gson = new Gson();

    public JsonSerializationService() {
        this.gson = new Gson();
    }

    @Override
    public String serialize(Object object) {
        return this.gson.toJson(object);
    }

    @Override
    public <T> T deserialize(String data, Class<T> type) {
        return this.gson.fromJson(data, type);
    }
}
