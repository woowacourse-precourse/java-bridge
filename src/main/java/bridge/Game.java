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
        this.size = checkSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker user = new BridgeMaker(bridgeNumberGenerator);
        List<String> userBridge = user.makeBridge(size);
        this.bridgeGame = new BridgeGame(userBridge);
        System.out.println(userBridge);
    }

    private int checkSize() {
        int input = InputView.readBridgeSize();
        if (!(3 <= input && input <= 20)) {
            throw new IllegalArgumentException("다리의 길이가 3이상 20이하가 아닙니다.");
        }
        return input;
    }

    public static void playGame() {
        int index = 0;
        String nowResult = "";
        int matchNum = 1;
        while (index != size) {
            String userDirection = checkUserDirection();
            nowResult = String.valueOf(bridgeGame.move(userDirection,index));
            OutputView.printMap(nowResult);
            index += 1;
            if (nowResult.contains("X")) {
                index = 0;
                String userRetry = checkUserRetry();
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

    private static String checkUserDirection() {
        String input = InputView.readMoving();
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("입력 방향이 U나 D가 아닙니다.");
        }
        return input;
    }

    private static String checkUserRetry() {
        String input = InputView.readGameCommand();
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("재시작 여부가 R이나 Q가 아닙니다.");
        }
        return input;
    }

    public static void endGame(String finalResult, boolean matchResult, int matchNum) {
        OutputView.printResult(finalResult, matchResult,matchNum);

    }
}
