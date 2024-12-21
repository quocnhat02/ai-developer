package com.beginner.springbootmaster.design.creational;

// Đảm bảo chỉ có một thể hiện duy nhất của một lớp và
// cung cấp một cách truy cập toàn cục tới nó.

// Ex: Connection Pool, Logger, Cache, Configuration Manager
public class Singleton {

    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
