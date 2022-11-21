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

    private static final String TOTAL_RESULT = "최종 게임 결과";
    private static final String IS_SUCCESS = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String TRY_NUMBER = "총 시도한 횟수: ";

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        StringBuilder output = new StringBuilder();

        output.append(printMapOneLine(bridgeGame, "U"));
        output.append(printMapOneLine(bridgeGame, "D"));

        System.out.println(output);
    }

    private StringBuilder printMapOneLine(BridgeGame bridgeGame, String upOrDown) {
        StringBuilder output = new StringBuilder();

        output.append(BRIDGE_PREFIX);
        output.append(printGameState(bridgeGame, upOrDown));
        output.append(BRIDGE_SUFFIX);
        output.append("\n");

        return output;
    }

    private StringBuilder printGameState(BridgeGame bridgeGame, String upOrDown) {
        UserPath userPath = bridgeGame.getUserPath();

        StringBuilder output = new StringBuilder();
        for (int idx = 0; idx < userPath.size(); idx++) {
            output.append(printOneSquare(bridgeGame, upOrDown, idx));

            if (idx != userPath.size() - 1)
                output.append(DELIMITER);
        }
        return output;
    }

    private String printOneSquare(BridgeGame bridgeGame, String upOrDown, int position) {
        Bridge bridge = bridgeGame.getBridge();
        UserPath userPath = bridgeGame.getUserPath();

        if (userPath.find(position).equals(upOrDown)) {
            return passOrNo(upOrDown, bridge, position);
        }

        return EMPTY;
    }

    private String passOrNo(String upOrDown, Bridge bridge, int position) {
        if (bridge.compareWithPosition(position, upOrDown)) {
            return PASS;
        }
        return NO_PASS;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(TOTAL_RESULT);
        printMap(bridgeGame);

        System.out.print(IS_SUCCESS);
        System.out.println(successOrNot(bridgeGame));

        System.out.print(TRY_NUMBER);
        System.out.println(bridgeGame.getTryNumber());
    }

    private String successOrNot(BridgeGame bridgeGame) {
        if (bridgeGame.checkSuccess()) {
            return SUCCESS;
        }
       return FAIL;
    }
}
