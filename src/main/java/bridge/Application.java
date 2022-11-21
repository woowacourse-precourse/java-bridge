package bridge;

import java.util.List;

public class Application {
    public static OutputView outputView = new OutputView();
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeGame bridgeGame = new BridgeGame(new InputView(), new BridgeMaker(new BridgeRandomNumberGenerator()));
        List<String> bridge = bridgeGame.bridgeMaker.makeBridge(bridgeGame.getBridgeSize());
        int cnt = 0, trial = 1;
        while (true) {
            boolean correct = bridgeGame.move().equals(bridge.get(cnt++));
            outputView.printMap(bridge, cnt, correct);
            if (cnt == bridge.size()) break;
            if(correct) continue;
            if (!bridgeGame.retry()) break;
            trial++; cnt = 0;
        }
        showResult(bridge, cnt, trial);
    }
    public static void showResult(List<String> bridge, int cnt, int trial) {
        outputView.printResult(bridge, cnt, trial);
    }
}
