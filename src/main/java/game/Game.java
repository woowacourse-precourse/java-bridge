package game;

import exception.UserInputException;
import inMemoryDB.GameData;
import view.InputView;
import view.OutputView;
import java.util.List;

public class Game {

    GameData gameData;
    BridgeGame bridgeGame;

    public Game() {
        this.gameData = new GameData();
        this.bridgeGame = new BridgeGame(gameData);
    }

    public GameData play(List<String> bridge) {
        for (int stage = 0; stage < bridge.size(); stage++) {
            try {
                stage = operate(stage, bridge);
            } catch (UserInputException e) {
                System.out.println(e.getMessage());
                stage--;
            }
        }
        return gameData;
    }

    private int operate(int stage, List<String> bridge) {
        OutputView.printMoveChoiceMessage();
        bridgeGame.move(InputView.readMoving(), bridge.get(stage));
        OutputView.printMap(gameData.getMovingFloorDataSet(), gameData.getPassDataSet(), gameData.getDataSetSize());
        return GameOver.isGameOver(gameData.getPassDataSet().get(stage), stage, bridge.size());
    }
}