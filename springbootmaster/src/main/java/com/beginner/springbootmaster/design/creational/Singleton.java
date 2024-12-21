package com.beginner.springbootmaster.design.creational;

// Đảm bảo chỉ có một thể hiện duy nhất của một lớp và
// cung cấp một cách truy cập toàn cục tới nó.

// Ex: Connection Pool, Logger, Cache, Configuration Manager
public class Singleton {
//    Double-Checked Locking
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
