package com.example.demo.serializable_demo;

import com.thoughtworks.xstream.XStream;

public class XStreamSerializer implements ISerializer {

    XStream xStream = new XStream();

    @Override
    public <T> byte[] serialize(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return (T) xStream.fromXML(new String(data));
    }
}
