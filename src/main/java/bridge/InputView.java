package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String INPUT_BRIDGE_LOCATION_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESTART_OR_QUIT_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String RESTART = "R";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        try {
            String number = Console.readLine();
            BridgeSize bridgeSize = new BridgeSize(number);
            return bridgeSize.getBridgeSize();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeLocationStatus readMoving() {
        System.out.println(INPUT_BRIDGE_LOCATION_MESSAGE);
        try {
            return BridgeLocationStatus.getBridgeLocationStatus(Console.readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        System.out.println(INPUT_RESTART_OR_QUIT_MESSAGE);
        try {
            GameCommand gameCommand = GameCommand.getGameCommand(Console.readLine());
            return gameCommand.getCommand().equals(RESTART);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readGameCommand();
        }
    }
}
