package com.example.demo.serializable_demo;

import java.io.*;

public class JavaSerializerWithFile implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("user")));
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("user")));
            return (T) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
