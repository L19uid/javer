package org.delta.storage;

import com.google.inject.Singleton;
import org.delta.io.IO;

import java.io.IOException;

@Singleton
public class FileSystemStorage implements Storage {

    @Override
    public void save(String dataToSave, String path) {
        try{
            IO.writeFile(path, dataToSave);
    }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String read(String path)
    {
        try{
            return IO.readFile(path);
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
