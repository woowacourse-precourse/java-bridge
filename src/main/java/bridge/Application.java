package bridge;

import java.util.List;

public class Application {

    private static InputView inputView = new InputView();
    private static int bridgeSize;
    private static List<String> bridge;
    private static String moving;
    private static BridgeGame bridgeGame;
    private static Map map = new Map();
    private static OutputView outputView = new OutputView();
    private static boolean isFail = false;
    private static String gameCommand;
    private static int attempt = 1;

    public static void main(String[] args) {
        start();
        enterBridgeSize();
        makeBridge();
        bridgeGame = new BridgeGame(bridge);
        int count = 0;
        while (count < bridgeSize) {
            enterMoving();
            String check = bridgeGame.move(moving, count);
            if (count == 0) {
                map.makeMap(moving, check);
            } else if (count < bridgeSize) {
                map.addMap(moving, check);
            }
            outputView.printMap(map.getUpMap(), map.getDownMap());
            if (check.equals("X")) {
                isFail = true;
                break;
            }
            count++;
        }
        if (isFail) {
            enterGameCommand();
            attempt += bridgeGame.retry(gameCommand);
        }
        if (gameCommand.equals("Q")) {
            outputView.printResult(map.getUpMap(), map.getDownMap());

        }
        if (count == bridgeSize - 1) {
            outputView.printResult(map.getUpMap(), map.getDownMap());
        }
    }

    public static void start() {
        System.out.println(GameMessage.START.getMessage());
    }

    public static void enterBridgeSize() {
        try {
            String userBridgeSize = inputView.readBridgeSize();
            Validator.validateNumber(userBridgeSize);
            int tempBridgeSize = Converter.convertToNumber(userBridgeSize);
            Validator.validateRange(tempBridgeSize);
            bridgeSize = tempBridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterBridgeSize();
        }
    }

    public static void makeBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }


    public static void enterMoving() {
        try {
            String userMoving = inputView.readMoving();
            Validator.validateLength(userMoving);
            Validator.validateMoving(userMoving);
            moving = userMoving;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterMoving();
        }
    }

    public static void enterGameCommand() {
        try {
            String userGameCommand = inputView.readGameCommand();
            Validator.validateLength(userGameCommand);
            Validator.validateGameCommand(userGameCommand);
            gameCommand = userGameCommand;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterGameCommand();
        }
    }
}
