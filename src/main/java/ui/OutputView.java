package ui;

import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private final String GAME_SUCCESS_RESULT = "게임 성공 여부: ";
    private final Map<Boolean, String> GAME_RESULT = Map.of(true, "성공",
            false, "실패");
    private final String GAME_TRY = "총 시도한 횟수: ";
    private final String FINAL_GAME_MAP = "최종 게임 결과";

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printResult(final boolean result) {
        System.out.println(GAME_SUCCESS_RESULT + GAME_RESULT.get(result));
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameTryResultMessage(int userTry) {
        System.out.println(GAME_TRY + userTry);
    }

    private void printFinalGameMapMessage() {
        System.out.println(FINAL_GAME_MAP);
    }

    public void printFinalGameMap(String map) {
        printFinalGameMapMessage();
        printMap(map);
    }
}
