package com.spacex.flamingo.service;

public class ExampleService {
    private String prefix;
    private String suffix;

    public ExampleService() {
    }

    public ExampleService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String wrap(String content) {
        return prefix + content + suffix;
    }
}
