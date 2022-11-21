package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker user = new BridgeMaker(bridgeNumberGenerator);
        int size = InputView.readBridgeSize();
        List<String> userBridge = user.makeBridge(size);
        BridgeGame Game = new BridgeGame(userBridge);
        System.out.println(userBridge);
        playGame(size, Game);
    }

    public static void playGame(int size, BridgeGame Game) {
        int index = 0;
        while (index != size) {
            String userDirection = InputView.readMoving();
            String nowResult = String.valueOf(Game.move(userDirection,index));
            OutputView.printMap(nowResult);
            index += 1;
            if (nowResult.contains("X")) {
                String userRetry = InputView.readGameCommand();
                if (userRetry.equals("Q")) {
                    break;
                }
                index = 0;
                Game.retry();
            }
        }
    }
}
