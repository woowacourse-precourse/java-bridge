package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String bridgeSizePrompt = "다리의 길이를 입력해주세요.";
    private final String moveDirectionPrompt = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String gameCommandPrompt = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        System.out.println(bridgeSizePrompt);
        String input = Console.readLine();
        return new BridgeSize(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        System.out.println(moveDirectionPrompt);
        String input = Console.readLine();
        return Direction.getDirection(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        System.out.println(gameCommandPrompt);
        String input = Console.readLine();
        return GameCommand.getGameCommand(input);
    }
}
