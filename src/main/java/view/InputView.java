package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String MOVE_BRIDGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RESTART_OR_NOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE);
        int bridgeSize = Integer.parseInt(Console.readLine());
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_BRIDGE);
        String sideToMove = Console.readLine();
        return sideToMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RESTART_OR_NOT);
        String restartOrNot = Console.readLine();
        return restartOrNot;
    }
}
