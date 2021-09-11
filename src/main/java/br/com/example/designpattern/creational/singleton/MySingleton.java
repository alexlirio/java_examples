package br.com.example.designpattern.creational.singleton;

/**
 * Singleton:
 * Recognizable by creational methods returning the same instance (usually of itself) every time.
 */
public class MySingleton {

	private static MySingleton instance;

	private String msg;

    private MySingleton() {
        msg = "This is my Singleton message";
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    public String getMsg() {
        return msg;
    }
}
