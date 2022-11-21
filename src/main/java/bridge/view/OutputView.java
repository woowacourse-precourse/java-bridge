package bridge.view;

import bridge.constant.ViewConstants;
import bridge.domain.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartingGame() {
        System.out.println(ViewConstants.STARTING_GAME);
        System.out.println();
    }

    public void printAskingBridgeLength() {
        System.out.println(ViewConstants.ASKING_BRIDGE_LENGTH);
    }

    public void printAskingMoving() {
        System.out.println(ViewConstants.ASKING_MOVING);
    }

    public void printAskingRestartingGame() {
        System.out.println(ViewConstants.ASKING_RESTARTING_GAME);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(ViewConstants.GAME_RESULT);
        printMap(bridgeGame.makeMap());
        printSuccessOrFailure(bridgeGame.calculateResult());
        printAttemptTimes(bridgeGame.getAttemptTimes());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridge) {
        bridge.forEach(this::printRow);
        System.out.println();
    }

    private void printRow(List<String> row) {
        System.out.println(ViewConstants.FRONT + String.join(ViewConstants.DELIMITER, row) + ViewConstants.BACK);
    }

    private void printSuccessOrFailure(String result) {
        System.out.printf(ViewConstants.SUCCESS_OR_FAILURE, result);
        System.out.println();
    }

    private void printAttemptTimes(int attemptTimes) {
        System.out.printf(ViewConstants.ATTEMPT_TIMES, attemptTimes);
        System.out.println();
    }
}
