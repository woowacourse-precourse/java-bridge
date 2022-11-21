package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeMap bridge) {
        System.out.println(bridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        System.out.println(ConsoleMessage.GAME_RESULT);
        System.out.println(gameResult.getBridgeMap());
        printIsGameClear(gameResult.getGameClear());
        System.out.printf(String.valueOf(ConsoleMessage.TRY_COUNT), gameResult.getTryCount());
    }

    private void printIsGameClear(boolean isGameClear) {
        if (isGameClear) {
            System.out.println(ConsoleMessage.GAME_CLEAR);
            return;
        }
        System.out.println(ConsoleMessage.GAME_OVER);
    }
}
