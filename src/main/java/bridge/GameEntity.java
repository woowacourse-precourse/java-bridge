package bridge.persistence;

import bridge.BridgeGame;
import bridge.GameRepository;
import bridge.ui.UserInterface;

public class GameEntity extends BridgeGame implements GameRepository {
    private int tryCount;
    private UserInterface userInterface;

    public GameEntity() {



    }

    @Override
    public int manageRetryStatus(String gameCommand) {
        tryCount +=  new BridgeGame().retry(gameCommand);

        return tryCount;
    }

    @Override
    public int move() {
        return super.move();
    }

    public UserInterface getUserInterface() {
        return userInterface;
    }



}
