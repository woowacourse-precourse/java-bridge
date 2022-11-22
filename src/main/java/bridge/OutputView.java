package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private static final String EMPTY = " ";
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_SEP = " | ";
    private static final String BRIDGE_AVAILABLE = "O";
    private static final String BRIDGE_NOT_AVAILABLE = "X";
    private static final String UP = "U";
    private static final String DOWN = "D";


    private static String getAvailableOrEmpty(String position, String upDown) {
        if (!upDown.equals(position)) {
            return EMPTY;
        }
        return BRIDGE_AVAILABLE;
    }

    private static List<String> getMiddle(List<String> crossedBridge, String position) {
        List<String> middle = new ArrayList();
        for (String upDown : crossedBridge) {
            middle.add(getAvailableOrEmpty(position, upDown));
        }
        return middle;
    }


    private static String arrToString(List<String> availableCalced) {
        String result = "";
        if (availableCalced.size() == 0) {
            return result;
        }
        for (String availableOrEmpty : availableCalced) {
            result = result + availableOrEmpty + BRIDGE_SEP;
        }
        return result;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> crossedBridge, boolean isSuccess) {
        printMapWithNew(crossedBridge.subList(0, crossedBridge.size() - 1), isSuccess, crossedBridge.get(crossedBridge.size() - 1));
    }

    private static String newGuessToString(boolean isSuccess, String position, String newPosition) {
        if (!position.equals(newPosition)) {
            return EMPTY;
        }
        if (isSuccess) {
            return BRIDGE_AVAILABLE;
        }
        return BRIDGE_NOT_AVAILABLE;
    }

    public static void printMapWithNew(List<String> crossedBridge, boolean isSuccess, String newPosition) {
        String upside = BRIDGE_START + arrToString(getMiddle(crossedBridge, UP))
                + newGuessToString(isSuccess, UP, newPosition) + BRIDGE_END;
        String downside = BRIDGE_START + arrToString(getMiddle(crossedBridge, DOWN))
                + newGuessToString(isSuccess, DOWN, newPosition) + BRIDGE_END;
        System.out.println(upside);
        System.out.println(downside);
        System.out.println();
    }


    private static String isSuccessToString(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> crossedBridge, boolean isSuccess, int tries) {
        System.out.println(Notice.FINAL_RESULT.getMessage());
        printMapWithNew(crossedBridge.subList(0, crossedBridge.size() - 1), isSuccess, crossedBridge.get(crossedBridge.size() - 1));
        System.out.println(Notice.SUCCESS_OR_NOT.getMessage() + isSuccessToString(isSuccess));
        System.out.println(Notice.TRIES.getMessage() + tries);
    }

    public static void printError(String errorMessage) {
        System.out.println(Notice.ERROR_START_WITH.getMessage() + errorMessage);
    }

    public static void printStartGame() {
        System.out.println(Notice.START_GAME.getMessage());
    }

    public static void printRequestBridgeSize() {
        System.out.println(Notice.REQUEST_BRIDGE_SIZE.getMessage());
    }

    public static void printRequestUpOrDown() {
        System.out.println(Notice.REQUEST_UP_DOWN.getMessage());
    }

    public static void printRequestRetryOrQuit() {
        System.out.println(Notice.REQUEST_RETRY_QUIT.getMessage());
    }
}
