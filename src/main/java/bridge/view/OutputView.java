package bridge.view;

import bridge.domain.SuccessOrNot;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String LINE_BREAK = "\r";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_FAIL_MESSAGE = "게임 성공 여부: ";
    private static final String RETRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    public static void showGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(LINE_BREAK);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridgeMap) {
        System.out.println(bridgeMap.get(0));
        System.out.println(bridgeMap.get(1));
        System.out.println(LINE_BREAK);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(boolean successOrNot, int numberOfAttempts, List<String> bridgeMap) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(bridgeMap);
        System.out.println(SUCCESS_FAIL_MESSAGE + checkSuccess(successOrNot));
        System.out.println(RETRY_COUNT_MESSAGE + numberOfAttempts);
    }

    public static String checkSuccess(boolean successOrNot) {
        if (successOrNot) {
            return SuccessOrNot.FAIL.getMessage();
        }
        return SuccessOrNot.SUCCESS.getMessage();
    }
}
