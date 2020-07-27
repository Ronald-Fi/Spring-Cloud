package com.example.demo.serializable_demo;

import com.alibaba.fastjson.JSON;

public class FastJsonSerializer implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return (T) JSON.parseObject(new String(data));
    }
}
