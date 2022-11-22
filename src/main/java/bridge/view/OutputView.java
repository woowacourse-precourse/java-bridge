package bridge.view;

import bridge.model.GameStatus;
import bridge.util.ResultGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String MESSAGE_START = "다리 건너기 게임을 시작합니다.";
    private static final String MESSAGE_INPUT_LENGTH_OF_BRIDGE = "다리의 길이를 입력해주세요.";
    private static final String MESSAGE_INPUT_MOVE_COMMAND = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MESSAGE_INPUT_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE_MESSAGE = "게임 성공 여부: ";
    private static final String TOTAL_ATTEMPTS_MESSAGE = "총 시도한 횟수: ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @Param moveBridgeMap
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String moveBridgeMap) {
        System.out.println(moveBridgeMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @Param gameStatus, moveBridgeMap
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameStatus gameStatus, String moveBridgeMap) {
        System.out.println(FINAL_GAME_RESULT_MESSAGE);
        printMap(moveBridgeMap);
        System.out.println(SUCCESS_OR_FAILURE_MESSAGE + ResultGame.getResultMessage(gameStatus.isResult()));
        System.out.println(TOTAL_ATTEMPTS_MESSAGE + gameStatus.getAttemptCount());
    }

    public void printStart() {
        System.out.println(MESSAGE_START);
    }

    public void printInputMessageBridgeLength() {
        System.out.println(MESSAGE_INPUT_LENGTH_OF_BRIDGE);
    }

    public void printInputMessageMoveCommand() {
        System.out.println(MESSAGE_INPUT_MOVE_COMMAND);
    }

    public void printInputMessageRetryCommand() {
        System.out.println(MESSAGE_INPUT_RETRY_COMMAND);
    }
}
