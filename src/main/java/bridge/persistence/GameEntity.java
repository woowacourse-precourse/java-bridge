package bridge;

import static bridge.BridgeStructure.FALSE;
import static bridge.BridgeStructure.TRUE;
import static bridge.BridgeStructure.UN_KNOWN;
import static bridge.Expression.DOWN;
import static bridge.Expression.UP;

public class GameEntity extends BridgeGame implements GameRepository{
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
