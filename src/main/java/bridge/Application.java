package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int size;
        while (true) {
            try {
                size = InputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
        BridgeGame bridgeGame = new BridgeGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> generatedBridge = bridgeMaker.makeBridge(size);
        boolean successOrNot = false;
        boolean retry = true;
        int count = 0;
        List<String> nowBridge = new ArrayList<>();
        while (retry) {
            nowBridge.clear();
            count++;
            successOrNot = bridgeGame.game(nowBridge, generatedBridge);
            if (successOrNot && nowBridge.size() == generatedBridge.size()) {
                break;
            }
            retry = bridgeGame.retry();
        }
        OutputView.printResult(count, successOrNot, nowBridge, generatedBridge);
    }
}