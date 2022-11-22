package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.status.RetryOrQuit.*;
import static bridge.status.UpDown.*;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static int bridgeSize;
    StaticView staticView = new StaticView();

    private void checkNumRange() throws IllegalArgumentException {
        if (3 > bridgeSize || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void toIntAndValidateIsNum(String input) throws IllegalArgumentException {
        try {
            bridgeSize = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateMoveInput(String moveInput) throws IllegalArgumentException {
        if (!moveInput.equals(UP.getValue()) && !moveInput.equals(DOWN.getValue())) {
            throw new IllegalArgumentException("[ERROR] U 또는 D 만 입력 가능합니다.");
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize() {
        String size;
        while (true) {
            if (bridgeSizeExceptionHandle()) continue;
            break;
        }
    }

    private boolean bridgeSizeExceptionHandle() {
        String size;
        try {
            size = getSize();
            toIntAndValidateIsNum(size);
            checkNumRange();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private String getSize() {
        String input;
        staticView.askSizeMsg();
        input = Console.readLine();
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveInput;

        while (true) {
            moveInput = getValidatedMoveInput();
            if (moveInput == null) continue;
            break;
        }
        return moveInput;
    }

    private String getValidatedMoveInput() {
        String moveInput;
        try {
            moveInput = getMoveInput();
            validateMoveInput(moveInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return moveInput;
    }

    private String getMoveInput() {
        String moveInput;
        staticView.askMoveMsg();
        moveInput = Console.readLine();
        return moveInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String commandInput;
        while (true) {
            commandInput = getValidatedCommandInput();
            if (commandInput == null) continue;
            break;
        }
        return commandInput;
    }

    private String getValidatedCommandInput() { // 예외 처리 로직.
        String commandInput;
        try {
            commandInput = getCommandInput();
            validateCommandInput(commandInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return commandInput;
    }

    private String getCommandInput() {
        String commandInput;
        staticView.askRetryMsg();
        commandInput = Console.readLine();
        return commandInput;
    }

    private void validateCommandInput(String commandInput) throws IllegalArgumentException { // 검증로직. 따로 뺄수 있을듯
        if (!commandInput.equals(RETRY.getMessage()) && !commandInput.equals(QUIT.getMessage())) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q 만 입력해주세요.");
        }
    }
}
