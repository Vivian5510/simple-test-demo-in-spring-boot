package com.rosy.jacksontestdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        System.out.println("isSuccess 被调用了");
        return this.code == 200;
    }

    private boolean isError() {
        return this.code == 200;
    }

    @JsonProperty("greet")
    public String greet() {
        System.out.println("Hello");
        return "Hello";
    }
}
