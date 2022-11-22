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

        createMap(gameResult);

        System.out.println(topLine);
        System.out.println(bottomLine);
    }

    private void createMap(GameResult gameResult) {
        appendExceptLast(gameResult);
        appendLast(gameResult);
    }


    private void appendLast(GameResult result) {
        ViewStatus status = result.getNextViewStatus();
        List<String> bridge = result.getResult();
        String lastPosition = bridge.get(bridge.size() - 1);
        if (status == ViewStatus.DETERMINE_CONTINUE) {
            appendLastWhenWrong(lastPosition);
            return;
        }
        appendLastWhenCorrect(lastPosition);
    }

    private void appendLastWhenCorrect(String lastPosition) {
        appendUpLastWhenCorrect(lastPosition);
        appendDownLastWhenCorrect(lastPosition);
    }

    private void appendUpLastWhenCorrect(String lastPosition) {
        if (lastPosition.equals("U")) {
            topLine.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        topLine.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendDownLastWhenCorrect(String lastPosition) {
        if (lastPosition.equals("D")) {
            bottomLine.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        bottomLine.append(SPACE).append(CLOSE_BRACKET);
    }


    private void appendLastWhenWrong(String lastPosition) {
        appendUpLastWhenWrong(lastPosition);
        appendDownLastWhenWrong(lastPosition);
    }

    private void appendDownLastWhenWrong(String lastPosition) {
        if (lastPosition.equals("U")) {
            bottomLine.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        bottomLine.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendUpLastWhenWrong(String lastPosition) {
        if (lastPosition.equals("D")) {
            topLine.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        topLine.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendExceptLast(GameResult gameResult) {
        List<String> bridge = gameResult.getResult();
        topLine.append(OPEN_BRACKET);
        bottomLine.append(OPEN_BRACKET);
        for (int index = 0; index < bridge.size() - 1; index++) {
            String currentPosition = bridge.get(index);
            appendUp(currentPosition);
            appendDown(currentPosition);
        }
    }

    private void appendUp(String position) {
        if (position.equals("U")) {
            topLine.append(CORRECT).append(SEPARATOR);
            return;
        }
        topLine.append(SPACE).append(SEPARATOR);
    }

    private void appendDown(String position) {
        if (position.equals("D")) {
            bottomLine.append(CORRECT).append(SEPARATOR);
            return;
        }
        bottomLine.append(SPACE).append(SEPARATOR);
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
