package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public String readBridgeSize() {
        String size = readInput(INPUT_BRIDGE_SIZE);
        System.out.println();
        return size;
    }

    public String readMoving() {
        return readInput(INPUT_MOVING);
    }

    public String readGameCommand() {
        return readInput(INPUT_COMMAND);
    }

    private String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
