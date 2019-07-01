package singleton;

import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class SingletonWrapper {
    Singleton singleton;
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException, NoSuchFieldException {
        SingletonWrapper singletonWrapper = new SingletonWrapper();
        SingletonWrapper singletonWrapper2 = new SingletonWrapper();
        Thread thread = new Thread(() -> {
            try {
                singletonWrapper.singleton = Singleton.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                singletonWrapper2.singleton = Singleton.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(singletonWrapper.singleton == singletonWrapper2.singleton);

        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
        MySingleton mySingleton = MySingleton.INSTANCE;
        MySingleton mySingleton2 = MySingleton.INSTANCE;
        System.out.println(mySingleton == mySingleton2);

        try(FileOutputStream file = new FileOutputStream("test.doc");
            ObjectOutputStream out = new ObjectOutputStream(file);
            FileInputStream file2 = new FileInputStream("test.doc");
            ObjectInputStream in = new ObjectInputStream(file2)) {
            out.writeObject(singleton);
            singleton = (Singleton)in.readObject();
            System.out.println(singleton == singleton2);

            out.writeObject(mySingleton);
            mySingleton = (MySingleton)in.readObject();
            System.out.println(mySingleton == mySingleton2);
        }

        Constructor<Singleton> constructor = (Constructor<Singleton>) Singleton.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        Singleton singleton3 = constructor.newInstance();
        System.out.println(singleton == singleton3);

        Constructor<MySingleton> constructor2 = (Constructor<MySingleton>) MySingleton.class.getDeclaredConstructors()[0];
        constructor2.setAccessible(true);
//        MySingleton mySingleton3 = constructor2.newInstance();
//        System.out.println(mySingleton == mySingleton3);

        ClassLoader classLoader = Singleton.class.getClassLoader();
        Class singletonClassLoader =  (classLoader.loadClass("singleton.Singleton"));
        Constructor<Singleton> constructor3 = (Constructor<Singleton>) singletonClassLoader.getDeclaredConstructors()[0];
        constructor3.setAccessible(true);
        Singleton singletonFromClassLoader = constructor3.newInstance();
        System.out.println(singleton == singletonFromClassLoader);

        ClassLoader myClassLoader = MySingleton.class.getClassLoader();
        Class mySingletonClassLoader =  (myClassLoader.loadClass("singleton.MySingleton"));
        MySingleton mySingleton4 = (MySingleton)mySingletonClassLoader.getEnumConstants()[0];
        System.out.println(mySingleton == mySingleton4);


        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        Singleton singleton4 = (Singleton)unsafe.allocateInstance(Singleton.class);
        System.out.println(singleton == singleton4);
    }
}
class StaticSingleton {
    private static int i;
    public static int getI() {
        return i;
    }
    public static void setI(int newI) {
        i = newI;
    }
}
class Singleton implements Serializable {
    private volatile static Singleton singleton;
    private Singleton() { }
    public static Singleton getInstance() throws InterruptedException {
//    public synchronized static Singleton getInstance() throws InterruptedException {
//        synchronized(Singleton.class) {
            if (singleton == null) {
                synchronized(Singleton.class) {
                    if (singleton == null) {
                        System.out.println(Thread.currentThread().getName());
                        if (Thread.currentThread().getName().equals("Thread-0")) Thread.sleep(500);
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
//        }
    }
}
enum MySingleton implements Serializable {
    INSTANCE;
    private int i;
    public int getI() { return i; }
    public void setI(int i) { this.i = i; }
}