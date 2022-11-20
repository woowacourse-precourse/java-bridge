package bridge.View;

import bridge.Domain.History;
import bridge.Domain.UserBridge;

import java.util.List;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ENTER_SPACE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String IS_SUCCESS = "게임 성공 여부: ";
    private static final String TRY_COUNT = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(History gameHistory, int location) {
        printEachBridge(gameHistory.getUpperBridge(), location);
        printEachBridge(gameHistory.getLowerBridge(), location);
    }

    public static void printEachBridge(UserBridge bridge, int location) {
        System.out.print("[ ");
        for (int i = 0; i < location; i++) {
            String space = bridge.getSpaceByLocation(i);
            System.out.print(space);

            if (i != location -1)
                System.out.print(" | ");
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(History gameHistory, int location) {
        System.out.println(GAME_RESULT);
        printMap(gameHistory, location);

        if (gameHistory.isSuccess())
            System.out.println(IS_SUCCESS + "성공");
        if (!gameHistory.isSuccess())
            System.out.println(IS_SUCCESS + "실패");
        System.out.println(TRY_COUNT + gameHistory.getTries());
    }

    public static void printGameStart() {
        System.out.println(GAME_START);
    }

    public static void printEnterBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE);
    }
}
