package com.example.demo.serializable_demo;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HessianSerializer implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HessianOutput output = new HessianOutput(outputStream);
        try {
            output.writeObject(obj);
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        HessianInput input = new HessianInput(inputStream);
        try {
            return (T) input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
