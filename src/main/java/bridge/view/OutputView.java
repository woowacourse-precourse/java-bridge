package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    static final String UPPER = "U";
    static final String LOWER = "D";
    static final String FAIL_FLAG = "F";
    static final String LEFT_SKELETON = "[ ";
    static final String RIGHT_SKELETON = " ]";
    static final String MID_SKELETON = " | ";
    static final String CORRECT_RESULT = "O";
    static final String WRONG_RESULT = "X";

    public void printStartMessage() {
        GameMessages startMessage = GameMessages.START_MESSAGE;
        startMessage.println();
    }

    public void printInputBridgeLengthMessage() {
        GameMessages inputBridgeLengthMessage = GameMessages.DECIDE_BRIDGE_LENGTH_MESSAGE;
        inputBridgeLengthMessage.println();
    }

    public void printInputMoveMessage() {
        GameMessages inputMoveMessage = GameMessages.CHOOSE_DIRECTION_MESSAGE;
        inputMoveMessage.println();
    }

    public void printInputRetrialMessage() {
        GameMessages inputRetrialMessage = GameMessages.INPUT_RETRIAL_MESSAGE;
        inputRetrialMessage.println();
    }

    private static void printEndMessage() {
        GameMessages endMessage = GameMessages.END_MESSAGE;
        endMessage.println();
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userBridge) {
        printBridge(userBridge, UPPER);
        printBridge(userBridge, LOWER);
        System.out.println();
    }

    private void printBridge(List<String> userBridge, String upperLower) {
        System.out.print(LEFT_SKELETON);
        for (String bridgeType : userBridge.subList(0, userBridge.size() - 1)) {
            printMark(bridgeType, upperLower);
            System.out.print(MID_SKELETON);
        }
        printMark(userBridge.get(userBridge.size() - 1), upperLower);
        System.out.println(RIGHT_SKELETON);
    }

    private void printMark(String bridgeType, String upperLower) {
        if (bridgeType.equals(upperLower)) {
            System.out.print(CORRECT_RESULT);
        }
        if (bridgeType.equals(upperLower + FAIL_FLAG)) {
            System.out.print(WRONG_RESULT);
        }
        if (!bridgeType.equals(upperLower) && !bridgeType.equals(upperLower + FAIL_FLAG)) {
            System.out.print(" ");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int retrialNumber, boolean gameSuccess, List<String> userBridge) {
        printEndMessage();
        printMap(userBridge);
        printGameSuccess(gameSuccess);
        printRetrialNumbers(retrialNumber);
    }

    private void printGameSuccess(boolean gameSuccess) {
        GameMessages isSuccessMessage = GameMessages.GAME_SUCCESS_MESSAGE;
        isSuccessMessage.print();
        if (gameSuccess == true) {
            System.out.println("성공");
        }
        if (gameSuccess == false) {
            System.out.println("실패");
        }
    }

    private void printRetrialNumbers(int retrialNumber) {
        GameMessages retrialNumbersMessage = GameMessages.RETRIAL_NUMBERS_MESSAGE;
        retrialNumbersMessage.print();
        System.out.println(retrialNumber);
    }
}
