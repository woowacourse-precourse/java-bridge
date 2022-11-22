package bridge.view;

import bridge.message.PrintCommon;
import bridge.message.PrintError;
import camp.nextstep.edu.missionutils.Console;

// 사용자로부터 입력을 받는 역할을 한다.
public class InputView {

    private static final int SIZE_MIN = 3;
    private static final int SIZE_MAX = 20;

    // 다리 길이를 입력 받는 메소드
    public int readBridgeSize() {
        PrintCommon.INPUT_SIZE.print();

        return inputBridgeSize();
    }

    // 다리 길이를 실제적으로 입력받는 메소드, 에러 발생 시 함수를 재귀하여 다시 입력받는다.
    private int inputBridgeSize() {
        String bridgeSize = Console.readLine();

        try {
            validateBridgeSize(bridgeSize);
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputBridgeSize();
        }

        return Integer.parseInt(bridgeSize);
    }

    // 이동한 칸을 입력받는 메소드
    public String readMoving() {
        PrintCommon.INPUT_MOVING.print();

        return inputMoving();
    }

    // 이동할 칸을 실제적으로 입력받는 메소드, 에러 발생 시 함수를 재귀하여 다시 입력받는다.
    private String inputMoving () {
        String moving = Console.readLine();

        try {
            validateMoving(moving);
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputMoving();
        }

        return moving;
    }

    // 재시작 시 커맨드를 입력받는 메소드
    public String readGameCommand() {
        PrintCommon.INPUT_RETRY.print();

        return inputCommand();
    }

    // 재시작 커맨드를 실제적으로 입력받는 메소드, 에러 발생 시 함수를 재귀하여 다시 입력받는다.
    private String inputCommand() {
        String command = Console.readLine();

        try {
            validateCommand(command);
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputCommand();
        }

        return command;
    }

    // 입력된 재시작 커맨드가 올바른 문자로 입력되었는지 확인 하는 메소드
    private void validateCommand (String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            PrintError.COMMAND.print();
            throw new IllegalArgumentException();
        }
    }

    // 입력된 이동할 칸이 올바른 문자로 입력되었는지 확인 하는 메소드
    private void validateMoving (String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            PrintError.MOVING.print();
            throw new IllegalArgumentException();
        }
    }

    // 입력된 다리 길이가 올바르게 입력되었는지 확인하는 메소드
    private void validateBridgeSize (String bridgeSize) {
        isRealNumber(bridgeSize);
        checkBridgeSizeNumberRange(bridgeSize);
    }

    // 입력된 다리 길이가 숫자로만 입력되었는지 확인하는 메소드
    private void isRealNumber (String bridgeSize) {
        for (char element: bridgeSize.toCharArray()) {
            if (element < 48 || element > 57) {
                PrintError.SIZE_NUMBER.print();
                throw new IllegalArgumentException();
            }
        }
    }

    // 입력된 다리 길이가 주어진 범위를 충족하는지 확인하는 메소드
    private void checkBridgeSizeNumberRange (String bridgeSize) {
        int bridgeSizeNumber = Integer.parseInt(bridgeSize);
        if (bridgeSizeNumber < SIZE_MIN|| bridgeSizeNumber > SIZE_MAX) {
            PrintError.SIZE_RANGE.print();
            throw new IllegalArgumentException();
        }
    }
}
