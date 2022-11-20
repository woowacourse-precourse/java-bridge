package bridge.util;

public class Console {
    public static String readLine(String message) {
        printLine(message);
        return readLine();
    }

    public static void printLine(String message) {
        System.out.println(message);
    }

    public static String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
