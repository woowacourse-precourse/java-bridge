package game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import exception.UserInputException;
import utils.Invalidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    public static void run(List<String> bridge) {
        System.out.println(bridge);
        BridgeGame bridgeGame = new BridgeGame();
        for (int stage = 0; stage < bridge.size(); stage++) {
            try {
                OutputView.printMoveChoiceMessage();
                bridgeGame.play(bridge, Invalidator.isValidMoveValue(InputView.readMoving()));
            } catch (UserInputException e) {
                e.printStackTrace();
                stage--;
            }
        }
    }
}
