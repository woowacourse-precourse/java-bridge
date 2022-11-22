package bridge.view;

import bridge.util.Command;
import bridge.util.ConstantIntegerBridge;
import bridge.util.IllegalArgumentExceptionMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize;
        try {
            String bridgeSizeCommand = inputBridgeSizeCommand();
            bridgeSize = toBridgeSize(bridgeSizeCommand);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            bridgeSize = readBridgeSize();  // 에러 발생시 재귀로 다시 입력요청
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return inputMoveCommand();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private int toBridgeSize(String bridgeSizeCommand) {
        int bridgeSize = Integer.parseInt(bridgeSizeCommand);
        validateIntegerSize(bridgeSize);

        return bridgeSize;
    }

    /**
     * input: 데이터를 Console에서 입력받는다.
     */
    private String inputBridgeSizeCommand() {
        String bridgeSize = Console.readLine();
        validateStringSize(bridgeSize);
        return bridgeSize;
    }

    private String inputMoveCommand() {
        String moveCommand = Console.readLine();
        validateMoveCommand(moveCommand);
        return moveCommand;
    }

    /**
     * validate: 주어진 제한사항을 만족하는지 체크한다.
     */
    private void validateStringSize(String test) {
        if (!test.matches("[1-9]+[0-9]*")) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.INPUT_BRIDGE_FORM.getMessage());
        }
    }

    private void validateIntegerSize(int size) {
        if (ConstantIntegerBridge.LENGTH_LOWER_BRIDGE.getConstant() > size || size > ConstantIntegerBridge.LENGTH_UPPER_BRIDGE.getConstant()) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.INPUT_BRIDGE_LENGTH.getMessage());
        }
    }

    private void validateMoveCommand(String moveCommand) {
        if (!moveCommand.matches("[" + Command.MOVE_UPPER_LETTER.getCommand() + Command.MOVE_LOWER_LETTER.getCommand() + "]")) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.INPUT_MOVE_COMMAND_FORM.getMessage());
        }
    }
}
