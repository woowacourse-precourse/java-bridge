package bridge.view;

import bridge.config.ErrorMessageConstant;
import bridge.config.PrintMessageConstant;
import bridge.domain.BridgeGame;
import bridge.domain.BridgePrinter;
import bridge.domain.model.GameStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, BridgePrinter bridgePrinter) {
        System.out.println(bridgeGame.getPrintable(bridgePrinter));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, BridgePrinter bridgePrinter) {
        System.out.println(PrintMessageConstant.GAME_RESULT_TITLE);
        System.out.println(bridgeGame.getPrintable(bridgePrinter));
        System.out.println(String.format(PrintMessageConstant.GAME_RESULT_SUCCESS_OR_NOT_FORMAT, getSuccessOrNot(bridgeGame.getStatus())));
        System.out.println(String.format(PrintMessageConstant.GAME_RESULT_TRIAL_COUNT_FORMAT, bridgeGame.getTrialCount()));
    }

    public void printGameStart() {
        System.out.println(PrintMessageConstant.START_GAME);
    }

    public void printEnterBridgeLength() {
        System.out.println(PrintMessageConstant.PLEASE_ENTER_BRIDGE_LENGTH);
    }

    public void printEnterMoveDirection() {
        System.out.println(PrintMessageConstant.PLEASE_ENTER_MOVE_DIRECTION);
    }

    public void printEnterGameRetry() {
        System.out.println(PrintMessageConstant.PLEASE_ENTER_GAME_RETRY);
    }

    public void printExpectedErrorMessage(IllegalArgumentException e) {
        System.out.println(String.format(PrintMessageConstant.ERROR_EXPECTED_FORMAT, e.getMessage()));
    }

    public void printUnexpectedErrorMessage(Exception e) {
        System.out.println(String.format(PrintMessageConstant.ERROR_UNEXPECTED_FORMAT, e.getClass(), e.getCause(), e.getMessage()));
    }

    private static String getSuccessOrNot(GameStatus gameStatus) throws IllegalArgumentException {
        if (gameStatus == GameStatus.WIN) {
            return PrintMessageConstant.GAME_RESULT_SUCCESS;
        }
        if (gameStatus == GameStatus.LOSE) {
            return PrintMessageConstant.GAME_RESULT_LOSE;
        }
        throw new IllegalArgumentException(ErrorMessageConstant.GAME_NOT_FINISHED);
    }

}
