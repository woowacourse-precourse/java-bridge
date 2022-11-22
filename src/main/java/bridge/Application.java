package bridge;

import java.util.ArrayList;
import java.util.List;
public class Application {

    private static List<String> bridgeNumberList = new ArrayList<>();
    static InputView userInput = new InputView();
    static OutputView display = new OutputView();
    static BridgeGame Game = new BridgeGame();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }

    private static void run() {
        gameSetting();

        while (!gameRun()) {
            OutputView.getRetryMessage();
            if (userInput.readGameCommand().equals("Q")) {
                break;
            }
            Game.retry();
        }
        printTotalResult(Game.getCount());
    }
    private static void gameSetting() {
        OutputView.getStartMessage();
        OutputView.getInputSizeMessage();
        BridgeRandomNumberGenerator gameRandomNumber = new BridgeRandomNumberGenerator();
        BridgeMaker makeBridge = new BridgeMaker(gameRandomNumber);

        int bridgeSize = userInput.readBridgeSize();

        bridgeNumberList = makeBridge.makeBridge(bridgeSize);
    }

    private static boolean gameRun() {
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

    private static void printTotalResult(int count) {
        OutputView.getEndMessage();
        display.printMap(Game.getBridgeLineOne(), Game.getBridgeLineTwo());
        display.printResult(Game.getNowState(), count);
    }

}
