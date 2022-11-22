package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String MOVE_BRIDGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RESTART_OR_NOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE);
        int bridgeSize = Integer.parseInt(Console.readLine());
        return bridgeSize;
    }

    public String readMoving() {
        System.out.println();
        System.out.println(MOVE_BRIDGE);
        String sideToMove = Console.readLine();
        return sideToMove;
    }

    public String readGameCommand() {
        System.out.println(RESTART_OR_NOT);
        String restartOrNot = Console.readLine();
        return restartOrNot;
    }
}