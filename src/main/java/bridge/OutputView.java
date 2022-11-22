package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    private static final String START_BRIDGE = "[ ";
    private static final String END_BRIDGE = " ]";
    private static final String BRIDGE_DIVISION = " | ";
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String SUCCESS_FAIL_MESSAGE = "게임 성공 여부: ";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    private static final String ERROR_MESSAGE_UP_DOWN = " 다리는 U와 D만 움직여야 합니다.";
    private static final String ERROR_MESSAGE_RETRY = " 재시작은 R과 Q로만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NUMBER = " 3과 20 사이의 자연수를 입력해주세요.";
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_SIZE_MESSAGE = "다리 길이를 입력해주세요.";
    private static final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String END_MESSAGE = "최종 게임 결과";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeLineOne, List<String> bridgeLineTwo) {
        System.out.println(START_BRIDGE + String.join(BRIDGE_DIVISION, bridgeLineOne) + END_BRIDGE);
        System.out.println(START_BRIDGE + String.join(BRIDGE_DIVISION, bridgeLineTwo) + END_BRIDGE);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean nowState, int gameCount) {
        if (nowState) {
            System.out.println(SUCCESS_FAIL_MESSAGE + SUCCESS_MESSAGE);
            System.out.println(COUNT_MESSAGE + gameCount);
        }
        if (!nowState) {
            System.out.println(SUCCESS_FAIL_MESSAGE + FAIL_MESSAGE);
            System.out.println(COUNT_MESSAGE + gameCount);
        }
    }

    public static String getErrorMessageUpOrDown() {
        return ERROR_MESSAGE + ERROR_MESSAGE_UP_DOWN;
    }

    public static String getErrorMessageInputTry() {
        return ERROR_MESSAGE + ERROR_MESSAGE_RETRY;
    }

    public static String getErrorMessageAllNumber() {
        return ERROR_MESSAGE + ERROR_MESSAGE_NUMBER;
    }

    public static void getStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void getInputSizeMessage() {
        System.out.println(INPUT_SIZE_MESSAGE);
    }

    public static void getRetryMessage() {
        System.out.println(RETRY_MESSAGE);
    }

    public static void getMoveMessage() {
        System.out.println(MOVE_MESSAGE);
    }

    public static void getEndMessage() {
        System.out.println(END_MESSAGE);
    }
}
