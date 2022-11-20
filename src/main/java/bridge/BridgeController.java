package bridge;

import java.util.List;

public class BridgeController {
    public static BridgeGame game = new BridgeGame();

    public void run() {
        try {
            List<String> bridge = createBridge();
            play(bridge, game);
            OutputView.printResult(bridge, game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> createBridge() {
        OutputView.printStart();
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(InputView.readBridgeSize());
    }

    private void play(List<String> bridge, BridgeGame game) {
        do {
            boolean roundResultSuccess = crossBridge(bridge, game);
            if (!roundResultSuccess) {
                retryOrExit(InputView.readGameCommand(), game);
            }
        } while (!game.isEnd(bridge));

    }

    private boolean crossBridge(List<String> bridge, BridgeGame game) {
        boolean roundResult = game.move(bridge, InputView.readMoving());
        OutputView.printMap(bridge, game.getMovingResult());
        return roundResult;
    }

    private void retryOrExit(String command, BridgeGame game) {
        if ("R".equals(command)) {
            game.retry();
        }
        if ("Q".equals(command)) {
            game.end();
        }
    }
}
