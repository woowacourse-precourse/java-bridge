package bridge.controller;

import bridge.domain.GameCommand;
import bridge.domain.BridgeLane;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        int bridgeSize = readInteger();

        if(bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return bridgeSize;
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
