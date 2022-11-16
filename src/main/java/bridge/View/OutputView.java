package bridge.View;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String MAP_START_PART = "[ ";
    private static final String MAP_MIDDLE_PART = " | ";
    private static final String MAP_END_PART = " ]";
    private static final String RESULT = "최종 게임 결과";

    public void printStart() {
        System.out.println(GAME_START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map) {
        System.out.print(MAP_START_PART);
        for (int i = 0; i < map.size() - 1; i++) {
            System.out.print(map.get(i));
            System.out.print(MAP_MIDDLE_PART);
        }
        System.out.print(map.get(map.size() - 1));
        System.out.println(MAP_END_PART);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
