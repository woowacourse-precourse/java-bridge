package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String ERROR_START_WITH = "[ERROR] ";
    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_UP_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUEST_RETRY_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String TRIES = "총 시도한 횟수: ";
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
        for (String availableOrEmpty : availableCalced) {
            result = result + availableOrEmpty + BRIDGE_SEP;
        }
        result = result.substring(0, result.length() - BRIDGE_SEP.length());
        return result;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> crossedBridge) {
        String upside = BRIDGE_START + arrToString(getMiddle(crossedBridge, UP)) + BRIDGE_END;
        String downside = BRIDGE_START + arrToString(getMiddle(crossedBridge, DOWN)) + BRIDGE_END;
        System.out.println(upside);
        System.out.println(downside);
        System.out.println();
    }

    private static String newGuessToString(boolean isSuccess, String position, String newPosition) {
        if (!position.equals(newPosition)) {
            return BRIDGE_SEP + EMPTY;
        }
        if (isSuccess) {
            return BRIDGE_SEP + BRIDGE_AVAILABLE;
        }
        return BRIDGE_SEP + BRIDGE_NOT_AVAILABLE;
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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private static String isSuccessToString(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }
    public static void printResult(List<String> crossedBridge, boolean isSuccess, int tries) {
        System.out.println(FINAL_RESULT);
        printMapWithNew(crossedBridge.subList(0,crossedBridge.size()-1), isSuccess, crossedBridge.get(crossedBridge.size()-1));
        System.out.println(SUCCESS_OR_NOT + isSuccessToString(isSuccess));
        System.out.println(TRIES+ tries);
    }

    public static void printError(String errorMessage) {
        System.out.println(ERROR_START_WITH + errorMessage);
    }

    public static void printStartGame() {
        System.out.println(START_GAME);
    }

    public static void printRequestBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE);
    }

    public static void printRequestUpOrDown() {
        System.out.println(REQUEST_UP_DOWN);
    }

    public static void printRequestRetryOrQuit() {
        System.out.println(REQUEST_RETRY_QUIT);
    }
}
