package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    static final String BRIDGE_STATE = "[%s]\n";
    static final String END_GAME = "최종 게임 결과";
    static final String GAME_STATE = "게임 성공 여부: %s";
    static final String TRY_COUNT = "총 시도한 횟수: %d";
    static String upState = "";
    static String downState = "";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap() {
        List<String> upResult = UpDown.upBridges;
        List<String> downResult = UpDown.downBridges;
        upState = String.join("|", upResult);
        downState = String.join("|", downResult);
        System.out.printf(BRIDGE_STATE, upState);
        System.out.printf(BRIDGE_STATE, downState);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String gameState, int count) {
        System.out.println(END_GAME);
        printMap();
        System.out.println();
        System.out.printf(GAME_STATE, gameState);
        System.out.printf(TRY_COUNT, count);
    }
}
