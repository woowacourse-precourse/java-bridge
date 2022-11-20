package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.printMap;

public class Application {

    private static List<Boolean> gameStatus;
    public static void main(String[] args) {
        try {
            int bridgeSize = readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            BridgeGame game = new BridgeGame();
            setGame();
            System.out.println(bridge);
            while(true) {
                String input = readMoving();
                Boolean moveResult = game.move(bridge, input);
                gameStatus.add(moveResult);
                printMap(bridge, gameStatus);
                if(!moveResult) {
                    if(readGameCommand().equals("Q")) {
                        break;
                    }
                    setGame();
                    game.retry();
                }

            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void setGame() {
        gameStatus = new ArrayList<>();
    }
}
