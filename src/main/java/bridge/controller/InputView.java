package bridge.controller;

import bridge.domain.RestartInfo;
import bridge.domain.BridgeLane;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return readInteger();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeLane readMoving() {
        String inputText = Console.readLine();
        return BridgeLane.makeBridgeLane(inputText);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public RestartInfo readGameCommand() {
        String inputText = Console.readLine();
        return RestartInfo.makeRestartInfo(inputText);
    }

    private int readInteger() {
        String inputText = Console.readLine();
        if(isNotInt(inputText)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        inputText = inputText.trim();
        return Integer.parseInt(inputText);
    }

    private boolean isNotInt(String input) {
        input = input.trim();
        return !input.matches("-?\\d+");
    }
}
