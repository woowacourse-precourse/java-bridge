package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.Direction;
import bridge.dto.GameResult;
import bridge.dto.UserState;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_BEGINNING_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String GAME_RESULT_INTRO_MESSAGE = "최종 게임 결과";
    private static final String IS_GAME_SUCCESS = "게임 성공 여부: %s";
    private static final String NUMBER_OF_ATTEMPTS = "총 시도한 횟수: %d";
    private static final String BRIDGE_FRAME = "[ %s ]\n[ %s ]\n";
    private static final String CORRECT_DIRECTION = "O";
    private static final String INCORRECT_DIRECTION = "X";
    private static final String EMPTY_SPACE = " ";
    private static final String DIVIDER = " | ";

    public void printGameStartingMessage() {
        printMessage(GAME_BEGINNING_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(UserState userState) {
        StringBuilder higherBridge = new StringBuilder();
        StringBuilder lowerBridge = new StringBuilder();
        getPrintedBridge(userState, higherBridge, lowerBridge);
        System.out.println(String.format(BRIDGE_FRAME, higherBridge, lowerBridge));
    }

    private void getPrintedBridge(UserState userState, StringBuilder higherBridge, StringBuilder lowerBridge) {
        Bridge bridge = userState.getBridge();
        for (int i = 1; i < userState.getUserPosition(); i++) {
            addCircleOrEmptyWithDividerInBridge(higherBridge, bridge.isCorrectDirection(Direction.U, i));
            addCircleOrEmptyWithDividerInBridge(lowerBridge, bridge.isCorrectDirection(Direction.D, i));
        }
        printLastFigure(userState, higherBridge, lowerBridge);
    }

    private void addCircleOrEmptyWithDividerInBridge(StringBuilder bridgePrinting, boolean isCorrectDirection) {
        addCircleOrEmptyInBridge(bridgePrinting, isCorrectDirection);
        addDividerInBridge(bridgePrinting);
    }

    private void addCircleOrEmptyInBridge(StringBuilder bridgePrinting, boolean isCorrectDirection) {
        if (isCorrectDirection) {
            bridgePrinting.append(CORRECT_DIRECTION);
            return;
        }
        bridgePrinting.append(EMPTY_SPACE);
    }

    private void addDividerInBridge(StringBuilder bridgePainting) {
        bridgePainting.append(DIVIDER);
    }

    private void printLastFigure(UserState userState, StringBuilder higherBridge, StringBuilder lowerBridge) {
        Bridge bridge = userState.getBridge();
        if (userState.isAliveUser()) {
            addCircleOrEmptyInBridge(higherBridge, bridge.isCorrectDirection(Direction.U, userState.getUserPosition()));
            addCircleOrEmptyInBridge(lowerBridge, bridge.isCorrectDirection(Direction.D, userState.getUserPosition()));
            return;
        }
        addCrossOrEmptyInBridge(higherBridge, !bridge.isCorrectDirection(Direction.U, userState.getUserPosition()));
        addCrossOrEmptyInBridge(lowerBridge, !bridge.isCorrectDirection(Direction.D, userState.getUserPosition()));
    }

    private void addCrossOrEmptyInBridge(StringBuilder bridgePrinting, boolean isCorrectDirection) {
        if (isCorrectDirection) {
            bridgePrinting.append(INCORRECT_DIRECTION);
            return;
        }
        bridgePrinting.append(EMPTY_SPACE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        System.out.println(GAME_RESULT_INTRO_MESSAGE);
        printMap(gameResult.getUserState());
        System.out.println(String.format(IS_GAME_SUCCESS, getSuccessMessage(gameResult.isSuccess())));
        System.out.println(String.format(NUMBER_OF_ATTEMPTS, gameResult.getNumberOfAttempts()));
    }

    private String getSuccessMessage(boolean success) {
        if (success) {
            return "성공";
        }
        return "실패";
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
