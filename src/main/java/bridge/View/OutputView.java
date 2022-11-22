package bridge.View;

import bridge.Domain.State;
import bridge.Domain.UserBridges;

import java.util.List;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ENTER_MOVING_SPACE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_OR_QUIT = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String BRACKET_START = "[ ";
    private static final String BRACKET_END = " ]";
    private static final String SEPARATOR = " | ";

    private static final String GAME_RESULT = "\n최종 게임 결과";
    private static final String IS_SUCCESS = "\n게임 성공 여부: ";
    private static final String YES = "성공";
    private static final String NO = "실패";
    private static final String TRY_COUNT = "총 시도한 횟수: ";

    private OutputView() {}

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(UserBridges userBridges) {
        printEachBridge(userBridges.getUpperSpaces());
        printEachBridge(userBridges.getLowerSpaces());
    }

    public static void printEachBridge(List<String> spaces) {
        System.out.print(BRACKET_START);
        for (int i = 0; i < spaces.size(); i++) {
            System.out.print(spaces.get(i));

            if (i != spaces.size() - 1)
                System.out.print(SEPARATOR);
        }
        System.out.println(BRACKET_END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(UserBridges userBridges, State currentState, int tries) {
        System.out.println(GAME_RESULT);
        printMap(userBridges);

        if (currentState == State.END_OF_BRIDGE)
            System.out.println(IS_SUCCESS + YES);
        if (currentState == State.QUIT)
            System.out.println(IS_SUCCESS + NO);
        System.out.println(TRY_COUNT + tries);
    }

    public static void printGameStart() {
        System.out.println(GAME_START);
    }

    public static void printEnterBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE);
    }

    public static void printEnterMovingSpace() {
        System.out.println(ENTER_MOVING_SPACE);
    }

    public static void printRetryOrQuit() {
        System.out.println(RETRY_OR_QUIT);
    }
}
