package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String PRINT_SUCCESS = "성공";
    private final String PRINT_FAIL = "실패";
    private final String PRINT_GAME_RESULT_DESC = "최종 게임 결과";
    private final String PRINT_GAME_RESULT = "게임 성공 여부: ";
    private final String PRINT_GAME_COUNT = "총 시도한 횟수: ";
    private final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public void printStartMsg() {
        System.out.println(START_MESSAGE);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map);
    }

    public void printSuccessResult(int count) {
        System.out.println(PRINT_GAME_RESULT + PRINT_SUCCESS);
        System.out.println(PRINT_GAME_COUNT + count);
    }

    public void printFailResult(int count) {
        System.out.println(PRINT_GAME_RESULT + PRINT_FAIL);
        System.out.println(PRINT_GAME_COUNT + count);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, boolean result) {
        System.out.println(PRINT_GAME_RESULT_DESC);
        printMap(bridgeGame.getMap());
        if (result) {
            printSuccessResult(bridgeGame.getCount());
            return ;
        }
        printFailResult(bridgeGame.getCount());
    }
}
