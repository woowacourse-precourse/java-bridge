package bridge;

import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BLANK_LINE = "";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String IS_GAME_SUCCESS = "게임 성공 여부: ";
    private static final String UP = "U";
    private static final String DOWN = "D";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String UpLine, String DownLine) {
        System.out.println("[ " + UpLine + " ]");
        System.out.println("[ " + DownLine + " ]");
        System.out.println(BLANK_LINE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Map<String, String> mapResult, boolean isSuccess, int gameCount) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(mapResult.get(UP), mapResult.get(DOWN));

        printGameResult(isSuccess);
        System.out.print(TOTAL_TRY_COUNT + gameCount);
    }

    private void printGameResult(boolean isSuccess) {
        String isSuccessByKorean = "";
        if (isSuccess) {
            isSuccessByKorean = SUCCESS;
        }
        if (!isSuccess) {
            isSuccessByKorean = FAIL;
        }
        System.out.println(IS_GAME_SUCCESS + isSuccessByKorean);
    }
}
