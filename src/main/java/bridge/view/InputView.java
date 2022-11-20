package bridge.view;
import bridge.controller.BridgeGame;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private BridgeGame bridgeGame = new BridgeGame();
    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize() {
        System.out.println(START_MESSAGE);
        System.out.println(LENGTH_MESSAGE);
        int size = Integer.parseInt(Console.readLine());
        bridgeGame.startGame(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
