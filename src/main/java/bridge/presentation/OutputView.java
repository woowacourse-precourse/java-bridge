package bridge.presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private final String STARTING_SENTENCE = "다리 건너기 게임을 시작합니다." + System.lineSeparator() + "다리의 길이를 입력해주세요.";
    private final String MOVING_SENTENCE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RESTART_SENTENCE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String END_SENTENCE = "최종 게임 결과";
    private final String SUCCESS_SENTENCE = "게임 성공 여부: ";
    private final String CHALLENGE_SENTENCE = "총 시도한 횟수: ";

    public void printMap(List<String> userSelectResult, boolean success) {
        ReturnPrintMap returnPrintMap = new ReturnPrintMap();
        Map<String, String> contentsMap = returnPrintMap.returnContentsMap(userSelectResult,success);
        System.out.println("[ " + contentsMap.get("upContents") + " ]");
        System.out.println("[ " + contentsMap.get("downContents") + " ]");
    }//printMap

    public void printResult(List<String> userSelectResult, boolean success, boolean gameSuccess, int challengeCount) {
        String successResult = "실패";
        if (gameSuccess) {
            successResult = "성공";
        }//if
        System.out.println(END_SENTENCE);
        printMap(userSelectResult, success);
        System.out.println(SUCCESS_SENTENCE + successResult);
        System.out.println(CHALLENGE_SENTENCE + challengeCount);
    }//printResult

    public void startGuide() {
        System.out.println(STARTING_SENTENCE);
    }//startGuide

    public void moveGuide() {
        System.out.println(MOVING_SENTENCE);
    }//moveGuide

    public void restartGuide() {
        System.out.println(RESTART_SENTENCE);
    }//restartGuide

}// end class
