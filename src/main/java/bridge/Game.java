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
        while ((index != size) && (index != -1)) {
            nowResult = printNowResult(index);
            index += 1;
            if (nowResult.contains("X")) {
                index = retryGame();
            }
        }
        resultGame(index, nowResult, bridgeGame.printMatchNum());
    }

    private static int retryGame() {
        if (InputView.readGameCommand().equals("R")) {
            bridgeGame.retry();
            return 0;
        }
        return -1;
    }

    private static void resultGame(int index, String nowResult, int matchNum) {
        if (index == size) {
            endGame(nowResult,true,matchNum);
        }
        if (index != size) {
            endGame(nowResult,false,matchNum);
        }
    }

    private static String printNowResult(int index) {
        String nowResult = bridgeGame.move(InputView.readMoving(),index);
        OutputView.printMap(nowResult);
        return nowResult;
    }

    public static void endGame(String finalResult, boolean matchResult, int matchNum) {
        OutputView.printResult(finalResult, matchResult,matchNum);
    }
}