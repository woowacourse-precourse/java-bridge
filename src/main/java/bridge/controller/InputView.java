package bridge.controller;

import bridge.domain.RestartInfo;
import bridge.domain.BridgeLane;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        return readInteger();
    }

    public BridgeLane readMoving() {
        String inputText = Console.readLine();
        return BridgeLane.makeBridgeLane(inputText);
    }

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
