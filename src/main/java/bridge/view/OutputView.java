package bridge.view;

import bridge.message.PrintMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param nowResult 현재까지 이동한 다리의 상태
     */
    public static void printMap(String nowResult) {
        System.out.println(nowResult+'\n');
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String finalResult, boolean matchResult, int matchNumb) {
        PrintMessage.FINAL_RESULT.printMessage();
        System.out.println(finalResult+'\n');
        printMatchResult(matchResult);
        System.out.println("총 시도한 횟수: "+matchNumb);
    }

    private static void printMatchResult(boolean matchResult) {
        if (matchResult) {
            PrintMessage.MATCH_RESULT_SUCCESS.printMessage();
        }
        if (!matchResult) {
            PrintMessage.MATCH_RESULT_FAILED.printMessage();
        }
    }
}
