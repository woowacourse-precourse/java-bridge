package bridge;

import static bridge.BridgeGame.WRONG;
import static bridge.BridgeGame.downstairsBridge;
import static bridge.BridgeGame.upstairsBridge;

import java.util.List;
import java.util.Objects;
import bridge.BridgeGame.*;

public class Application {

    public static void main(String[] args) {
//        int i = 0;
//        do {
//            System.out.println(i++);
//        }
//        while (i < 3);
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        outputView.gameStart();

        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame();

        int numberOfTriedAnswers;
        do {
            outputView.enterMoveDirection();
            String direction = inputView.readMoving();
            System.out.println(numberOfTriedAnswers = BridgeGame.getAnswerCount(direction));

            bridgeGame.move(direction, bridge, numberOfTriedAnswers);
            outputView.printMap(upstairsBridge, downstairsBridge);

            if (upstairsBridge.contains(WRONG) || downstairsBridge.contains(WRONG)) {
                System.out.println("게임 더할래?");
                String command = inputView.readGameCommand();
                bridgeGame.retry(command);
                System.out.println("게임 성공 여부");
                System.out.println("총 시도 횟수");
            }
        }
        while (upstairsBridge.contains(WRONG) || downstairsBridge.contains(WRONG) ||size > numberOfTriedAnswers);
        System.out.println("게임종료");

    }
}
