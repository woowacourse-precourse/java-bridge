package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private final String IS_GOAL_MESSAGE = "게임 성공 여부: ";
    private final String NUM_OF_TRIAL = "총 시도한 횟수: ";

    public void openingMention() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public void printMap(List<List<String>> bridgeMap) {

        for (int i = 0; i < bridgeMap.size(); i++) {
            for (int j = 0; j < bridgeMap.get(i).size(); j++) {
                System.out.print(bridgeMap.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void clearMessage(boolean clear) {
        System.out.println();
        System.out.print(IS_GOAL_MESSAGE);
        if (clear == true) {
            System.out.println("성공");
            return;
        }
        System.out.println("실패");
    }
    public void printResult(List<List<String>> bridgeMap, boolean clear, int trial) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(bridgeMap);
        System.out.println();
        clearMessage(clear);
        System.out.println(NUM_OF_TRIAL + trial);
    }
}
