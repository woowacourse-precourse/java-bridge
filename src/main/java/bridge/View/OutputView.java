package bridge.View;

import bridge.BridgeGame;
import bridge.User;

import java.util.List;

import static bridge.View.Constants.OutputConstants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void outputInitialAnnouncement() {
        System.out.println(GAME_START);
        System.out.println();
        System.out.println(ENTER_LENGTH_OF_BRIDGE);
    }

    public void outputChoiceMove() {
        System.out.println(ENTER_MOVE);
    }

    public void outputRetryOrNot() {
        System.out.println(ENTER_RETRY_OR_NOT);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map) {
        String output = START_OF_BRIDGE + " " + String.join(BETWEEN_BRIDGES, map) + " " + END_OF_BRIDGE;
        System.out.println(output);
    }

    private String checkSuccess(boolean isSuccess) {
        String success = SUCCESS_OR_NOT;
        if (isSuccess) {
            return success + SUCCESS;
        }
        return success + FAIL;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        User user = bridgeGame.getUser();
        System.out.println(GAME_RESULT);
        printMap(user.getPathOfUpperBridge());
        printMap(user.getPathOfLowerBridge());
        System.out.println();
        System.out.println(checkSuccess(bridgeGame.isSuccess()));
        System.out.println(TOTAL_OF_ATTEMPT + bridgeGame.getAttempt());
    }
}
