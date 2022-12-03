package bridge.View;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String GET_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String GET_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GET_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String RESULT = "최종 게임 결과";
    private static final String GAME_RESULT = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String GAME_TOTAL = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(GAME_START);
        System.out.println();
    }

    public void printGetBridgeSize() {
        System.out.println(GET_BRIDGE_SIZE);
    }

    public void printGetMoving() {
        System.out.println();
        System.out.println(GET_MOVING);
    }

    public void printGetGameCommand() {
        System.out.println();
        System.out.println(GET_GAME_COMMAND);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String mapReuslt) {
        System.out.println(mapReuslt);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String mapResult, boolean gameResult, int count) {
        System.out.println();
        System.out.println(RESULT);
        System.out.println(mapResult);
        System.out.println();
        printGameResult(gameResult);
        printGameTotalCount(count);
    }

    private void printGameResult(boolean gameResult) {
        System.out.print(GAME_RESULT);
        if (!gameResult) {
            System.out.println(FAIL);
        }
        if (gameResult) {
            System.out.println(SUCCESS);
        }
    }

    private void printGameTotalCount(int count) {
        System.out.print(GAME_TOTAL);
        System.out.println(count);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
