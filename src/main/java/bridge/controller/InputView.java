package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.domain.GameCommand;
import bridge.domain.BridgeLane;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public BridgeSize readBridgeSize() {
        int size = readInteger();
        return BridgeSize.makeBridgeSize(size);
    }

    public BridgeLane readMoving() {
        String inputText = Console.readLine();
        return BridgeLane.makeBridgeLane(inputText);
    }

    public GameCommand readGameCommand() {
        String inputText = Console.readLine();
        return GameCommand.makeGameCommand(inputText);
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
