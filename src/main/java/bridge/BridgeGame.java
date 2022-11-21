package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static boolean gameStatus = true;
    static int gameCount = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void move(BridgeData bridgeData, String input) {
        if (!bridgeData.getBridge().get(bridgeData.getCurrentPosition()).equals(input)){
            OutputView.printMap_Wrong(bridgeData, input);
            retry();
        }
        if (bridgeData.getBridge().get(bridgeData.getCurrentPosition()).equals(input)){
            OutputView.printMap(bridgeData, input);
            bridgeData.updatePosition();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void retry() {
        String command = InputView.readGameCommand();
        if (command.equals("R")){
            gameCount++;
        }
        if (command.equals("Q")){
            gameStatus = false;
        }
    }
}
