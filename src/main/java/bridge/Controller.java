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
    public void start() {
        oView.printStart();
        int input = iView.readBridgeSize();
        BridgeRandomNumberGenerator rng = new BridgeRandomNumberGenerator();
        this.bridgeGame = new BridgeGame(new BridgeMaker(rng).makeBridge(input));
    }

    /**
     * input user command, move user
     */
    public void move() {
        while (true) {
            String command = iView.readMoving();
            List<String> user = bridgeGame.move(command);
            oView.printMap(user);
            if (user.get(user.size()-1).length() > 1) {
                break;
            }
        }
    }

    public boolean askRetry() {
        String command = iView.readGameCommand();
        boolean re = command.equals("R");
        return re;
    }


}
