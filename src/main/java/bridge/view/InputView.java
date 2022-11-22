package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    // TODO: Error메시지 Enum으로 출력

    public int readBridgeSize() {
        String inputBridgeSize = Console.readLine();
        validBridgeSize(inputBridgeSize);
        return Integer.parseInt(inputBridgeSize);
    }

    private void validBridgeSize(String inputBridgeSize) {
        if (!Pattern.matches("^[0-9]*$", inputBridgeSize)) {
            throw new IllegalArgumentException();
        }

        int bridgeSize = Integer.parseInt(inputBridgeSize);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputMoving = Console.readLine();
        validMoving(inputMoving);
        return inputMoving;
    }

    private void validMoving(String inputMoving) {
        // TODO: U, O를 상수로 관리
        if (!inputMoving.contains("U") && !inputMoving.contains("O")) {
            throw new IllegalArgumentException();
        }
        if (inputMoving.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String inputGameCommand = Console.readLine();
        validGameCommand(inputGameCommand);
        return inputGameCommand;
    }

    private void validGameCommand(String inputGameCommand) {
        // TODO: R, Q를 상수로 관리
        if (!inputGameCommand.contains("R") && !inputGameCommand.contains("Q")) {
            throw new IllegalArgumentException();
        }
        if (inputGameCommand.length() != 1) {
            throw new IllegalArgumentException();
        }
    }
}
