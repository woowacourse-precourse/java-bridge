package bridge.view;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_NEXT_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String TRIAL_COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String OPEN_BRIDGE = "[ ";
    private static final String CLOSE_BRIDGE = " ]";
    private static final String BRIDGE_PARTITION = " | ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
        printBlankLine();
    }

    public static void printBridgeSizeInputMessage() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public static void printNextMovementInputMessage() {
        System.out.println(INPUT_NEXT_MOVEMENT);
    }

    public static void printMap(List<List<Character>> map) {
        printOneLineOfBridge(map.get(0));
        printOneLineOfBridge(map.get(1));
        printBlankLine();
    }

    public static void printRestartMessage() {
        System.out.println(INPUT_RESTART);
    }

    public static void printResultHeader() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printResult(boolean success, int trialCount) {
        printSuccessOrNot(success);
        printTrialCount(trialCount);
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    private static void printOneLineOfBridge(List<Character> line) {
        int lastIndex = line.size() - 1;
        System.out.print(OPEN_BRIDGE);
        for (int i = 0; i < lastIndex; i++) {
            System.out.print(line.get(i));
            System.out.print(BRIDGE_PARTITION);
        }
        System.out.print(line.get(lastIndex));
        System.out.println(CLOSE_BRIDGE);
    }

    private static void printSuccessOrNot(boolean success) {
        System.out.print(SUCCESS_RESULT_MESSAGE);
        if (success) {
            System.out.println(SUCCESS);
            return;
        }
        System.out.println(FAIL);
    }

    private static void printTrialCount(int trialCount) {
        System.out.print(TRIAL_COUNT_MESSAGE);
        System.out.println(trialCount);
    }
}
