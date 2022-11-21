package bridge;

import java.util.List;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static Map map = new Map();
    private static BridgeSize bridgeSize;
    private static List<String> bridge;
    private static BridgeGame bridgeGame;
    private static int attempt = 1;
    private static String result = "성공";

    public static void start() {
        System.out.println(GameMessage.START.getMessage());
    }

    public static void enterBridgeSize() {
        try {
            bridgeSize = new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterBridgeSize();
        }
    }

    public static void makeBridge() {
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize.getBridgeSize());
    }

    public static void enterMoving() {
        try {
            Moving.validateInput(inputView.readMoving());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterMoving();
        }
    }

    public static void playGame() {
        for (int count = 0; count < bridgeSize.getBridgeSize(); count++) {
            enterMoving();
            String check = bridgeGame.move(Moving.getMoving(), count);
            map.makeMap(Moving.getMoving(), check);
            outputView.printMap(map.getUpMap(), map.getDownMap());
            if (check.equals("X")) {
                reGame();
                break;
            }
        }
    }

    public static void enterGameCommand() {
        try {
            GameCommand.validateInput(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterGameCommand();
        }
    }

    public static void reGame() {
        enterGameCommand();
        attempt += bridgeGame.retry(GameCommand.getGameCommand());
        if (GameCommand.getGameCommand().equals(GameCommandResult.QUIT.getGameCommand())) {
            result = GameCommandResult.QUIT.getResult();
        }
        if (GameCommand.getGameCommand().equals(GameCommandResult.RETRY.getGameCommand())) {
            map.resetMap();
            playGame();
        }
    }

    public static void showResult() {
        outputView.printResult(map.getUpMap(), map.getDownMap());
        outputView.printSuccessOrFail(result);
        outputView.printAttempt(attempt);
    }

    public static void main(String[] args) {
        start();
        enterBridgeSize();
        makeBridge();
        bridgeGame = new BridgeGame(bridge);
        playGame();
        showResult();
    }
}
