package bridge.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int readBridgeSize() {
        final String bridgeSize = readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private static void validateBridgeSize(final String bridgeSize) {
        final int size;
        try {
            size = Integer.parseInt(bridgeSize);
        } catch (final NumberFormatException e) {
            throw new NumberFormatException("[ERROR] bridge size는 숫자가 입력되어야 합니다.");
        }
        if (size > 20 || size < 3) {
            throw new IllegalArgumentException("[ERROR] bridge size는 3 이상 20 이하의 숫자만 입력 가능합니다.");
        }
    }

    public static String readCourse() {
        final String course = readLine();
        validateCourse(course);
        return course;
    }

    private static void validateCourse(final String course) {
        if (!course.equals("U") && !course.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D만 입력 가능합니다.");
        }
    }

    public static String readRestartCommand() {
        final String command = readLine();
        validateRestartCommand(command);
        return command;
    }

    private static void validateRestartCommand(final String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 커맨드는 R 또는 Q만 입력 가능합니다.");
        }
    }
}
