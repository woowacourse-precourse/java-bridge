package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.UserPath;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_PREFIX = "[ ";
    private static final String DELIMITER = " | ";
    private static final String BRIDGE_SUFFIX = " ]";
    private static final String PASS = "O";
    private static final String NO_PASS = "X";
    private static final String EMPTY = " ";

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        Bridge bridge = bridgeGame.getBridge();
        UserPath userPath = bridgeGame.getUserPath();

        StringBuilder output = new StringBuilder(BRIDGE_PREFIX);

        int userPosition = bridgeGame.getUserPosition();
        for (int i = 0; i < userPosition; i++) {
            if (bridge.compareWithPosition(i, "U")) {
                if (userPath.find(i).equals("U")) {
                    output.append(PASS);
                }
                else output.append(NO_PASS);
            }
            else output.append(EMPTY);

            if (i != userPosition - 1)
                output.append(DELIMITER);
        }
        output.append(BRIDGE_SUFFIX);

        System.out.println(output);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        printMap(bridgeGame);
    }
}
