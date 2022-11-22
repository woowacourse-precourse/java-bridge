package bridge;

import static bridge.constants.OutputConstants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final boolean SUCCESS = true;
    private final boolean FAIL = false;

    private StringBuilder stringBuilderUp;
    private StringBuilder stringBuilderDown;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param bridgeGame
     */
    public void printMap(BridgeGame bridgeGame) {
        this.stringBuilderInit();
        for (int resultBridgeCurrentIndex = 0; resultBridgeCurrentIndex < bridgeGame.getCurrentDownBridge().size(); resultBridgeCurrentIndex++) {
            appendUpDown(bridgeGame, resultBridgeCurrentIndex);
            if (resultBridgeCurrentIndex == bridgeGame.getCurrentUpBridge().size() - 1) {
                appendBracket();
                break;
            }
            appendDivision();
        }
        printUpDown();
    }

    private void printUpDown() {
        System.out.println(stringBuilderUp);
        System.out.println(stringBuilderDown);
        System.out.println();
    }

    private void appendDivision() {
        stringBuilderUp.append(APPEND_DIVISION.getMessage());
        stringBuilderDown.append(APPEND_DIVISION.getMessage());
    }

    private void appendBracket() {
        stringBuilderUp.append(END_BRACKET.getMessage());
        stringBuilderDown.append(END_BRACKET.getMessage());
    }

    private void appendUpDown(BridgeGame bridgeGame, int resultBridgeCurrentIndex) {
        stringBuilderUp.append(bridgeGame.getCurrentUpBridge().get(resultBridgeCurrentIndex));
        stringBuilderDown.append(bridgeGame.getCurrentDownBridge().get(resultBridgeCurrentIndex));
    }

    private void stringBuilderInit() {
        this.stringBuilderUp = new StringBuilder();
        this.stringBuilderDown = new StringBuilder();
        this.stringBuilderUp.append(START_BRACKET.getMessage());
        this.stringBuilderDown.append(START_BRACKET.getMessage());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param isSuccess
     * @param bridgeGame
     */
    public void printResult(boolean isSuccess, BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT.getMessage());
        printMap(bridgeGame);
        if (isSuccess == SUCCESS) {
            System.out.println(IS_SUCCESS_GAME.getMessage() + SUCCESS_GAME.getMessage());
        }
        if (isSuccess == FAIL) {
            System.out.println(IS_SUCCESS_GAME.getMessage() + FAIL_GAME.getMessage());
        }
        System.out.println(TRY_COUNT.getMessage() + bridgeGame.getTryCount());
    }
}
