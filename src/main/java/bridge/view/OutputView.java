package bridge.view;

import bridge.Bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_GAME_MESSAGE = "최종 게임 결과";
    private static final String IS_GAME_SUCCESS = "게임 성공 여부: ";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";

    public void printGameStart() {
        System.out.println(START_GAME_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Bridge> bridges) {
        for (int i = 0; i < bridges.size(); i++) {
            List<String> bridge = bridges.get(i).getBridge();
            for (int j = 0; j < bridge.size(); j++) {
                System.out.print(bridge.get(j));
            }
            System.out.println();
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int playCount) {
        System.out.println(IS_GAME_SUCCESS + result);
        System.out.println(TOTAL_TRY_COUNT + playCount);
    }

    public void printFinalGameResult() {
        System.out.println(FINAL_GAME_MESSAGE);
    }
}
