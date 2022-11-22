package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ERROR = "[ERROR] ";

    public int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            return inputSize();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
            return readBridgeSize();
        }
    }

    private int inputSize() {
        int size = parseInt(Console.readLine());
        InputValidator.validateBridgeSize(size);
        return size;
    }

    private int parseInt(String size) {
        InputValidator.validateNumber(size);
        return Integer.parseInt(size);
    }

    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            return inputMoveCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
            return readMoving();
        }
    }

    private String inputMoveCommand() {
        String movingCommand = Console.readLine();
        InputValidator.validateMovingCommand(movingCommand);
        return movingCommand;
    }

    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            return inputGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
            return readGameCommand();
        }
    }

    private String inputGameCommand() {
        String GameCommand = Console.readLine();
        InputValidator.validateGameCommand(GameCommand);
        return GameCommand;
    }
}
