package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static int minimumSize = 3;
    private static int maximumSize = 20;
    private static String up = "U";
    private static String down = "D";
    private static String retry = "R";
    private static String quit = "Q'";
    private static String readBridgeSizeMessage = "다리의 길이를 입력해주세요.";
    private static String readMovingMessage = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static String readGameCommandMessage = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static String bridgeSizeErrorMessage = "[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.";
    private static String movingErrorMessage = "[ERROR] 이동 할 칸은 U 혹은 D여야 합니다.";
    private static String gameCommandErrorMessage = "[ERROR] 재시작/종료 여부는 R 혹은 Q여야 합니다.";

    public Integer readBridgeSize() {
        try {
            System.out.println(readBridgeSizeMessage);
            int size = Integer.parseInt(readLine());
            validateBridgeSize(size);
            return size;
        } catch (ArithmeticException arithmeticException) {
            readBridgeSize();
        }
        return null;
    }

    public String readMoving() {
        try {
            System.out.println(readMovingMessage);
            String moving = readLine();
            validateMoving(moving);
            return moving;
        } catch (ArithmeticException arithmeticException) {
            readMoving();
        }
        return null;
    }

    public String readGameCommand() {
        try {
            System.out.println(readGameCommandMessage);
            String gameCommand = readLine();
            validateGameCommand(gameCommand);
            return gameCommand;
        } catch (ArithmeticException arithmeticException) {
            readGameCommand();
        }
        return null;
    }

    private void validateBridgeSize(int size) {
        if (size < minimumSize || size > maximumSize) {
            System.out.println(bridgeSizeErrorMessage);
            throw new ArithmeticException(bridgeSizeErrorMessage);
        }
    }

    private void validateMoving(String moving) {
        if (!moving.equals(up) && !moving.equals(down)) {
            System.out.println(movingErrorMessage);
            throw new ArithmeticException(movingErrorMessage);
        }
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(retry) && !gameCommand.equals(quit)) {
            System.out.println(gameCommandErrorMessage);
            throw new ArithmeticException(gameCommandErrorMessage);
        }
    }

}
