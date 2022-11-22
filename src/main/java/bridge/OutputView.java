package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_COMMENT = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_END_COMMENT = "최종 게임 결과";
    private static final String GAME_SUCCESS_FAULT = "게임 성공 여부 ";
    private static final String GAME_TRY_COUNT = "총 시도한 횟수: ";
    private static final String RESULT_START = "[ ";
    private static final String RESULT_END = " ]";
    private static final String SUCCESS = "성공";
    private static final String FAULT = "실패";

    public static void printStart(){
        System.out.println(GAME_START_COMMENT);
        System.out.println();
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<List<String>> result) {
        print(result.get(0));
        print(result.get(1));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<List<String>> result, int retryCount, boolean goAlright) {
        System.out.println(GAME_END_COMMENT);
        print(result.get(0));
        print(result.get(1));
        System.out.println();

        printSuccess(goAlright);
        printCount(retryCount);
    }

    private static void print(List<String> resultString){
        System.out.println(RESULT_START);
        String tmpString = String.join(" | ", resultString);
        System.out.print(tmpString);
        System.out.println(RESULT_END);
    }

    private static void printSuccess(boolean goAlright){
        System.out.print(GAME_SUCCESS_FAULT);
        if(goAlright){
            System.out.println(SUCCESS);
            return;
        }
        System.out.println(FAULT);
    }

    private static void printCount(int retryCount){
        System.out.print(GAME_TRY_COUNT);
        System.out.println(retryCount);
    }
}
