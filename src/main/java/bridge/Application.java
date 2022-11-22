package bridge;

import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    private static final String PASS = "O";
    private static final String FAIL = "X";
    private static final String FAILURE = "FAIL";
    private static final String SUCCESS = "SUCCESS";
    private static final String CONTINUE = "CONTINUE";
    private static int tryCount = 0;

    public static void main(String[] args) {
        int bridgeSize = firstSetting();
        List<String> bridge = bridgeMaking(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String result = gaming(bridgeGame);
        String convertedResult = convert(result);
        outputView.printResult(bridgeGame, convertedResult, tryCount);
    }

    public static int firstSetting() {
        outputView.printStartMessage();
        while (true) {
            try {
                outputView.printBridgeSizeMessage();
                int bridgeSize = inputView.readBridgeSize();
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<String> bridgeMaking(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

    public static String getSelectedBridge() {
        while (true) {
            try {
                outputView.printMovingMessage();
                String selectedBridge = inputView.readMoving();
                return selectedBridge;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String gamingOneTry(BridgeGame bridgeGame) {
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            String selectedBridge = getSelectedBridge();
            String result = bridgeGame.move(selectedBridge);
            outputView.printMap(bridgeGame);
            if (result.equals(FAIL)) {
                return FAILURE;
            }
        }
        return SUCCESS;
    }

    public static String getRetryOrQuit() {
        outputView.printRetryMessage();
        String retryOrQuit = inputView.readGameCommand();
        return retryOrQuit;
    }

    public static String gaming(BridgeGame bridgeGame) {
        String checkNext = CONTINUE;
        while (checkNext.equals(CONTINUE)) {
            tryCount++;
            String result = gamingOneTry(bridgeGame);
            checkNext = checkResult(result);
            if(checkNext.equals(CONTINUE)){
                bridgeGame.retry();
            }
        }
        return checkNext;
    }

    public static String checkResult(String result){
        if (result.equals(FAILURE) && getRetryOrQuit().equals("Q")) {
            return FAILURE;
        }
        if (result.equals(SUCCESS)) {
            return SUCCESS;
        }
        return CONTINUE;
    }
    public static String convert(String result) {
        if (result.equals(SUCCESS)) {
            return "성공";
        }
        return "실패";
    }
}
