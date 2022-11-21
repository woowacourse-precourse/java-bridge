package bridge.view;

import bridge.model.Direction;
import bridge.model.Record;
import bridge.util.Constant;
import bridge.util.GuideMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printGameStart() {
        System.out.println(GuideMessage.START_GAME);
    }

    public void printEnterSize() {
        System.out.println(GuideMessage.ENTER_BRIDGE_SIZE);
    }

    public void printInputMoving() {
        System.out.println(GuideMessage.ENTER_NEXT_DIRECTION);
    }

    public void printInputGameCommand() {
        System.out.println(GuideMessage.ENTER_RETRY_OR_QUIT);
    }

    public void printFirstOfBridge() {
        System.out.print(GuideMessage.FIRST_OF_BRIDGE);
    }

    public void printMiddleOfBridge() {
        System.out.print(GuideMessage.MIDDLE_OF_BRIDGE);
    }

    public void printLastOfBridge() {
        System.out.println(GuideMessage.LAST_OF_BRIDGE);
    }

    public void printChoiceResult(String content) {
        System.out.print(content);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Record record, List<String> bridge) {
        printUpperLine(record, bridge);
        printLowerLine(record, bridge);
        breakLine();
    }

    private void printUpperLine(Record record, List<String> bridge) {
        printFirstOfBridge();
        for (int index = 0; index < record.getBoardSize(); index++) {
            printUpperBlock(record, index, bridge);
        }
        printLastOfBridge();
    }

    private void printUpperBlock(Record record, int index, List<String> bridge) {
        String direction = Direction.getFirstLetterByName(Direction.UP);
        String contentToPrint = getContent(Direction.isEqualToUp(bridge.get(index)),
                compareToBoard(record, index, direction));
        printChoiceResult(contentToPrint);
        if (index < record.getBoardSize() - 1) {
            printMiddleOfBridge();
        }
    }

    private String getContent(boolean bridgeResult, boolean boardResult) {
        if (bridgeResult && boardResult) {
            return GuideMessage.CORRECT_CHOICE;
        }
        if (!bridgeResult && boardResult) {
            return GuideMessage.INCORRECT_CHOICE;
        }
        return Constant.EMPTY;
    }

    private boolean compareToBoard(Record record, int index, String direction) {
        return record.equalsToBoard(index, direction);
    }

    private void printLowerLine(Record record, List<String> bridge) {
        printFirstOfBridge();
        for (int index = 0; index < record.getBoardSize(); index++) {
            printLowerBlock(record, index, bridge);
        }
        printLastOfBridge();
    }

    private void printLowerBlock(Record record, int index, List<String> bridge) {
        String direction = Direction.getFirstLetterByName(Direction.DOWN);
        String contentToPrint = getContent(Direction.isEqualToDown(bridge.get(index)),
                compareToBoard(record, index, direction));
        printChoiceResult(contentToPrint);
        if (index < record.getBoardSize() - 1) {
            printMiddleOfBridge();
        }
    }

    public void endOfGame() {
        System.out.println(GuideMessage.FINAL_RESULT);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int numberOfAttempt) {
        System.out.println(GuideMessage.SUCCESS_OR_FAIL + result);
        System.out.println(GuideMessage.NUMBER_OF_ATTEMPTS + numberOfAttempt);
    }

    private void breakLine() {
        System.out.println();
    }
}
