package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Comparator comparator = new Comparator();
        BridgeGame bridgeGame = new BridgeGame();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        int count = 0;
        int round = 0;

        boolean ongoing = true;


        while (round <= bridgeSize && ongoing) {
            String moving = inputView.readMoving();
            boolean isCorrect = comparator.compare(bridge, round, moving);
            outputView.printMap(bridge, round, isCorrect);
            if (isCorrect){
                round++;
                continue;
            }
            String command = inputView.readGameCommand();
            ongoing = bridgeGame.retry(command);
            if (ongoing){
                round = 0;
                count++;
            }
        }
        outputView.printResult(ongoing, count);
    }
}
