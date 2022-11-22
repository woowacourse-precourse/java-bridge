package bridge;

import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeGame bridgeGame = new BridgeGame(inputView, outputView);

    public static void main(String[] args) {
        List<String> bridge = start();
        boolean playgame = true, isSuccess = false;
        int count = 0;
        while (playgame) {
            count++;
            isSuccess = bridgeGame.play(bridge);
            if (isSuccess)
                break;
            else {
                playgame = bridgeGame.retry();
            }
        }
        quit(isSuccess,count);
    }

    public static List<String> start() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int size = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

    public static void quit(boolean isSuccess,int count) {
        outputView.printResult(isSuccess, count);
    }
}
