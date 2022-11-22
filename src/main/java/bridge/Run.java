package bridge;

import java.util.ArrayList;
import java.util.List;

public  class Run {
    private static List<String> bridgeNumberList = new ArrayList<>();
    static InputView userInput = new InputView();
    static OutputView display = new OutputView();

    public static void run(BridgeGame Game) {
        gameSetting();

        while (!gameRun(Game)) {
            OutputView.getRetryMessage();
            if (userInput.readGameCommand().equals("Q")) {
                break;
            }
            Game.retry();
        }
        printTotalResult(Game, Game.getCount());
    }
    private static void gameSetting() {
        OutputView.getStartMessage();
        OutputView.getInputSizeMessage();
        BridgeRandomNumberGenerator gameRandomNumber = new BridgeRandomNumberGenerator();
        BridgeMaker makeBridge = new BridgeMaker(gameRandomNumber);

        int bridgeSize = userInput.readBridgeSize();

        bridgeNumberList = makeBridge.makeBridge(bridgeSize);
    }

    private static boolean gameRun(BridgeGame Game) {
        for (int i = 0; i < bridgeNumberList.size(); i++) {
            OutputView.getMoveMessage();
            String moveUpOrDown = userInput.readMoving();
            boolean state = Game.move(bridgeNumberList.get(i), moveUpOrDown);
            display.printMap(Game.getBridgeLineOne(), Game.getBridgeLineTwo());
            if (state == false) {
                return false;
            }
        }
        return true;
    }

    private static void printTotalResult(BridgeGame Game, int count) {
        OutputView.getEndMessage();
        display.printMap(Game.getBridgeLineOne(), Game.getBridgeLineTwo());
        display.printResult(Game.getNowState(), count);
    }
}
