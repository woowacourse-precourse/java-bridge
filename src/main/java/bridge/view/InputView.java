package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public String readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        return Console.readLine();
    }

    public String readMoving() {
        System.out.println();
        System.out.println(INPUT_MOVING);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println();
        System.out.println(INPUT_COMMAND);
        return Console.readLine();
    }
}
