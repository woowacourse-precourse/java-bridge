package bridge.view;

import bridge.config.ErrorMessageConstant;
import bridge.config.PrintMessageConstant;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeTranslator;
import bridge.domain.model.GameStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param bridgeGame 출력할 상태가 있는 다리 게임
     * @param bridgeTranslator 출력 방법에 대한 구현체
     */
    public void printMap(BridgeGame bridgeGame, BridgeTranslator bridgeTranslator) {
        System.out.println(bridgeGame.getPrintable(bridgeTranslator));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param bridgeGame 출력할 상태가 있는 다리 게임
     * @param bridgeTranslator 출력 방법에 대한 구현체
     */
    public void printResult(BridgeGame bridgeGame, BridgeTranslator bridgeTranslator) {
        System.out.println(PrintMessageConstant.GAME_RESULT_TITLE);
        System.out.println(bridgeGame.getPrintable(bridgeTranslator));
        System.out.println(String.format(PrintMessageConstant.GAME_RESULT_SUCCESS_OR_NOT_FORMAT, getSuccessOrNot(bridgeGame.getStatus())));
        System.out.println(String.format(PrintMessageConstant.GAME_RESULT_TRIAL_COUNT_FORMAT, bridgeGame.getTrialCount()));
    }

    /**
     * 게임 시작을 알리는 문구를 출력한다.
     */
    public void printGameStart() {
        System.out.println(PrintMessageConstant.START_GAME);
    }

    /**
     * 다리의 길이를 입력하라고 알리는 문구를 출력한다.
     */
    public void printEnterBridgeLength() {
        System.out.println(PrintMessageConstant.PLEASE_ENTER_BRIDGE_LENGTH);
    }

    /**
     * 이동할 방향을 입력하라고 알리는 문구를 출력한다.
     */
    public void printEnterMoveDirection() {
        System.out.println(PrintMessageConstant.PLEASE_ENTER_MOVE_DIRECTION);
    }

    /**
     * 재시작 여부를 입력하라고 알리는 문구를 출력한다.
     */
    public void printEnterGameRetry() {
        System.out.println(PrintMessageConstant.PLEASE_ENTER_GAME_RETRY);
    }

    /**
     * 예측된 예외를 사용자에게 출력한다.
     * @param e 사용자의 잘못된 입력으로 발생한 예측된 예외
     */
    public void printExpectedErrorMessage(IllegalArgumentException e) {
        System.out.println(String.format(PrintMessageConstant.ERROR_EXPECTED_FORMAT, e.getMessage()));
    }

    /**
     * 예측치 못한 예외를 사용자에게 출력한다.
     * @param e 예측되지 못한 예외
     */
    public void printUnexpectedErrorMessage(Exception e) {
        System.out.println(String.format(PrintMessageConstant.ERROR_UNEXPECTED_FORMAT, e.getClass(), e.getCause(), e.getMessage()));
    }

    /**
     * 게임의 성공 또는 실패 여부를 형식에 맞게 출력한다.
     * @param gameStatus 게임 상태
     * @return 성공 / 실패 문자열
     * @throws IllegalArgumentException 게임이 RUNNING 상태일 때 호출 시 예외 발생
     * @see GameStatus
     */
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
