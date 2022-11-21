package game;

import exception.UserInputException;
import inMemoryDB.GameData;
import utils.Invalidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    public static void run(List<String> bridge) {
        System.out.println(bridge);
        GameData gameData = new GameData();
        BridgeGame bridgeGame = new BridgeGame(gameData);
        for (int stage = 0; stage < bridge.size(); stage++) {
            try {
                OutputView.printMoveChoiceMessage();
                bridgeGame.move(Invalidator.isValidMoveValue(InputView.readMoving()), bridge.get(stage));
            } catch (UserInputException e) {
                e.printStackTrace();
                stage--;
            }
        }
        System.out.println(gameData.getPassDataSet());
        System.out.println(gameData.getMovingFloorDataSet());
    }
}
