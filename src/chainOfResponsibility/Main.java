package chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender(new MessagePrinter());
        messageSender.sendMessage("hello world");

        MessageHandler messageHandler = new MessageHandlerDigitsFilter(new MessageHandlerExclamationMark(new MessageHandlerPrinter(null)));
        messageHandler.handle("hello world");
    }
}
class MessageSender {
    MessagePrinter messagePrinter;

    public MessageSender(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public void sendMessage(String message) {
        messagePrinter.printMessage(message);
    }
}
class MessagePrinter {
    public void printMessage(String message) {
        if(!message.matches(".*\\d.*")){
            System.out.println(message + "!");
        }
    }
}
abstract class MessageHandler {

    MessageHandler handler;

    public MessageHandler(MessageHandler handler) {
        this.handler = handler;
    }

    abstract void handle(String message);
}
class MessageHandlerPrinter extends MessageHandler {
    public MessageHandlerPrinter(MessageHandler handler) {
        super(handler);
    }
    @Override
    void handle(String message) {
        System.out.println(message);
    }
}
class MessageHandlerExclamationMark extends MessageHandler {
    public MessageHandlerExclamationMark(MessageHandler handler) {
        super(handler);
    }
    @Override
    void handle(String message) {
        handler.handle(message + "!");
    }
}
class MessageHandlerDigitsFilter extends MessageHandler {
    public MessageHandlerDigitsFilter(MessageHandler handler) {
        super(handler);
    }
    @Override
    void handle(String message) {
        if(!message.matches(".*\\d.*")){
            handler.handle(message);
        }
    }
}