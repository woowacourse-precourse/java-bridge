package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Game {

    static int size;
    static BridgeGame bridgeGame;

    public Game() {
        makeBridge();
        playGame();
    }

    private void makeBridge() {
        this.size = InputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker user = new BridgeMaker(bridgeNumberGenerator);
        List<String> userBridge = user.makeBridge(size);
        this.bridgeGame = new BridgeGame(userBridge);
        System.out.println(userBridge);
    }

    public static void playGame() {
        int index = 0;
        String nowResult = "";
        int matchNum = 1;
        while (index != size) {
            String userDirection = InputView.readMoving();
            nowResult = String.valueOf(bridgeGame.move(userDirection,index));
            OutputView.printMap(nowResult);
            index += 1;
            if (nowResult.contains("X")) {
                index = 0;
                String userRetry = InputView.readGameCommand();
                if (userRetry.equals("Q")) {
                    break;
                }
                matchNum += 1;
                bridgeGame.retry();
            }
        }
        if (index == size) {
            endGame(nowResult,true,matchNum);
        }
        if (index != size) {
            endGame(nowResult,false,matchNum);
        }
    }

    public static void endGame(String finalResult, boolean matchResult, int matchNum) {
        OutputView.printResult(finalResult, matchResult,matchNum);

    }
}
