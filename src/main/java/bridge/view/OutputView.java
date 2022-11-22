package bridge.view;

import bridge.constant.Directive;
import bridge.constant.ViewStatus;
import bridge.controller.BridgeGameController;
import bridge.dto.GameResult;

import java.util.List;

import static bridge.constant.BridgePosition.DOWN;
import static bridge.constant.BridgePosition.UP;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String OPEN_BRACKET = "[";
    private final String CLOSE_BRACKET = "]";
    private final String CORRECT = " O ";
    private final String WRONG = " X ";
    private final String SEPARATOR = "|";
    private final String SPACE = "   ";
    private final String SUCCESS = "성공";
    private final String FAIL = "실패";
    private final BridgeGameController bridgeGameController;

    private final StringBuilder topLine;
    private final StringBuilder bottomLine;

    public OutputView(BridgeGameController bridgeGameController) {
        this.bridgeGameController = bridgeGameController;
        topLine = new StringBuilder();
        bottomLine = new StringBuilder();
    }

    public void init() {
        topLine.setLength(0);
        bottomLine.setLength(0);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        createMap(gameResult);

        System.out.println(topLine);
        System.out.println(bottomLine);
    }

    private void createMap(GameResult gameResult) {
        init();
        createMapExceptLastPart(gameResult);
        createMapLastPart(gameResult);
    }

    private void createMapExceptLastPart(GameResult gameResult) {
        List<String> bridge = gameResult.getResult();
        topLine.append(OPEN_BRACKET);
        bottomLine.append(OPEN_BRACKET);
        for (int index = 0; index < bridge.size() - 1; index++) {
            String currentPosition = bridge.get(index);
            appendCorrectSignToTopLine(currentPosition);
            appendCorrectSignToBottomLine(currentPosition);
        }
    }

    private void appendCorrectSignToTopLine(String position) {
        if (position.equals(UP.getPositionFormOfAlphabet())) {
            topLine.append(CORRECT).append(SEPARATOR);
            return;
        }
        topLine.append(SPACE).append(SEPARATOR);
    }

    private void appendCorrectSignToBottomLine(String position) {
        if (position.equals(DOWN.getPositionFormOfAlphabet())) {
            bottomLine.append(CORRECT).append(SEPARATOR);
            return;
        }
        bottomLine.append(SPACE).append(SEPARATOR);
    }

    private void createMapLastPart(GameResult result) {
        ViewStatus status = result.getNextViewStatus();
        List<String> bridge = result.getResult();
        String lastPosition = bridge.get(bridge.size() - 1);
        if (status == ViewStatus.DETERMINE_CONTINUE) {
            appendWrongSignAsLastPartOfMap(lastPosition);
            return;
        }
        appendCorrectSignAsLastPartOfMap(lastPosition);
    }

    private void appendWrongSignAsLastPartOfMap(String lastPosition) {
        appendWrongSignAsLastPartOfTopLine(lastPosition);
        appendWrongSignAsLastPartOfBottomLine(lastPosition);
    }

    private void appendWrongSignAsLastPartOfTopLine(String lastPosition) {
        if (lastPosition.equals(DOWN.getPositionFormOfAlphabet())) {
            topLine.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        topLine.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendWrongSignAsLastPartOfBottomLine(String lastPosition) {
        if (lastPosition.equals(UP.getPositionFormOfAlphabet())) {
            bottomLine.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        bottomLine.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendCorrectSignAsLastPartOfMap(String lastPosition) {
        appendCorrectSignAsLastPartOfTopLine(lastPosition);
        appendCorrectSignAsLastPartOfBottomLine(lastPosition);
    }

    private void appendCorrectSignAsLastPartOfTopLine(String lastPosition) {
        if (lastPosition.equals(UP.getPositionFormOfAlphabet())) {
            topLine.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        topLine.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendCorrectSignAsLastPartOfBottomLine(String lastPosition) {
        if (lastPosition.equals(DOWN.getPositionFormOfAlphabet())) {
            bottomLine.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        bottomLine.append(SPACE).append(CLOSE_BRACKET);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(ViewStatus status) {
        System.out.println(Directive.FINAL_GAME_RESULT.getMessage());
        System.out.println(topLine);
        System.out.println(bottomLine);
        printWinOrNot(status);
        printCount();
    }

    private void printWinOrNot(ViewStatus status) {
        System.out.print(Directive.WIN_OR_NOT.getMessage());
        if (status == ViewStatus.WIN) {
            System.out.println(SUCCESS);
        }
        if (status == ViewStatus.LOSE) {
            System.out.println(FAIL);
        }
    }

    private void printCount() {
        System.out.print(Directive.GAME_COUNT.getMessage());
        System.out.println(bridgeGameController.getGameCount());
    }
}
