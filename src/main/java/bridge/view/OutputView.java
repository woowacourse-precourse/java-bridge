package bridge.view;

import static bridge.constant.MovingDirection.D;
import static bridge.constant.MovingDirection.U;
import static bridge.view.constant.BridgeShape.DIFFERENT_DIRECTION;
import static bridge.view.constant.BridgeShape.MIDDLE_BRIDGE;
import static bridge.view.constant.BridgeShape.NONE_DIRECTION;
import static bridge.view.constant.BridgeShape.PREFIX_BRIDGE;
import static bridge.view.constant.BridgeShape.SAME_DIRECTION;
import static bridge.view.constant.BridgeShape.SUFFIX_BRIDGE;
import static bridge.view.constant.OutputMessage.GAME_RESULT_MAIN_PHRASE;
import static bridge.view.constant.OutputMessage.GAME_RESULT_PHRASE;
import static bridge.view.constant.OutputMessage.INPUT_BRIDGE_LENGTH_REQUEST_PHRASE;
import static bridge.view.constant.OutputMessage.INPUT_MOVING_DIRECTION_REQUEST_PHRASE;
import static bridge.view.constant.OutputMessage.INPUT_RETRY_QUIT_REQUEST_PHRASE;
import static bridge.view.constant.OutputMessage.START_PHRASE;
import static bridge.view.constant.OutputMessage.TOTAL_TRY_COUNT_PHRASE;

import bridge.BridgeGame;
import bridge.constant.MovingDirection;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final int ONE = 1;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param bridgeGame
     */
    public void printMap(BridgeGame bridgeGame) {
        printBridgeByDirection(bridgeGame, U);
        printBridgeByDirection(bridgeGame, D);
    }

    private void printBridgeByDirection(BridgeGame bridgeGame, MovingDirection movingDirection) {
        System.out.print(PREFIX_BRIDGE.getShape());
        for (int i = 0; i < bridgeGame.getCurrentPosition(); i++) {
            printMiddleBridgeByDirection(bridgeGame, movingDirection, i);
            if (isLastBridgePosition(bridgeGame, i)) {
                System.out.print(MIDDLE_BRIDGE.getShape());
            }
        }
        System.out.println(SUFFIX_BRIDGE.getShape());
    }

    private static boolean isLastBridgePosition(BridgeGame bridgeGame, int position) {
        return position != (bridgeGame.getCurrentPosition() - ONE);
    }

    private void printMiddleBridgeByDirection(BridgeGame bridgeGame,
        MovingDirection movingDirection, int position) {
        if (bridgeGame.hasSameDirectionAtPosition(position, movingDirection)) {
            printIsUserChoiceCorrect(bridgeGame, position);
            return;
        }
        System.out.print(NONE_DIRECTION.getShape());
    }

    private static void printIsUserChoiceCorrect(BridgeGame bridgeGame, int position) {
        if (bridgeGame.hasCorrectDirectionAtPosition(position)) {
            System.out.print(SAME_DIRECTION.getShape());
            return;
        }
        System.out.print(DIFFERENT_DIRECTION.getShape());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param bridgeGame
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT_MAIN_PHRASE.getMessage());
        printMap(bridgeGame);
        System.out.printf(GAME_RESULT_PHRASE.getMessage(), bridgeGame.getResultPhrase());
        System.out.printf(TOTAL_TRY_COUNT_PHRASE.getMessage(), bridgeGame.getTryCount());
    }

    public void printStartPhrase() {
        System.out.println(START_PHRASE.getMessage());
    }

    public void printInputBridgeSizePhrase() {
        System.out.println(INPUT_BRIDGE_LENGTH_REQUEST_PHRASE.getMessage());
    }

    public void printOnGamePhrase() {
        System.out.println(INPUT_MOVING_DIRECTION_REQUEST_PHRASE.getMessage());
    }

    public void printRetryOrQuitPhrase() {
        System.out.println(INPUT_RETRY_QUIT_REQUEST_PHRASE.getMessage());
    }

    public void printExceptionMessage(RuntimeException exception) {
        System.out.println(exception.getMessage());
    }
}
