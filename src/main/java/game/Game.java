package game;

import inMemoryDB.GameData;
import utils.InputCheck;
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
            stage = operate(stage, bridge);
        }
        return gameData;
    }

    private int operate(int stage, List<String> bridge) {
        OutputView.printMoveChoiceMessage();
        bridgeGame.move(InputCheck.setMovingValue(), bridge.get(stage));
        OutputView.printMap(gameData.getMovingFloorDataSet(), gameData.getPassDataSet(), gameData.getDataSetSize());
        return GameOver.isGameOver(gameData.getPassDataSet().get(stage), stage, bridge.size());
    }
}
