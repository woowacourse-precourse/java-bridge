package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        List<String> bridge = start();
        boolean playgame = true, isSuccess = false;
        int count = 0;
        while (playgame) {
            count++;
            isSuccess = play(bridge);
            if (isSuccess) break;
            playgame = bridgeGame.retry(inputView.readGameCommand());
        }
        quit(isSuccess,count);
    }

    /**
     * 게임 시작
     */
    public static List<String> start() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int size = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

    /**
     * 1회 플레이 시작하는 메서드
     * 게임 성공여부 반환한다.
     */
    public static boolean play(List<String> bridge) {
        List<String> userPosition = new ArrayList<>();
        boolean isCorrect = true;
        while (isCorrect) { // move를 실행한다. true이면 게임을 계속한다.
            isCorrect = bridgeGame.move(bridge, userPosition, inputView.readMoving());
            outputView.printMap(bridge,userPosition);
            if (userPosition.equals(bridge)) return true;
        }
        return false;
    }

    /**
     * 게임 종료
     */
    public static void quit(boolean isSuccess,int count) {
        outputView.printResult(isSuccess, count);
    }
}
