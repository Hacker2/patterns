package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ProxyReader();
        reader.readData("input");

        InvocationHandler invocationHandler = new ReaderInvocationHandler();
        Object proxy = Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{Reader.class}, invocationHandler);
        ((Reader)proxy).readData("hello world");
    }
}
interface Reader {
    String readData(String inputDate);
}
class MyReader implements Reader {
    public String readData(String inputDate) {
        return "output data";
    }
}
class ProxyReader extends MyReader {
    @Override
    public String readData(String inputDate) {
        System.out.println("You have sent: " + inputDate);
        String outputData = super.readData(inputDate);
        System.out.println("You have get: " + outputData);
        return outputData;
    }
}
//class ReaderInvocationHandler extends MyReader implements InvocationHandler {
class ReaderInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("you have input: " + args[0]);
//        Object result = method.invoke(this, args);
        Object result = method.invoke(new MyReader(), args);
        System.out.println("You have get: " + result);
        return result;
    }
}