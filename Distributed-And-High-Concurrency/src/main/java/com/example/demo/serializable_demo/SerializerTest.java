package com.example.demo.serializable_demo;

public class SerializerTest {
    public static void main(String[] args) {
        JavaSerializerWithFile serializer = new JavaSerializerWithFile();
        User user = new User();
        user.setAge(18);
        user.setName("Ron");
        //serializer.serialize(user);
        serializer.deserialize(null, null);
    }
}
