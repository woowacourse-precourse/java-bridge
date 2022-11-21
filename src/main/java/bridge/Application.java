package bridge;

public class Application {

    private static BridgeGame bridgeGame;
    private static InputView inputView;
    private static OutputView outputView;
    private static int bridgeSize;
    private static boolean continueFlag = true;

    public static void main(String[] args) {
        init();
        play();
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getUserSteps(), bridgeGame.getTrial());
    }

    private static void play() {
        while (continueFlag) {
            boolean result = bridgeGame.retry();
            while (result && bridgeGame.getUserSteps().size() < bridgeSize) {
                result = moveStep();
            }
            if (bridgeGame.getUserSteps().size() >= bridgeSize && result) {
                break;
            }
            continueFlag = getValidCommandInput().equals("R");
        }
    }

    private static boolean moveStep() {
        String direction = getValidDirectionInput();
        boolean result = bridgeGame.move(direction);
        outputView.printMap(bridgeGame.getUserSteps());
        return result;
    }

    private static void init() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        outputView = new OutputView();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeSize = getValidBridgeInput();
        bridgeGame.buildBridge(bridgeMaker.makeBridge(bridgeSize));
        outputView.setBridge(bridgeGame.getBridge());
    }

    private static int getValidBridgeInput() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    private static String getValidDirectionInput() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    private static String getValidCommandInput() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }
}
