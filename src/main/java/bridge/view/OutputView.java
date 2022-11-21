package bridge.view;

import bridge.constant.Directive;
import bridge.constant.ViewStatus;
import bridge.controller.BridgeGameController;
import bridge.dto.GameResult;

import java.util.List;

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

    private StringBuilder topLine;
    private StringBuilder bottomLine;

    public OutputView(BridgeGameController bridgeGameController) {
        this.bridgeGameController = bridgeGameController;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        topLine = new StringBuilder();
        bottomLine = new StringBuilder();

        createMap(gameResult, topLine, bottomLine);

        System.out.println(topLine);
        System.out.println(bottomLine);
    }

    private void createMap(GameResult gameResult, StringBuilder topLine, StringBuilder bottomLine) {
        List<String> bridge = gameResult.getResult();

        appendExceptLast(bridge, topLine, bottomLine);
        appendLast(gameResult, topLine, bottomLine);
    }


    private void appendLast(GameResult result, StringBuilder topLine, StringBuilder bottomLine) {
        ViewStatus status = result.getNextViewStatus();
        List<String> bridge = result.getResult();
        String lastPosition = bridge.get(bridge.size() - 1);
        if (status == ViewStatus.DETERMINE_CONTINUE) {
            appendLastWhenWrong(lastPosition, topLine, bottomLine);
            return;
        }
        appendLastWhenCorrect(lastPosition, topLine, bottomLine);
    }

    private void appendLastWhenCorrect(String lastPosition, StringBuilder topLine, StringBuilder bottomLine) {
        appendUpLastWhenCorrect(lastPosition, topLine);
        appendDownLastWhenCorrect(lastPosition, bottomLine);
    }

    private void appendUpLastWhenCorrect(String lastPosition, StringBuilder line) {
        if (lastPosition.equals("U")) {
            line.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        line.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendDownLastWhenCorrect(String lastPosition, StringBuilder line) {
        if (lastPosition.equals("D")) {
            line.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        line.append(SPACE).append(CLOSE_BRACKET);
    }


    private void appendLastWhenWrong(String lastPosition, StringBuilder topLine, StringBuilder bottomLine) {
        appendUpLastWhenWrong(lastPosition, topLine);
        appendDownLastWhenWrong(lastPosition, bottomLine);
    }

    private void appendDownLastWhenWrong(String lastPosition, StringBuilder line) {
        if (lastPosition.equals("U")) {
            line.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        line.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendUpLastWhenWrong(String lastPosition, StringBuilder line) {
        if (lastPosition.equals("D")) {
            line.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        line.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendExceptLast(List<String> bridge, StringBuilder topLine, StringBuilder bottomLine) {
        topLine.append(OPEN_BRACKET);
        bottomLine.append(OPEN_BRACKET);
        for (int index = 0; index < bridge.size() - 1; index++) {
            String currentPosition = bridge.get(index);
            appendUp(currentPosition, topLine);
            appendDown(currentPosition, bottomLine);
        }
    }

    private void appendUp(String position, StringBuilder line) {
        if (position.equals("U")) {
            line.append(CORRECT).append(SEPARATOR);
            return;
        }
        line.append(SPACE).append(SEPARATOR);
    }

    private void appendDown(String position, StringBuilder line) {
        if (position.equals("D")) {
            line.append(CORRECT).append(SEPARATOR);
            return;
        }
        line.append(SPACE).append(SEPARATOR);
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
        if(status == ViewStatus.WIN) {
            System.out.println(SUCCESS);
        }
        if(status == ViewStatus.LOSE){
            System.out.println(FAIL);
        }
    }

    private void printCount() {
        System.out.print(Directive.GAME_COUNT.getMessage());
        System.out.println(bridgeGameController.getGameCount());
    }
}
