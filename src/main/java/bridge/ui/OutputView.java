package bridge.ui;

import bridge.domain.BridgeMoveJudgment;

import java.util.List;

import static bridge.ui.UiMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String OPEN_SQUARE_BRACKET = "[ ";
    private static final String CLOSE_SQUARE_BRACKET = " ]";
    private static final String VERTICAL_BAR = " | ";
    private static final int FIRST_MOVE = 0;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeMoveJudgment> moveResult) {
        StringBuilder bridgeUpperResult = new StringBuilder();
        StringBuilder bridgeLowerResult = new StringBuilder();
        addFormat(bridgeUpperResult, bridgeLowerResult, OPEN_SQUARE_BRACKET);
        createMoveResultFormat(moveResult, bridgeUpperResult, bridgeLowerResult);
        addFormat(bridgeUpperResult, bridgeLowerResult, CLOSE_SQUARE_BRACKET);

        System.out.println(bridgeUpperResult + "\n" + bridgeLowerResult + "\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<BridgeMoveJudgment> moveResult, boolean isFailFinalGame, int retryCount) {
        System.out.println(OUTPUT_FINAL_GAME_RESULT.getMessage());
        printMap(moveResult);
        printGameSuccessOrFail(isFailFinalGame);
        System.out.println(OUTPUT_TOTAL_TRY.getMessage() + retryCount);
    }

    /**
     * 게임 시작을 정해진 형식에 맞춰 출력한다.
     */
    public void printGameStart() {
        System.out.println(OUTPUT_GAME_START.getMessage());
    }

    /**
     * 게임의 다리 길이 입력 받기 문구를 정해진 형식에 맞춰 출력한다.
     */
    public void printBridgeLengthInput() {
        System.out.println(OUTPUT_BRIDGE_LENGTH.getMessage());
    }

    /**
     * 이동할 다리 칸 입력 받기 문구를 정해진 형식에 맞춰 출력한다.
     */
    public void printMovingSpaceChoice() {
        System.out.println(OUTPUT_CHOICE_MOVE_SPACE.getMessage());
    }

    /**
     * 게임 재시도 또는 종료 여부 문구를 정해진 형식에 맞춰 출력한다.
     */
    public void printRetryOrQuitChoice() {
        System.out.println(OUTPUT_CHOICE_RETRY_QUIT.getMessage());
    }

    /**
     * 이동한 다리의 상태를 정해진 출력 형식에 맞춰주는 로직
     */
    private void createMoveResultFormat(List<BridgeMoveJudgment> moveResult, StringBuilder bridgeUpperResult,
                                        StringBuilder bridgeLowerResult) {
        for (int i = 0; i < moveResult.size(); i += 2) {
            if (i == FIRST_MOVE) {
                bridgeUpperResult.append(moveResult.get(i).getShape());
                bridgeLowerResult.append(moveResult.get(i + 1).getShape());
                continue;
            }
            addFormat(bridgeUpperResult, bridgeLowerResult, VERTICAL_BAR);
            bridgeUpperResult.append(moveResult.get(i).getShape());
            bridgeLowerResult.append(moveResult.get(i + 1).getShape());
        }
    }

    /**
     * 처음과 끝을 정해진 출력 형식에 맞춰주는 로직
     */
    private void addFormat(StringBuilder bridgeUpperResult, StringBuilder bridgeLowerResult,
                           String format) {
        bridgeUpperResult.append(format);
        bridgeLowerResult.append(format);
    }

    /**
     * 최종 게임 성공 여부를 정해진 형식에 맞춰 출력한다.
     */
    private void printGameSuccessOrFail(boolean isFailFinalGame) {
        if (isFailFinalGame) {
            System.out.println(OUTPUT_GAME_FAIL.getMessage());
            return;
        }
        System.out.println(OUTPUT_GAME_SUCCESS.getMessage());
    }
}
