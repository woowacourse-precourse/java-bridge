package bridge.view;

import bridge.view.InputView.Command;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR]";

    private static enum BridgeElement {
        PREFIX("[ "),
        DELIMITER(" | "),
        SUFFIX(" ]"),
        MOVE_SUCCESS("O"),
        MOVE_FAILED("X"),
        NOT_VISITED(" ");

        private final String element;

        BridgeElement(String element) {
            this.element = element;
        }

        public String getElement() {
            return this.element;
        }
    }

    private static enum GameResultMessage {
        HEADER("최종 게임 결과"),
        SUCCESS("게임 성공 여부: 성공"),
        FAILED("게임 성공 여부: 실패"),
        ATTEMPTS_COUNT("총 시도한 횟수: ");

        private final String message;

        GameResultMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> movingStatus, boolean isSuccess) {
        StringJoiner[] bridgeInfo = new StringJoiner[2];
        bridgeInfo[0] = new StringJoiner(BridgeElement.DELIMITER.getElement(), BridgeElement.PREFIX.getElement(),
                BridgeElement.SUFFIX.getElement());
        bridgeInfo[1] = new StringJoiner(BridgeElement.DELIMITER.getElement(), BridgeElement.PREFIX.getElement(),
                BridgeElement.SUFFIX.getElement());
        addPreviousStatus(bridgeInfo, movingStatus);
        addLastStatus(bridgeInfo, movingStatus.get(movingStatus.size() - 1), isSuccess);
        printJoinerStatus(bridgeInfo);
    }

    private void addPreviousStatus(StringJoiner[] bridgeInfo, List<String> movingStatus) {
        for (int i = 0; i < movingStatus.size() - 1; i++) {
            bridgeInfo[getIndex(movingStatus.get(i))].add(BridgeElement.MOVE_SUCCESS.getElement());
            bridgeInfo[getReverseNumber(getIndex(movingStatus.get(i)))].add(BridgeElement.NOT_VISITED.getElement());
        }
    }

    private void addLastStatus(StringJoiner[] bridgeInfo, String lastMoving, boolean isSuccess) {
        if (isSuccess) { // 마지막 이동이 성공함
            bridgeInfo[getIndex(lastMoving)].add(BridgeElement.MOVE_SUCCESS.getElement());
            bridgeInfo[getReverseNumber(getIndex(lastMoving))].add(BridgeElement.NOT_VISITED.getElement());
            return;
        }
        // 마지막 이동이 실패함
        bridgeInfo[getIndex(lastMoving)].add(BridgeElement.MOVE_FAILED.getElement());
        bridgeInfo[getReverseNumber(getIndex(lastMoving))].add(BridgeElement.NOT_VISITED.getElement());
    }

    private void printJoinerStatus(StringJoiner[] bridgeInfo) {
        // index 0 - 아래쪽 다리
        // index 1 - 위 쪽 다리
        System.out.println(bridgeInfo[1].toString());
        System.out.println(bridgeInfo[0].toString());
    }

    private int getReverseNumber(int number) {
        if (number == 1) {
            return 0;
        }
        return 1;
    }

    private int getIndex(String command) {
        return Command.getCodeByCommand(command);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> movingStatus, boolean isSuccess, int attemptsCount) {
        System.out.println(GameResultMessage.HEADER.getMessage());
        printMap(movingStatus, isSuccess);
        System.out.println();
        printSuccessInfo(isSuccess);
        System.out.println(GameResultMessage.ATTEMPTS_COUNT.getMessage() + attemptsCount);
    }

    private void printSuccessInfo(boolean isSuccess) {
        if (isSuccess) {
            System.out.println(GameResultMessage.SUCCESS.getMessage());
            return;
        }
        System.out.println(GameResultMessage.FAILED.getMessage());
    }

    /*
     * message로 시작하고, end로 끝나는 문자열을 출력함
     * 즉, message + end의 형태가 출력되는 것
     */
    public void printMessage(String message, String end) {
        System.out.print(message + end);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_HEADER + " " + message);
    }
}
