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
        BridgeGame bridgeGame = new BridgeGame();
        int count = 1;
        int round = 0;
        int resultRound = 0;
        boolean resultMovable = true;
        boolean ongoing = true;

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        while (round < bridgeSize && ongoing) {
            String moving = inputView.readMoving();
            boolean movable = bridgeGame.move(bridge, round, moving);
            outputView.printMap(bridge, round, movable);
            resultMovable = movable;
            resultRound = round;
            if (movable) {
                round++;
                continue;
            }
            String command = inputView.readGameCommand();
            ongoing = bridgeGame.retry(command);
            if (ongoing) {
                round = 0;
                count++;
            }
        }
        System.out.println("\n최종 게임 결과");
        outputView.printMap(bridge, resultRound, resultMovable);
        outputView.printResult(ongoing, count);
    }
}
