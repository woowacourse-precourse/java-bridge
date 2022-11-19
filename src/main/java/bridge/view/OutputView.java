package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStartGame() {
        System.out.println(Constants.START_GAME_OUTPUT);
    }

    public void printRequestBridgeSizeInput() {
        System.out.println(Constants.REQUEST_BRIDGE_SIZE_INPUT);
    }
    public void printSelectUpOrDownInput() {
        System.out.println(Constants.SELECT_UP_OR_DOWN_INPUT);
    }
    public void printSelectRetryOrNotInput() {
        System.out.println(Constants.SELECT_RETRY_OR_NOT_INPUT);
    }
    public void printFinalGameResult() {
        System.out.println(Constants.FINAL_GAME_RESULT_OUTPUT);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map);
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String map, boolean isSuccess, int numberOfTry) {
    }
}
