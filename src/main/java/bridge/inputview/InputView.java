package bridge.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView implements bridge.extensible.InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize;
        while (true) {
            bridgeSize = inputBridgeSize();
            if (bridgeSize != -1) {
                break;
            }
        }
        return bridgeSize;
    }


    private int inputBridgeSize() {
        String inputBridgeSize = Console.readLine();
        int bridgeSize = isNumber(inputBridgeSize);
        boolean isValid = validateBridgeSize(bridgeSize);
        if (bridgeSize == -1 || !isValid) {
            return -1;
        }
        return bridgeSize;
    }

    private boolean validateBridgeSize(Integer inputBridgeSize) {
        try {
            throwIfFailToValidateBridgeSize(inputBridgeSize);
            return true;
        } catch (IllegalArgumentException IA) {
            System.out.println(IA.getMessage());
            return false;
        }
    }


    private void throwIfFailToValidateBridgeSize(Integer size) throws IllegalArgumentException {
        if (size < 3 || 20 < size) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 수를 입력해주세요.");
        }
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException NE) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            return -1;
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        StringBuilder moveDir = new StringBuilder();
        while (true) {
            if (inputMove(moveDir)) {
                break;
            }
        }
        return moveDir.toString();
    }

    private boolean inputMove(StringBuilder moveDir) {
        try {
            moveDir.append(inputMove());
            return true;
        } catch (IllegalArgumentException IA) {
            System.out.println(IA.getMessage());
            return false;
        }
    }

    private String inputMove() throws IllegalArgumentException {
        String inputMove = Console.readLine();
        throwIfFailToValidateMove(inputMove);
        return inputMove;
    }

    private void throwIfFailToValidateMove(String input) {
        if (!validateMoving(input)) {
            throw new IllegalArgumentException("[ERROR] U 또는 D 를 입력해주세요.");
        }
    }

    private boolean validateMoving(String input) {
        return Objects.equals(input, "U") || Objects.equals(input, "D");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String inputRestartCommand;
        while (true) {
            inputRestartCommand = Console.readLine();
            if (validateReadCommand(inputRestartCommand)) {
                break;
            }
        }
        return inputRestartCommand;
    }

    private boolean validateReadCommand(String inputCommand) {
        try {
            throwIfFailToValidateCommand(inputCommand);
            return true;
        } catch (IllegalArgumentException IA) {
            System.out.println(IA.getMessage());
            return false;
        }
    }

    private void throwIfFailToValidateCommand(String inputCommand) {
        if (inputCommand != "R" && inputCommand != "Q") {
            throw new IllegalArgumentException("[ERROR] 'R' 또는 'Q'를 입력해주세요.");
        }
        return;
    }


}
