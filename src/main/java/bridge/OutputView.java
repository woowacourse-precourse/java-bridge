package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_MAP = "[ ";
    private static final String END_MAP = " ]";
    private static final String START = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String USER_MOVE = "이동할 칸을 선택해주세요. ";
    private static final String RETRY = "게임을 다시 시도할지 여부를 입력해주세요.";
    private static final String RESULT = "게임 성공 여부";
    private static final String RESULT_COUNT = "총 시도한 횟수: ";
    private static final String END = "최종 게임 결과";
    private static final String ERROR = "[ERROR]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printStart() {
        System.out.println(START);
    }

    public void printSize() {
        System.out.println(BRIDGE_SIZE);
    }

    public void printMove() {
        System.out.println(USER_MOVE);
    }

    public void printRetry() {
        System.out.println(RETRY);
    }

    public void printError() {
        System.out.println(ERROR);
    }

    public void printMap(GameSimulation game) {
        for (int i=0; i <2 ; i++) {
            System.out.println(START_MAP);
            List<String> map = game.getbridge().get(i);
            printShape(map);
            System.out.println(END_MAP);
        }
    }

    private void printShape(List<String> map) {
        String s = String.join("|",map);
        System.out.println(s);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameSimulation game, int count) {
        System.out.println(END);
        printMap(game);
        System.out.println(RESULT+game.getSuccess());
        System.out.println(RESULT_COUNT+count);
    }
}
