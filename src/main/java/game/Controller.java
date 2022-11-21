package game;

import exception.UserInputException;
import inMemoryDB.GameData;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    public static GameData run(List<String> bridge) {
        System.out.println(bridge);
        GameData gameData = new GameData();
        BridgeGame bridgeGame = new BridgeGame(gameData);
        for (int stage = 0; stage < bridge.size(); stage++) {
            try {
                OutputView.printMoveChoiceMessage();
                bridgeGame.move(InputView.readMoving(), bridge.get(stage));
                OutputView.printMap(gameData.getMovingFloorDataSet(), gameData.getPassDataSet(), gameData.getDataSetSize());
                stage = GameOver.isGameOver(gameData.getPassDataSet().get(stage), stage, bridge.size());
            } catch (UserInputException e) {
                e.printStackTrace();
                stage--;
            }
        }
        return gameData;
    }
}