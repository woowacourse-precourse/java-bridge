package bridge.viewer;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String startMessage = "다리 건너기 게임을 시작합니다.";
    public static void printStart() {
        System.out.println(startMessage);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    //index => 현재까지 진행된 index
    public static void printMap(char[][] map, int index) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            sb.append("[");
            for(int j = 0; j <= index; j++) sb.append(" " + map[i][j] + " |");
            sb.deleteCharAt(sb.length()-1);
            sb.append("]" + System.getProperty("line.separator"));
        }
        System.out.println(sb.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static   void printResult() {
    }
}
