package com.example.rest.message;

import com.example.rest.domain.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Person 自描述消息处理
 */
public class PropertiesPersonHttpMessageConverter extends AbstractHttpMessageConverter<Person> {
    public PropertiesPersonHttpMessageConverter() {
        //自定义类型
        super(MediaType.valueOf("application/properties+person"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        //必须是子类
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 将请求中的Properties内容转化成Person对象
     *
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = inputMessage.getBody();
        Properties properties = new Properties();
        //将请求中的内容转换成Properties
        properties.load(new InputStreamReader(inputStream, getDefaultCharset()));
        //将Properties内容转化到Person对象中
        Person person = new Person();
        person.setId(Long.valueOf(properties.getProperty("person.id")));
        person.setName(properties.getProperty("person.name"));
        return person;
    }

    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = outputMessage.getBody();
        Properties properties = new Properties();
        properties.setProperty("person.id", String.valueOf(person.getId()));
        properties.setProperty("person.name", person.getName());
        //写
        properties.store(new OutputStreamWriter(outputStream, getDefaultCharset()), "Written by web server");
    }
}
