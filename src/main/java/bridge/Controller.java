package bridge;

import View.InputView;
import View.OutputView;

import java.util.List;

public class Controller {
    private final InputView iView;
    private final OutputView oView;

    private BridgeGame bridgeGame;

    public Controller(InputView iView, OutputView oView) {
        this.iView = iView;
        this.oView = oView;
    }

    /**
     * input Bridge length and create Bridge
     */
    public int start() {
        int input = iView.readBridgeSize();
        BridgeRandomNumberGenerator rng = new BridgeRandomNumberGenerator();
        this.bridgeGame = new BridgeGame(new BridgeMaker(rng).makeBridge(input));
        return 0;
    }

    /**
     * input user command, move user
     * @return return BridgeGame.getEndGame()
     * 0 - not end, 1 - failure, 2- success
     */
    public int move() {
        while (true) {
            String command = iView.readMoving();
            List<String> user = bridgeGame.move(command);
            oView.printMap(user);
            if(bridgeGame.getEndGame() > 0) {
                return bridgeGame.getEndGame();
            }
        }
    }

    /**
     * ask for user you end game
     * @return 1 - retry, 0 - end game
     */
    public int askRetry() {
        String command = iView.readGameCommand();
        boolean re = command.equals("R");
        if (re) {
            bridgeGame.retry();
            return 1;
        }
        return 0;
    }

    /**
     * print result
     */
    public void result() {
        oView.printResult(bridgeGame.getUser(), bridgeGame.getTryCounts());
    }


}
