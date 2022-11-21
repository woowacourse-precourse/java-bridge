package bridge;

import java.util.List;

public class Application {
    private static final int count = 0;
    private static int bridgeSize = getBridgeSize();
    static List<String> bridge = getBridge(bridgeSize);
    static BridgeGame bridgeGame = new BridgeGame(bridge);

    public static void main(String[] args) {
        System.out.println("bridge: " + bridge);
        while (!bridgeGame.isBridgeSuccess()) {
            bridgeGame.move(getMove());
            OutputView.printMap(bridge, bridgeGame.getChoice());
            if(!isRetry()) {
                break;
            }
        }
        printResult(bridgeGame.getCount(), bridgeGame.isBridgeSuccess());

    }

    public static boolean isRetry() {
        if(!bridgeGame.isRightChoice()) {
            String answer = getRetry();
            if (answer.equals("R")) {
                bridgeGame.retry();
                return true;
            }
            if (answer.equals("Q")) {
                return false;
            }
        }
        return true;
    }

    public static int getBridgeSize() {
        OutputView.startGame();
        OutputView.getBridgeSize();

        InputView inputView = new InputView();
        return inputView.readBridgeSize();
    }

    public static List<String> getBridge(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

    public static String getMove() {
        String answer = "";
        while (!(answer.equals("U") || answer.equals("D"))) {
            OutputView.getMove();
            answer = InputView.readMoving();
        }
        return answer;
    }

    public static String getRetry() {
        OutputView.getRetry();
        String answer = InputView.readGameCommand();
        return answer;
    }
    
    public static void printResult(int count, boolean isBridgeSuccess) {
        System.out.println("최종 게임 결과");
        OutputView.printMap(bridge, bridgeGame.getChoice());
        System.out.println();
        OutputView.printResult(count, isBridgeSuccess);
    }


}
