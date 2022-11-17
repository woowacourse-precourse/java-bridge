package bridge.view.console;

import bridge.view.Message;

public class Printer {
    public static void print(Message message) {
        System.out.print(message.text());
    }

    public static void printLine(Message message) {
        System.out.println(message.text());
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void printLine(String text) {
        System.out.println(text);
    }
}
